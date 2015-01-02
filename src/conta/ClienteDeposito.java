package conta;

public class ClienteDeposito implements Runnable 
{
	private Banco banco;
	private int tipo;
	
	public ClienteDeposito(Banco banco, int tipo) 
	{
		this.banco = banco;
		this.tipo = tipo;
	}
	
	@Override
	public void run() 
	{
		int valor = tipo * 100;
		banco.depositar(valor);
	}

}
