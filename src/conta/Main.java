package conta;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main 
{
	private static final int QUANTIDADE_POR_TIPO_CLIENTES = 20;
	private static final int TOTAL_CLIENTES = QUANTIDADE_POR_TIPO_CLIENTES * 6;
	
	
	private static Random random = new Random( System.currentTimeMillis() );
	
	public static void main(String[] args) throws InterruptedException
	{
		Banco banco = new Banco();
		Thread caixa = new Thread( new Caixa(banco) );
		caixa.start();
		
		ExecutorService executor = Executors.newFixedThreadPool(20);
		
		int qtdDepositoTipo1 = 0;
		int qtdDepositoTipo2 = 0;
		int qtdDepositoTipo3 = 0;
		
		int qtdSaqueTipo1 = 0;
		int qtdSaqueTipo2 = 0;
		int qtdSaqueTipo3 = 0;
		
		int totalClientes = 0;
		
		while(totalClientes < TOTAL_CLIENTES )
		{
			int dado = random.nextInt(6) + 1;
			
			if(dado == 1 && qtdDepositoTipo1 < QUANTIDADE_POR_TIPO_CLIENTES)
			{
				Runnable clienteDepositoTipo1 = new ClienteDeposito(banco, 1);
				executor.execute(clienteDepositoTipo1);
				qtdDepositoTipo1++;
				totalClientes++;
			}
			
			if(dado == 2 && qtdDepositoTipo2 < QUANTIDADE_POR_TIPO_CLIENTES)
			{
				Runnable clienteDepositoTipo2 = new ClienteDeposito(banco, 2);
				executor.execute(clienteDepositoTipo2);
				qtdDepositoTipo2++;
				totalClientes++;
			}
			
			if(dado == 3 && qtdDepositoTipo3 < QUANTIDADE_POR_TIPO_CLIENTES)
			{
				Runnable clienteDepositoTipo3 = new ClienteDeposito(banco, 3);
				executor.execute(clienteDepositoTipo3);
				qtdDepositoTipo3++;
				totalClientes++;
			}
			
			if(dado == 4 && qtdSaqueTipo1 < QUANTIDADE_POR_TIPO_CLIENTES)
			{
				Runnable clienteSaqueTipo1 = new ClienteSaque(banco, 1);
				executor.execute(clienteSaqueTipo1);
				qtdSaqueTipo1++;
				totalClientes++;
			}
			
			if(dado == 5 && qtdSaqueTipo2 < QUANTIDADE_POR_TIPO_CLIENTES)
			{
				Runnable clienteSaqueTipo2 = new ClienteSaque(banco, 2);
				executor.execute(clienteSaqueTipo2);
				qtdSaqueTipo2++;
				totalClientes++;
			}
			
			if(dado == 6 && qtdSaqueTipo3 < QUANTIDADE_POR_TIPO_CLIENTES)
			{
				Runnable clienteSaqueTipo3 = new ClienteSaque(banco, 3);
				executor.execute(clienteSaqueTipo3);
				qtdSaqueTipo3++;
				totalClientes++;
			}
		}
		
		executor.shutdown();
		
		//System.out.println(banco.tamanhoDaFila());
		//System.out.println("Deposito Tipo 1: " + qtdDepositoTipo1 + " " + "Tipo 2: " + qtdDepositoTipo2 + " " + "Tipo 3: " + qtdDepositoTipo3);
		//System.out.println("Saque Tipo 1: " + qtdSaqueTipo1 + " " + "Tipo 2: " + qtdSaqueTipo2 + " " + "Tipo 3: " + qtdSaqueTipo3);
	}
}
