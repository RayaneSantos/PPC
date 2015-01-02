package conta;

public class Main {

	public static void main(String[] args) throws InterruptedException{
		Banco banco = new Banco();
		
		Thread[] cliente = new Thread[20];
		
		for(int i=0;i<20;i++)
		{
			cliente[i] = new Thread( new ClienteDeposito(banco) );
			cliente[i].start();
		}
	}

}
