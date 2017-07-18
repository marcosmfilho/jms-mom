package br.edu.ifce.space;

import java.util.ArrayList;

import net.jini.core.entry.Entry;
import net.jini.core.lease.Lease;
import net.jini.space.JavaSpace;

public class SpaceAmbientes {
	
	public JavaSpace space;
	
	public void connect() {
		try {
			System.out.println("Procurando pelo servico JavaSpace...");
			Lookup finder = new Lookup(JavaSpace.class);
			this.space = (JavaSpace) finder.getService();
			if (space == null) {
				System.out.println("O servico JavaSpace nao foi encontrado. Encerrando...");
			}else {
				System.out.println("O servico JavaSpace foi encontrado.");
				
				//CRIANDO UMA TUPLA ESPECIAL QUE IRÁ GUARDAR TODOS OS AMBIENTES
				//ESSA TUPLA SEMPRE VAI EXISTIR NO ESPAÇO
				//GUARDARÁ O NOME DE TODAS AS TUPLAS NO PARÂMETRO ARRAYAMBIENTES
				AmbienteEspecial ambienteEsp = new AmbienteEspecial();
				ArrayList<String> ambientes = new ArrayList<String>();
				ambienteEsp.arrayAmbientes = ambientes;
				this.addTupla(ambienteEsp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void addNaTuplaControle(String nomeAmbiente) throws Exception{
		AmbienteEspecial ambienteEsp = new AmbienteEspecial();
		ambienteEsp = (AmbienteEspecial) this.space.takeIfExists(ambienteEsp, null, 60 * 1000);
		if(ambienteEsp != null) {
			ArrayList<String> arrayControle = new ArrayList<>(ambienteEsp.arrayAmbientes);
			arrayControle.add(nomeAmbiente);
			ambienteEsp.arrayAmbientes = arrayControle;
			this.space.write(ambienteEsp, null, Lease.FOREVER);
			System.out.println("Escreveu na tupla d controle...");
		}
	}
	
	public void removeNaTuplaControle(String nomeAmbiente) throws Exception{
		AmbienteEspecial ambienteEsp = new AmbienteEspecial();
		ambienteEsp = (AmbienteEspecial) this.space.takeIfExists(ambienteEsp, null, 60 * 1000);
		if(ambienteEsp != null) {
			ArrayList<String> arrayControle = new ArrayList<>(ambienteEsp.arrayAmbientes);
			System.out.println(arrayControle);
			for(int i = 0; i < arrayControle.size(); i++) {
				if(arrayControle.get(i).equals(nomeAmbiente)) {
					arrayControle.remove(i);
				}
			}
			ambienteEsp.arrayAmbientes = arrayControle;
			this.space.write(ambienteEsp, null, Lease.FOREVER);
		}
	}
	
	public void mostraAmbientes() throws Exception {
		AmbienteEspecial ambienteEsp = new AmbienteEspecial();
		ambienteEsp = (AmbienteEspecial) this.space.readIfExists(ambienteEsp, null, 60 * 1000);
		if(ambienteEsp != null) {
			ArrayList<String> arrayControle = new ArrayList<>(ambienteEsp.arrayAmbientes);
			System.out.println(arrayControle);
		}
	}
	
	public void addTupla(Entry obj) throws Exception {
		this.space.write(obj, null, Lease.FOREVER);
	}
	
	public void removeTupla(Entry obj) throws Exception {
		this.space.takeIfExists(obj, null, 60 * 1000);
	}
	
	public void clearSpace() throws Exception {
		AmbienteEspecial ambienteEsp = new AmbienteEspecial();
		this.space.takeIfExists(ambienteEsp, null, 60 * 1000);
		
		Ambiente ambiente = new Ambiente();
		ambiente = (Ambiente) this.space.takeIfExists(ambiente, null, 60 * 1000);
		while(ambiente != null) {
			ambiente = (Ambiente) this.space.takeIfExists(ambiente, null, 60 * 1000);
		}
	}
	
	public void novoAmbiente(String nome) throws Exception{
		Ambiente ambiente = new Ambiente();
		ambiente.nomeAmbiente = nome;
		this.addNaTuplaControle(nome);
		this.addTupla(ambiente);
		System.out.println("Adicionou o ambiente " + nome);
	}
	
	public void removeAmbiente(String nome) throws Exception{
		Ambiente ambiente = new Ambiente();
		ambiente.nomeAmbiente = nome;
		this.removeNaTuplaControle(nome);
		this.removeTupla(ambiente);
		System.out.println("Removeu o ambiente " + nome);
	}
	
	public static void main(String[] args) {
		SpaceAmbientes spaceAux = new SpaceAmbientes();
		spaceAux.connect();
		try {
			spaceAux.novoAmbiente("amb1");
			spaceAux.novoAmbiente("amb2");
			spaceAux.novoAmbiente("amb3");
			System.out.println("");
			System.out.println("Ambientes:");
			spaceAux.mostraAmbientes();
			spaceAux.removeAmbiente("amb3");
			System.out.println("");
			System.out.println("Depois de remover:");
			spaceAux.mostraAmbientes();
			spaceAux.clearSpace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);

	}

}
