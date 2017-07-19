package br.edu.ifce.space;

import java.util.ArrayList;

import javax.swing.JOptionPane;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author marcosmfilho
 */
public class Painel extends javax.swing.JPanel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
     * Creates new form testeFrame
     */
	public SpaceAmbientes space;
    public Painel() {
		this.space = new SpaceAmbientes();
		this.space.connect();
//		try {
//			this.space.removeTodosAmbientes();
//			this.space.removeTodosDispositivos();
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        jCheckBoxMenuItem1 = new javax.swing.JCheckBoxMenuItem();
        selectCordenador = new javax.swing.JComboBox<>();
        mostraLogs = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        campoAmbientes = new javax.swing.JTextArea();
        jSeparator1 = new javax.swing.JSeparator();
        criarAmbiente = new javax.swing.JButton();
        addDispositivo = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        selectAmbientes2 = new javax.swing.JComboBox<>();
        selectDispositivos = new javax.swing.JComboBox<>();
        selectDispositivosTroca = new javax.swing.JComboBox<>();
        trocarAmbienteDispositivo = new javax.swing.JButton();
        removeAmbiente = new javax.swing.JButton();
        removeDispositivo = new javax.swing.JButton();
        selectAmbientesTroca = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        selectAmbienteDisp = new javax.swing.JComboBox<>();
        mostraDispositivosAmbiente = new javax.swing.JButton();
        jSeparator3 = new javax.swing.JSeparator();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        campoLogs = new javax.swing.JTextArea();
        selectAmbientes3 = new javax.swing.JComboBox<>();
        limparEspaco = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();

        jCheckBoxMenuItem1.setSelected(true);
        jCheckBoxMenuItem1.setText("jCheckBoxMenuItem1");

        selectCordenador.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));
        selectCordenador.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectCordenadorActionPerformed(evt);
            }
        });

        mostraLogs.setText("MOSTRA LOGS");
        mostraLogs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraLogsActionPerformed(evt);
            }
        });

        campoAmbientes.setColumns(20);
        campoAmbientes.setRows(5);
        jScrollPane2.setViewportView(campoAmbientes);

        criarAmbiente.setText("Criar Ambiente");
        criarAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                criarAmbienteActionPerformed(evt);
            }
        });

        addDispositivo.setText("Adicionar Dispositivo");
        addDispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addDispositivoActionPerformed(evt);
            }
        });

        jLabel1.setText("Ambientes");

        selectAmbientes2.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
//        selectAmbientes2.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                selectAmbientes2ActionPerformed(evt);
//            }
//        });

        selectDispositivos.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
//        selectDispositivos.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                selectDispositivosActionPerformed(evt);
//            }
//        });

        selectDispositivosTroca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
//        selectDispositivosTroca.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                selectDispositivosTrocaActionPerformed(evt);
//            }
//        });

        trocarAmbienteDispositivo.setText("Trocar");
        trocarAmbienteDispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                trocarAmbienteDispositivoActionPerformed(evt);
            }
        });

        removeAmbiente.setText("Remover Ambiente");
        removeAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeAmbienteActionPerformed(evt);
            }
        });

        removeDispositivo.setText("Remover Dispositivo");
        removeDispositivo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeDispositivoActionPerformed(evt);
            }
        });

        selectAmbientesTroca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {}));
//        selectAmbientesTroca.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                selectAmbientesTrocaActionPerformed(evt);
//            }
//        });

        jLabel3.setText("Dispositivo");

        jLabel4.setText("Ambiente");

        selectAmbienteDisp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] {  }));
//        selectAmbienteDisp.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                selectAmbienteDispActionPerformed(evt);
//            }
//        });

        mostraDispositivosAmbiente.setText("Mostra Dispositivos");
        mostraDispositivosAmbiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                mostraDispositivosAmbienteActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Lato Semibold", 2, 24)); // NOI18N
        jLabel2.setText("JMS-MOM");

        campoLogs.setColumns(20);
        campoLogs.setRows(5);
        jScrollPane1.setViewportView(campoLogs);

        selectAmbientes3.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
