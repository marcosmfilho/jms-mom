package br.edu.ifce.space;

import javax.swing.JFrame;

@SuppressWarnings("serial")
public class InterfaceSpace extends JFrame {
	
	SpaceAmbientes space;

	public InterfaceSpace() {
		super("Gerenciamente de Ambientes e Dispositivos - JavaSpace");
		Painel painel = new Painel();
		getContentPane().add(painel);
		this.setSize(500, 500);
		this.pack();
		this.setResizable(false);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
	}

	public static void main(String[] args) {		
		new InterfaceSpace();
	}
}