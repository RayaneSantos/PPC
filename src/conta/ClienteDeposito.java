package conta;

import java.util.Random;

public class ClienteDeposito implements Runnable 
{
	private Banco banco;
	private Random rando = new Random( System.currentTimeMillis() );
	
	public ClienteDeposito(Banco banco) 
	{
		this.banco = banco;
	}
	
	
	@Override
	public void run() {
		try {
			int valor = (rando.nextInt(3) + 1) * 100;
			banco.depositar(valor);
			Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	}

}
