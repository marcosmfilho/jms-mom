package br.edu.ifce.space;
import java.rmi.RemoteException;
import net.jini.core.lease.Lease;
import java.util.ArrayList;

import net.jini.core.entry.Entry;
import net.jini.core.entry.UnusableEntryException;
import net.jini.core.transaction.TransactionException;
import net.jini.space.JavaSpace;

public class Ambientes implements Entry{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JavaSpace space;
	public String nomeAmbiente;
	public ArrayList<String> arrayAmbientes;	
	
	public Ambientes() {
		
	}
	
	public Boolean connect() {
		try {
			System.out.println("Procurando pelo servico JavaSpace...");
			Lookup finder = new Lookup(JavaSpace.class);
			this.space = (JavaSpace) finder.getService();
			if (space == null) {
				System.out.println("O servico JavaSpace nao foi encontrado. Encerrando...");
				return false;
			}else {
				System.out.println("O servico JavaSpace foi encontrado.");
				
				//CRIANDO UMA TUPLA ESPECIAL QUE IRÁ GUARDAR TODOS OS AMBIENTES
				Ambientes ambienteEspecial = new Ambientes();
				ambienteEspecial.nomeAmbiente = "Controle";
				ArrayList<String> arrayAmbientes = new ArrayList<String>();
				ambienteEspecial.arrayAmbientes = arrayAmbientes;
				this.space.write(ambienteEspecial, null, Lease.FOREVER);
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public ArrayList<String> getAmbientesNoEspaco() {
		Ambientes controle = new Ambientes();
		controle.nomeAmbiente = "Controle";
		try {
			Ambientes ambienteControle = (Ambientes) this.space.readIfExists(controle, null, 2*1000);
			return ambienteControle.arrayAmbientes;
		} catch (RemoteException | UnusableEntryException | TransactionException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
	
	public ArrayList<String> ambientesNoEspaco() {
		Ambientes controle = new Ambientes();
		controle.nomeAmbiente = "Controle";
		try {
			Ambientes ambienteControle = (Ambientes) this.space.take(controle, null, 0);
			return ambienteControle.arrayAmbientes;
		} catch (RemoteException | UnusableEntryException | TransactionException | InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}	
		
	}
	
	public void addNoAmbienteDeControle(String nome) throws RemoteException, TransactionException {
		ArrayList<String> arrayControle = new ArrayList<>(ambientesNoEspaco());
		arrayControle.add(nome);
//		System.out.println(arrayControle);
		Ambientes controle = new Ambientes();
		controle.nomeAmbiente = "Controle";
		controle.arrayAmbientes = arrayControle;
		this.space.write(controle, null, Lease.FOREVER);
	}
	
	public void removeNoAmbienteDeControle(String nome) throws RemoteException, TransactionException {
		ArrayList<String> arrayControle = new ArrayList<>(ambientesNoEspaco());
		arrayControle.remove(nome);
		Ambientes controle = new Ambientes();
		controle.nomeAmbiente = "Controle";
		controle.arrayAmbientes = arrayControle;
		this.space.write(controle, null, Lease.FOREVER);
	}
	
	
	public void mostraAmbientes() throws RemoteException, UnusableEntryException, TransactionException, InterruptedException{
		int totalAmbientes = getAmbientesNoEspaco().size();
		System.out.println("");
		System.out.println("Ambientes: ");
		for (int i = 0; i<= totalAmbientes-1; i++) {
			System.out.println(getAmbientesNoEspaco().get(i));
		}
		
		System.out.println("Número de ambientes: " + totalAmbientes);
	}
	
	public void novoAmbiente(String nome) throws Exception{
		Ambientes ambiente = new Ambientes();
		ambiente.nomeAmbiente = nome;
		
		//ADICIONA O AMBIENTE NA TUPLA ESPECIAL DE CONTROLE
		addNoAmbienteDeControle(nome);
		
		//ADICIONA A TUPLA NO ESPAÇO
		this.space.write(ambiente, null, Lease.FOREVER);
	}
	
	public void removeAmbiente(String nome) throws Exception{
		Ambientes ambiente = new Ambientes();
		ambiente.nomeAmbiente = nome;
		
		//REMOVE O AMBIENTE NA TUPLA ESPECIAL DE CONTROLE
		addNoAmbienteDeControle(nome);
		
		//REMOVE A TUPLA DO ESPAÇO
		System.out.println("removendo o ambiente " + nome);
		this.space.take(ambiente, null, 0);
	}

	public static void main(String[] args) throws Exception {
		Ambientes test = new Ambientes();
		test.connect();
		test.novoAmbiente("amb1");
		test.novoAmbiente("amb2");
		test.novoAmbiente("amb3");
		test.mostraAmbientes();
//		test.removeAmbiente("amb2");
//		System.out.println("Depois de remover:");
//		test.mostraAmbientes();
	}

}
