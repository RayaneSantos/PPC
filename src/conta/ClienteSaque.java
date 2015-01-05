package conta;

public class ClienteSaque extends Cliente implements Runnable
{
	private int valor;
	
	public ClienteSaque(Banco banco, int tipo) 
	{
		super(banco, tipo);
	}
	
	@Override
	public void run() 
	{
		valor = getTipo() * 100;
		getBanco().entrarNaFila(this);
	}
	
	public int getValor() { return valor; }
}
