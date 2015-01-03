package conta;

public class Caixa implements Runnable 
{
	private Banco banco;
	
	public Caixa(Banco banco)
	{
		this.banco = banco;
	}
	
	@Override
	public void run() 
	{
		while(true) {
			banco.atenderCliente();
		}
	}
}
