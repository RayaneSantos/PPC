package conta;

public class ClienteSaque implements Runnable
{
	private Banco banco;
	private int tipo;
	
	public ClienteSaque(Banco banco, int tipo) 
	{
		this.banco = banco;
		this.tipo = tipo;
	}
	
	@Override
	public void run() {
	
		banco.entrarNaFila(this);
		banco.sacar(tipo * 100);

		} 

}
