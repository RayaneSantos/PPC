package conta;

import java.util.Queue;
import java.util.concurrent.LinkedBlockingDeque;

public class Banco 
{
	private int saldo;
	private Queue<Cliente> fila = new LinkedBlockingDeque<Cliente>();
	
	public int getSaldo() { return saldo; }
	
	public int tamanhoDaFila() { return fila.size(); }
	
	public synchronized void entrarNaFila(Cliente cliente) { fila.add(cliente); }
	
	public synchronized void atenderCliente() 
	{	
		if( !fila.isEmpty() )
		{
			System.out.println("Tamanho da fila: " + fila.size() );
			
			ClienteSaque cliente = (ClienteSaque) fila.remove();
			
			try 
			{	
				if( saldo >= cliente.getValor() )
				{
					saldo -= cliente.getValor();
					Thread.sleep(2000);
					System.out.println("Saque R$ " + cliente.getValor());
					System.out.println("Saldo atual do banco: " + getSaldo());
					notifyAll();
				} 
				else {
					wait();
				}	
			} 
			catch (InterruptedException e) {
				System.err.println( e.getMessage() );
			}
		}
	}
	
	public synchronized void depositar(int valor) throws InterruptedException
	{
		System.out.println("Deposito R$ " + valor);
		saldo += valor;
		Thread.sleep(2000);
		System.out.println("Saldo atual do banco: " + getSaldo());
		notifyAll();
	}
}
