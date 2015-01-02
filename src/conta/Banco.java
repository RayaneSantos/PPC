package conta;

import java.util.Vector;

public class Banco {
	private int saldo;
	private Vector<ClienteSaque> fila = new Vector<ClienteSaque>();
	
	public int getSaldo()
	{
		return saldo;
	}
	
	public void entrarNaFila(ClienteSaque cliente)
	{
		fila.add(cliente);
	}
	
	public synchronized void sacar(int valor)
	{
		if( !fila.isEmpty() )
		{
			try {
				ClienteSaque cliente = fila.elementAt(0);	
				if(saldo >= valor)
				{
					fila.remove(0);
					saldo -= valor;
					System.out.println("Saldo atual do banco: " + getSaldo());
					notifyAll();
				} 
				else {
					cliente.wait();
				}	
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
		}
	}
	
	public synchronized void depositar(int valor)
	{
		saldo += valor;
		System.out.println("Saldo atual do banco: " + getSaldo());
		notifyAll();
	}
	
	public static void mostrarMensagem(String mensagem)
	{
		String nomeThread = Thread.currentThread().getName();
		System.out.println("Cliente: " + nomeThread);
	}

}