//        selectAmbientes3.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                selectAmbientes3ActionPerformed(evt);
//            }
//        });

        limparEspaco.setText("Limpar Espaço");
        limparEspaco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                limparEspacoActionPerformed(evt);
            }
        });

        jLabel5.setText("Operações");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator3)
                    .addComponent(jSeparator1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(105, 105, 105)
                                .addComponent(jLabel1))
                            .addComponent(jLabel2))
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(criarAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(limparEspaco, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(selectCordenador, javax.swing.GroupLayout.PREFERRED_SIZE, 285, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(mostraLogs, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 279, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(selectDispositivos, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(removeDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 174, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectAmbienteDisp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(selectAmbientes2, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(selectAmbientes3, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(removeAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(mostraDispositivosAmbiente, javax.swing.GroupLayout.DEFAULT_SIZE, 174, Short.MAX_VALUE)
                                    .addComponent(addDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(selectDispositivosTroca, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel5))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addGap(0, 0, Short.MAX_VALUE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(selectAmbientesTroca, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(trocarAmbienteDispositivo, javax.swing.GroupLayout.DEFAULT_SIZE, 141, Short.MAX_VALUE)))))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(criarAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(limparEspaco, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jSeparator3, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectDispositivosTroca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectAmbientesTroca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(trocarAmbienteDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectAmbienteDisp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(mostraDispositivosAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectAmbientes3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(removeAmbiente, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(selectAmbientes2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(selectDispositivos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(removeDispositivo, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 32, Short.MAX_VALUE))
                    .addComponent(jScrollPane2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 7, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(selectCordenador, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(mostraLogs, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>  
    
    public void removeTodosItensSelectAmbiente() {
    	selectAmbientesTroca.removeAllItems();
    	selectAmbientes3.removeAllItems();
    	selectAmbientes2.removeAllItems();
    	selectAmbienteDisp.removeAllItems();
    }
    
    public void addTodosItensSelectAmbiente(String item) {
    	selectAmbientesTroca.addItem(item);
    	selectAmbientes3.addItem(item);
    	selectAmbientes2.addItem(item);
    	selectAmbienteDisp.addItem(item);
    }
    
    public void atualizaDispositivos() {
    	selectDispositivos.removeAllItems();
    	selectDispositivosTroca.removeAllItems();
    	try {
			ArrayList<String> arrayControle = this.space.getDispositivos();
    		for(int i = 0; i < arrayControle.size(); i++) {
    			selectDispositivos.addItem(arrayControle.get(i));
    			selectDispositivosTroca.addItem(arrayControle.get(i));
    		}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }

    private void selectCordenadorActionPerformed(java.awt.event.ActionEvent evt) {                                                 
            // TODO add your handling code here:
    }                                                

    private void addDispositivoActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
    	try {
    		String ambiente = selectAmbienteDisp.getSelectedItem().toString();
    		String disp = "disp" + this.space.getDispositivos().size();
			this.space.addDispositivo(ambiente, disp);
			JOptionPane.showMessageDialog(null, "Dispositivo adicionado com sucesso");
			this.atualizaDispositivos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possível adicionar o dispostivo");
			e.printStackTrace();
		}
    }                                              

    private void criarAmbienteActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
    	try {
    		String nomeAmbiente = "amb" + this.space.controleNumeroAmbientes();
			this.space.novoAmbiente(nomeAmbiente);
			campoAmbientes.setText("");
			this.removeTodosItensSelectAmbiente();
    		ArrayList<String> arrayControle = this.space.mostraAmbientes();
    		for(int i = 0; i < arrayControle.size(); i++) {
    			campoAmbientes.append(arrayControle.get(i) + "\n");
    			this.addTodosItensSelectAmbiente(arrayControle.get(i));
    		}
			JOptionPane.showMessageDialog(null, "O ambiente " + nomeAmbiente + " foi criado com sucesso");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possível criar o ambiente");
			e.printStackTrace();
		}
    }
                                            
    private void trocarAmbienteDispositivoActionPerformed(java.awt.event.ActionEvent evt) {                                                          
    	String ambienteTroca = selectAmbientesTroca.getSelectedItem().toString();
    	String dispositivoTroca = selectDispositivosTroca.getSelectedItem().toString();
    	try {
			this.space.alteraAmbienteDispositivo(ambienteTroca, dispositivoTroca);
			JOptionPane.showMessageDialog(null, "O dispositovo " + dispositivoTroca + " foi transferido para o ambiente " + ambienteTroca);
			this.atualizaDispositivos();
    	} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possível tranferir o ambiente de dispostivo");
			e.printStackTrace();
		}
    }                                                         

    private void mostraDispositivosAmbienteActionPerformed(java.awt.event.ActionEvent evt) {                                                           
    	String ambiente = selectAmbientes3.getSelectedItem().toString();;
    	try {
			ArrayList<String> arrayControle = this.space.getDispositivosPorAmbiente(ambiente);
			if(arrayControle.size() != 0 && arrayControle != null) {
				String nomes = "";
				for(String nome : arrayControle){
				   nomes += nome + "\n";
				}
				JOptionPane.showMessageDialog(null, nomes);
			}else {
				JOptionPane.showMessageDialog(null, "Nenhum dispostivo cadastrado no ambiente " + ambiente);
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }                                                          

    private void removeAmbienteActionPerformed(java.awt.event.ActionEvent evt) {                                               
        String ambienteRemover = selectAmbientes2.getSelectedItem().toString();;
    	try {
			this.space.removeAmbiente(ambienteRemover);
			campoAmbientes.setText("");
			this.removeTodosItensSelectAmbiente();
    		ArrayList<String> arrayControle = this.space.mostraAmbientes();
    		for(int i = 0; i < arrayControle.size(); i++) {
    			campoAmbientes.append(arrayControle.get(i) + "\n");
    			this.addTodosItensSelectAmbiente(arrayControle.get(i));
    		}
    		JOptionPane.showMessageDialog(null, ambienteRemover + " foi removido com sucesso");
    		this.atualizaDispositivos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possível remover o ambiente " + ambienteRemover);
			e.printStackTrace();
		}
    }                                              

    private void removeDispositivoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        String dispositivoRemover = selectDispositivos.getSelectedItem().toString();;
    	try {
			this.space.removeDispositivo(dispositivoRemover);
    		JOptionPane.showMessageDialog(null, dispositivoRemover + " foi removido com sucesso");
    		this.atualizaDispositivos();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possível remover o dispositvo " + dispositivoRemover);
			e.printStackTrace();
		}
    }
    
    private void limparEspacoActionPerformed(java.awt.event.ActionEvent evt) {                                                  
		try {
			campoAmbientes.setText("");
			this.space.removeTodosAmbientes();
			this.space.removeTodosDispositivos();
			this.space.removeTodosAmbientes();
			this.space.removeTodosDispositivos();
			this.space.connect();
			this.atualizaDispositivos();
			this.removeTodosItensSelectAmbiente();
			JOptionPane.showMessageDialog(null, "Espaço novinho em folha");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			JOptionPane.showMessageDialog(null, "Não foi possível limpar o espaço");
			e.printStackTrace();
		}
    }  

    private void mostraLogsActionPerformed(java.awt.event.ActionEvent evt) {                                           
        // TODO add your handling code here:
    }                                          

    // Variables declaration - do not modify                     
    private javax.swing.JButton addDispositivo;
    private javax.swing.JTextArea campoAmbientes;
    private javax.swing.JTextArea campoLogs;
    private javax.swing.JButton criarAmbiente;
    private javax.swing.JCheckBoxMenuItem jCheckBoxMenuItem1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JButton limparEspaco;
    private javax.swing.JButton mostraDispositivosAmbiente;
    private javax.swing.JButton mostraLogs;
    private javax.swing.JButton removeAmbiente;
    private javax.swing.JButton removeDispositivo;
    private javax.swing.JComboBox<String> selectAmbienteDisp;
    private javax.swing.JComboBox<String> selectAmbientes2;
    private javax.swing.JComboBox<String> selectAmbientes3;
    private javax.swing.JComboBox<String> selectAmbientesTroca;
    private javax.swing.JComboBox<String> selectCordenador;
    private javax.swing.JComboBox<String> selectDispositivos;
    private javax.swing.JComboBox<String> selectDispositivosTroca;
    private javax.swing.JButton trocarAmbienteDispositivo;
    // End of variables declaration    
    
    public static void main(String[] args) {
    	new InterfaceSpace();
    }
}
