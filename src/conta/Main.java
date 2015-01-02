package conta;

import java.util.Random;

public class Main 
{
	private static Random random = new Random( System.currentTimeMillis() );
	
	public static void main(String[] args) throws InterruptedException
	{
		Banco banco = new Banco();
		
		Thread clienteDepositoTipo1 = null;
		Thread clienteDepositoTipo2 = null;
		Thread clienteDepositoTipo3 = null;
		
		Thread clienteSaqueTipo1 = null;
		Thread clienteSaqueTipo2 = null;
		Thread clienteSaqueTipo3 = null;
		
		int qtdDepositoTipo1 = 0;
		int qtdDepositoTipo2 = 0;
		int qtdDepositoTipo3 = 0;
		
		int qtdSaqueTipo1 = 0;
		int qtdSaqueTipo2 = 0;
		int qtdSaqueTipo3 = 0;
		
		int totalClientes = 0;
		
		while(totalClientes < 120 )
		{
			int moeda = random.nextInt(6) + 1;
			
			if(moeda == 1 && qtdDepositoTipo1 < 20)
			{
				clienteDepositoTipo1 = new Thread( new ClienteDeposito(banco, 1) );
				clienteDepositoTipo1.start();
				qtdDepositoTipo1++;
				totalClientes++;
			}
			
			if(moeda == 2 && qtdDepositoTipo2 < 20)
			{
				clienteDepositoTipo2 = new Thread( new ClienteDeposito(banco, 2) );
				clienteDepositoTipo2.start();
				qtdDepositoTipo2++;
				totalClientes++;
			}
			
			if(moeda == 3 && qtdDepositoTipo3 < 20)
			{
				clienteDepositoTipo3 = new Thread( new ClienteDeposito(banco, 3) );
				clienteDepositoTipo3.start();
				qtdDepositoTipo3++;
				totalClientes++;
			}
			
			if(moeda == 4 && qtdSaqueTipo1 < 20)
			{
				clienteSaqueTipo1 = new Thread( new ClienteSaque(banco, 1) );
				clienteSaqueTipo1.start();
				qtdSaqueTipo1++;
				totalClientes++;
			}
			
			if(moeda == 5 && qtdSaqueTipo2 < 20)
			{
				clienteSaqueTipo2 = new Thread( new ClienteSaque(banco, 2) );
				clienteSaqueTipo2.start();
				qtdSaqueTipo2++;
				totalClientes++;
			}
			
			if(moeda == 6 && qtdSaqueTipo3 < 20)
			{
				clienteSaqueTipo3 = new Thread( new ClienteSaque(banco, 3) );
				clienteSaqueTipo3.start();
				qtdSaqueTipo3++;
				totalClientes++;
			}
			
			Thread.sleep(2000);
		}
		
		//System.out.println("Deposito Tipo 1: " +  qtdDepositoTipo1 + " " + "Tipo 2: " +  qtdDepositoTipo2 + " " + "Tipo 3: " +  qtdDepositoTipo3);
		//System.out.println("Saque Tipo 1: " +  qtdSaqueTipo1 + " " + "Tipo 2: " +  qtdSaqueTipo2 + " " + "Tipo 3: " +  qtdSaqueTipo3);
	}
}
