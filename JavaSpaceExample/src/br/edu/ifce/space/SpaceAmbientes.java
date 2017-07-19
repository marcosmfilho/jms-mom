package br.edu.ifce.space;

import java.util.ArrayList;

import net.jini.core.entry.Entry;
import net.jini.core.lease.Lease;
import net.jini.space.JavaSpace;

public class SpaceAmbientes {
	
	public JavaSpace space;
	public ArrayList<String> ambientes = new ArrayList<String>();
	
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
				ambienteEsp.arrayAmbientes = ambientes;
				this.addTupla(ambienteEsp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	//MÉTODOS PARA AS TUPLAS DO TIPO <AMBIENTE>
	
	public void addNaTuplaControle(String nomeAmbiente) throws Exception{
		AmbienteEspecial template = new AmbienteEspecial();
		AmbienteEspecial ambienteEsp = (AmbienteEspecial) this.space.takeIfExists(template, null, 60 * 1000);
		if(ambienteEsp != null) {
			ArrayList<String> arrayControle = ambienteEsp.arrayAmbientes;
			arrayControle.add(nomeAmbiente);			
			AmbienteEspecial ambienteAux = new AmbienteEspecial();
			ambienteAux.arrayAmbientes = arrayControle;
			this.space.write(ambienteAux, null, Lease.FOREVER);
		}
	}
	
	public void removeNaTuplaControle(String nomeAmbiente) throws Exception{
		AmbienteEspecial template = new AmbienteEspecial();
		AmbienteEspecial ambienteEsp = (AmbienteEspecial) this.space.takeIfExists(template, null, 60 * 1000);
		if(ambienteEsp != null) {
			ArrayList<String> arrayControle = ambienteEsp.arrayAmbientes;
			System.out.println(arrayControle);
			for(int i = 0; i < arrayControle.size(); i++) {
				if(arrayControle.get(i).equals(nomeAmbiente)) {
					arrayControle.remove(i);
				}
			}
			AmbienteEspecial ambienteAux = new AmbienteEspecial();
			ambienteAux.arrayAmbientes = arrayControle;
			this.space.write(ambienteAux, null, Lease.FOREVER);
		}
	}
	
	public int controleNumeroAmbientes() throws Exception {
		AmbienteEspecial template = new AmbienteEspecial();
		AmbienteEspecial ambienteEsp = (AmbienteEspecial) this.space.readIfExists(template, null, 60 * 1000);
		return ambienteEsp.arrayAmbientes.size();
	}
	
	public ArrayList<String> mostraAmbientes() throws Exception {
		AmbienteEspecial template = new AmbienteEspecial();
		AmbienteEspecial ambienteEsp = (AmbienteEspecial) this.space.readIfExists(template, null, 60 * 1000);
		if (ambienteEsp != null) {
			System.out.println(ambienteEsp.arrayAmbientes);
			return ambienteEsp.arrayAmbientes;
		}else {
			ArrayList<String> vazio = new ArrayList<String>();
			return vazio;
		}
	}
	
	public void addTupla(Entry obj) throws Exception {
		this.space.write(obj, null, Lease.FOREVER);
	}
	
	public void removeTupla(Entry obj) throws Exception {
		this.space.takeIfExists(obj, null, 60 * 1000);
	}
	
	public void removeTodosAmbientes() throws Exception {
		AmbienteEspecial templateEsp = new AmbienteEspecial();
		AmbienteEspecial ambienteEsp = new AmbienteEspecial();
		ambienteEsp = (AmbienteEspecial) this.space.takeIfExists(templateEsp, null, 60 * 1000);
		while(ambienteEsp != null) {
			ambienteEsp = (AmbienteEspecial) this.space.takeIfExists(templateEsp, null, 60 * 1000);
		}
		
		Ambiente template = new Ambiente();
		Ambiente ambiente = (Ambiente) this.space.takeIfExists(template, null, 60 * 1000);
		while(ambiente != null) {
			ambiente = (Ambiente) this.space.takeIfExists(template, null, 60 * 1000);
		}
	}
	
	public void novoAmbiente(String nome) throws Exception{
		Ambiente ambiente = new Ambiente();
		ambiente.nomeAmbiente = nome;
		this.addTupla(ambiente);
		System.out.println("Adicionou o ambiente " + nome);
		this.addNaTuplaControle(nome);
	}
	
	public void removeAmbiente(String nome) throws Exception{
		Ambiente ambiente = new Ambiente();
		ambiente.nomeAmbiente = nome;
		this.removeTupla(ambiente);
		this.removeTodosDispositivosPorAmbiente(nome);
		System.out.println("Removeu o ambiente " + nome);
		this.removeNaTuplaControle(nome);
	}
	
	//MÉTODOS PARA AS TUPLAS DO TIPO <DISPOSITIVO, AMBIENTE>
	
	public void addDispositivo(String nomeAmbiente, String nomeDispositivo) throws Exception {
		Ambiente ambiente = new Ambiente();
		ambiente.nomeAmbiente = nomeAmbiente;
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.nomeDispositivo = nomeDispositivo;
		dispositivo.ambienteDispositivo = ambiente;
		this.space.write(dispositivo, null, Lease.FOREVER);
	}
	
	public void removeDispositivo(String nomeDispositivo) throws Exception {
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.nomeDispositivo = nomeDispositivo;
		this.space.takeIfExists(dispositivo, null, 60 * 1000);
	}
	
	public void alteraAmbienteDispositivo(String nomeAmbiente, String nomeDispositivo) throws Exception {
		Dispositivo template = new Dispositivo();
		template.nomeDispositivo = nomeDispositivo;
		Dispositivo dispositivo = (Dispositivo) this.space.takeIfExists(template, null, 60 * 1000);
		System.out.println(dispositivo);
		if(dispositivo != null) {
			Ambiente ambiente = new Ambiente();
			ambiente.nomeAmbiente = nomeAmbiente;
			Dispositivo dispositivoAux = new Dispositivo();
			dispositivoAux.nomeDispositivo = nomeDispositivo;
			dispositivoAux.ambienteDispositivo = ambiente;
			System.out.println("Reescreveu o dispositivo " + dispositivoAux.nomeDispositivo + " Ambiente " + dispositivoAux.ambienteDispositivo);
			this.space.write(dispositivoAux, null, Lease.FOREVER);
		}
	}
	
	public void removeTodosDispositivosPorAmbiente(String nomeAmbiente) throws Exception {
		Ambiente ambiente = new Ambiente();
		ambiente.nomeAmbiente = nomeAmbiente;		
		Dispositivo template = new Dispositivo();
		template.ambienteDispositivo = ambiente;	
		Dispositivo dispositivo = (Dispositivo) this.space.takeIfExists(template, null, 60 * 1000);
		while(dispositivo != null) {
			dispositivo = (Dispositivo) this.space.takeIfExists(template, null, 60 * 1000);
		}
	}
	
	public void removeTodosDispositivos() throws Exception {
		Dispositivo template = new Dispositivo();
		Dispositivo dispositivo = (Dispositivo) this.space.takeIfExists(template, null, 60 * 1000);
		while(dispositivo != null) {
			dispositivo = (Dispositivo) this.space.takeIfExists(template, null, 60 * 1000);
		}
	}
	
	public ArrayList<String> getDispositivosPorAmbiente(String nomeAmbiente) throws Exception {
		ArrayList<String> dispositivosPorAmbiente = new ArrayList<String>();
		Ambiente ambiente = new Ambiente();
		ambiente.nomeAmbiente = nomeAmbiente;
		Dispositivo template = new Dispositivo();
		template.ambienteDispositivo = ambiente;	
		Dispositivo dispositivo = (Dispositivo) this.space.takeIfExists(template, null, 60 * 1000);
		while(dispositivo != null) {
			System.out.println("Guardei um dispositivo.. " + dispositivo.nomeDispositivo);
			dispositivosPorAmbiente.add(dispositivo.nomeDispositivo);
			dispositivo = (Dispositivo) this.space.takeIfExists(template, null, 60 * 1000);
		}
		for(int i = 0; i<dispositivosPorAmbiente.size(); i++) {
			Dispositivo dispositivoAux = new Dispositivo();
			dispositivoAux.ambienteDispositivo = ambiente;
			dispositivoAux.nomeDispositivo = dispositivosPorAmbiente.get(i);
			this.space.write(dispositivoAux, null, Lease.FOREVER);
		}
		return dispositivosPorAmbiente;
	}
	
	public ArrayList<String> getDispositivos() throws Exception {
		ArrayList<Dispositivo> dispositivos = new ArrayList<Dispositivo>();
		ArrayList<String> dispositivosNomes = new ArrayList<String>();
		Dispositivo template = new Dispositivo();
		Dispositivo dispositivo = (Dispositivo) this.space.takeIfExists(template, null, 60 * 1000);
		while(dispositivo != null) {
			dispositivos.add(dispositivo);
			dispositivo = (Dispositivo) this.space.takeIfExists(template, null, 60 * 1000);
		}
		for(int i = 0; i<dispositivos.size(); i++) {
			dispositivosNomes.add(dispositivos.get(i).nomeDispositivo);
			this.space.write(dispositivos.get(i), null, Lease.FOREVER);
		}
		return dispositivosNomes;
	}
	
	public static void main(String[] args) {
		SpaceAmbientes spaceAux = new SpaceAmbientes();
		spaceAux.connect();
		try {
//			spaceAux.novoAmbiente("amb1");
//			spaceAux.novoAmbiente("amb2");
//			spaceAux.novoAmbiente("amb3");
//			spaceAux.mostraAmbientes();
//			spaceAux.removeAmbiente("amb2");
//			spaceAux.mostraAmbientes();
//			spaceAux.addDispositivo("amb1", "disp1");
//			spaceAux.addDispositivo("amb1", "disp2");
//			spaceAux.addDispositivo("amb1", "disp3");
//			spaceAux.addDispositivo("amb2", "disp5");
//			spaceAux.addDispositivo("amb2", "disp9");
//			System.out.println("");
//			System.out.println("Os dispositivos do amb1 são: ");
//			System.out.println(spaceAux.getDispositivosPorAmbiente("amb1"));
//			System.out.println("");
//			System.out.println("Os dispositivos do amb2 são: ");
//			System.out.println(spaceAux.getDispositivosPorAmbiente("amb2"));
//			spaceAux.removeDispositivo("disp2");
//			System.out.println("");
//			System.out.println("Depois de remover o disp2: ");
//			System.out.println("Os dispositivos do amb1 são: ");
//			System.out.println(spaceAux.getDispositivosPorAmbiente("amb1"));
//			System.out.println("");
//			System.out.println("Removendo o amb1...");
//			spaceAux.removeAmbiente("amb1");
//			System.out.println("Os dispositivos do amb1 são: ");
//			System.out.println(spaceAux.getDispositivosPorAmbiente("amb1"));
//			System.out.println("");
//			System.out.println("No fim, ambientes: ");
			spaceAux.mostraAmbientes();
			spaceAux.removeTodosAmbientes();
			spaceAux.removeTodosDispositivos();
			spaceAux.mostraAmbientes();
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
	}
	
//public static void main(String[] args) {
//	SpaceAmbientes spaceAux = new SpaceAmbientes();
//	spaceAux.connect();
//	try {
//		spaceAux.removeTodosAmbientes();
//		spaceAux.removeTodosDispositivos();
//	} catch (Exception e) {
//		e.printStackTrace();
//	}
//	System.exit(0);
//}

}
