package conta;

import java.util.Random;

public class Main 
{
	private static Random random = new Random( System.currentTimeMillis() );
	
	public static void main(String[] args) throws InterruptedException
	{
		Banco banco = new Banco();
		
		Thread clienteTipo1 = null;
		Thread clienteTipo2 = null;
		Thread clienteTipo3 = null;
		
		int qtdTipo1 = 0;
		int qtdTipo2 = 0;
		int qtdTipo3 = 0;
		
		int totalClientes = 0;
		
		while(totalClientes < 60 )
		{
			int moeda = random.nextInt(3) + 1;
			
			if(moeda == 1 && qtdTipo1 < 20)
			{
				clienteTipo1 = new Thread( new ClienteDeposito(banco, 1) );
				clienteTipo1.start();
				qtdTipo1++;
				totalClientes++;
			}
			
			if(moeda == 2 && qtdTipo2 < 20)
			{
				clienteTipo2 = new Thread( new ClienteDeposito(banco, 2) );
				clienteTipo2.start();
				qtdTipo2++;
				totalClientes++;
			}
			
			if(moeda == 3 && qtdTipo3 < 20)
			{
				clienteTipo3 = new Thread( new ClienteDeposito(banco, 3) );
				clienteTipo3.start();
				qtdTipo3++;
				totalClientes++;
			}
		}
		
		//System.out.println("Tipo 1: " +  qtdTipo1 + " " + "Tipo 2: " +  qtdTipo2 + " " + "Tipo 3: " +  qtdTipo3);
	}
}
