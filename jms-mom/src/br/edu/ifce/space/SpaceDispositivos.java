package br.edu.ifce.space;

import java.util.ArrayList;

import net.jini.core.lease.Lease;
import net.jini.space.JavaSpace;

public class SpaceDispositivos {
	
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
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
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
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.nomeDispositivo = nomeDispositivo;
		dispositivo = (Dispositivo) this.space.takeIfExists(dispositivo, null, 60 * 1000);
		if(dispositivo != null) {
			Ambiente ambiente = new Ambiente();
			ambiente.nomeAmbiente = nomeAmbiente;
			dispositivo.ambienteDispositivo = ambiente;
			this.space.write(dispositivo, null, Lease.FOREVER);
		}
	}
	
	public void removeTodosDispositivosPorAmbiente(String nomeAmbiente) throws Exception {
		Ambiente ambiente = new Ambiente();
		ambiente.nomeAmbiente = nomeAmbiente;		
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.ambienteDispositivo = ambiente;	
		dispositivo = (Dispositivo) this.space.takeIfExists(dispositivo, null, 60 * 1000);
		while(dispositivo != null) {
			dispositivo = (Dispositivo) this.space.takeIfExists(dispositivo, null, 60 * 1000);
		}
	}
	
	public ArrayList<String> getDispositivosPorAmbiente(String nomeAmbiente) throws Exception {
		ArrayList<String> dispositivosPorAmbiente = new ArrayList<String>();
		Ambiente ambiente = new Ambiente();
		ambiente.nomeAmbiente = nomeAmbiente;
		Dispositivo dispositivo = new Dispositivo();
		dispositivo.ambienteDispositivo = ambiente;	
		dispositivo = (Dispositivo) this.space.readIfExists(dispositivo, null, 60 * 1000);
		while(dispositivo != null) {
			dispositivosPorAmbiente.add(dispositivo.nomeDispositivo);
			dispositivo = (Dispositivo) this.space.readIfExists(dispositivo, null, 60 * 1000);
		}
		return dispositivosPorAmbiente;
	}
	
	public static void main(String[] args) {
		SpaceDispositivos spaceAux = new SpaceDispositivos();
		spaceAux.connect();
		try {
			spaceAux.addDispositivo("amb1", "disp1");
			spaceAux.addDispositivo("amb1", "disp2");
			spaceAux.addDispositivo("amb1", "disp3");
			spaceAux.addDispositivo("amb2", "disp4");
			spaceAux.addDispositivo("amb3", "disp5");
			System.out.println("");
			System.out.println("Dispositivos no amb1:");
			System.out.println(spaceAux.getDispositivosPorAmbiente("amb1"));
			System.out.println("");
			System.out.println("Removendo o disp2:");
			spaceAux.removeDispositivo("disp2");
			System.out.println("");
			System.out.println("Dispositivos no amb1:");
			System.out.println(spaceAux.getDispositivosPorAmbiente("amb1"));
			System.out.println("");
			System.out.println("Removendo todos os dispositivos do amb1...:");
			spaceAux.removeTodosDispositivosPorAmbiente("amb1");
			System.out.println("");
			System.out.println("Dispositivos no amb1:");
			System.out.println(spaceAux.getDispositivosPorAmbiente("amb1"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);

	}

}
