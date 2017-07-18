package br.edu.ifce.space;
import java.util.ArrayList;

import net.jini.core.entry.Entry;

public class AmbienteEspecial implements Entry{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public String nome;
	public ArrayList<String> arrayAmbientes;	
	
	public AmbienteEspecial() {
		this.nome = "controle";
	}
}
