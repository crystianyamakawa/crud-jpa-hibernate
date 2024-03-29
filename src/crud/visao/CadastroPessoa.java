/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud.visao;

import java.awt.List;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import crud.App;
import crud.dao.CidadeDAO;
import crud.dao.PessoaDAO;

/**
 *
 * @author crystian
 */
public class CadastroPessoa extends javax.swing.JFrame {

    /**
     * Creates new form CadastroPessoa
     */
    public CadastroPessoa() {
        initComponents();
        preencherComboCidades();
        atualizarListaPessoas();
        }
   

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        campoId = new javax.swing.JTextField();
        btConsultar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        campoTel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        campoEnd = new javax.swing.JTextField();
        comboCidade = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        btIncluir = new javax.swing.JButton();
        btAlterar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        panelPessoas = new javax.swing.JTextPane();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro Pessoa");

        jLabel1.setText("Id:");

        btConsultar.setText("Consultar");
        btConsultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btConsultarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nome:");

        jLabel3.setText("Telefone");

        jLabel4.setText("Endereco:");

        comboCidade.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jLabel5.setText("Cidade:");

        btIncluir.setText("Incluir");
        btIncluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btIncluirActionPerformed(evt);
            }
        });

        btAlterar.setText("Alterar");
        btAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btAlterarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(panelPessoas);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel5))
                                .addGap(2, 2, 2)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(comboCidade, 0, 270, Short.MAX_VALUE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btConsultar))
                                    .addComponent(campoNome)
                                    .addComponent(campoTel, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(campoEnd)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btIncluir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 76, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 96, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoId, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoTel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(campoEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(comboCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btIncluir)
                    .addComponent(btAlterar)
                    .addComponent(btExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 205, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btConsultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btConsultarActionPerformed

        // TODO add your handling code here:
    	if (campoId.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Informar um id para consultar", "Erro de Operação", getDefaultCloseOperation());
    		return;
    	}
    	
       	if (!App.isNumeric(campoId.getText())) {
    		JOptionPane.showMessageDialog(null, "Informar um id valido", "Erro de Operação", getDefaultCloseOperation());
    		return;
    	}
   	
    	PessoaDAO dao = new PessoaDAO();
       	List ls = dao.getPessoa(campoId.getText());
        campoId.setText(ls.getItem(0));
        campoNome.setText(ls.getItem(1));
        campoTel.setText(ls.getItem(2));
        campoEnd.setText(ls.getItem(3));
        comboCidade.setSelectedItem(ls.getItem(4));

        
    	
    }//GEN-LAST:event_btConsultarActionPerformed

    private void btIncluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btIncluirActionPerformed
        // TODO add your handling code here:
    	if (campoNome.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Informar um nome para incluir", "Erro de Operação", getDefaultCloseOperation());
    		return;
    	}
    	try {
    	
    		PessoaDAO dao = new PessoaDAO();
    		dao.addPessoa(campoNome.getText(),
    				      campoTel.getText(),
    				      campoEnd.getText(),
    				      comboCidade.getSelectedItem().toString());
    	}
    	catch (SQLException e) {
          	JOptionPane.showMessageDialog(null,"Verifique os dados informado!", "Erro de Operação", getDefaultCloseOperation());
            
    	}
    	finally{
    		atualizarListaPessoas();
    	}
    
    
    }//GEN-LAST:event_btIncluirActionPerformed

    private void btAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btAlterarActionPerformed
        // TODO add your handling code here:
    	if (campoId.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Informar um id para consultar", "Erro de Operação", getDefaultCloseOperation());
    		return;
    	}
    	
       	if (!App.isNumeric(campoId.getText())) {
    		JOptionPane.showMessageDialog(null, "Informar um id valido", "Erro de Operação", getDefaultCloseOperation());
    		return;
    	}
 
       	if (campoNome.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Informar um nome para alterar", "Erro de Operação", getDefaultCloseOperation());
    		return;
    	}
       	
       	try {
       		PessoaDAO dao = new PessoaDAO();
            dao.updatePessoa( campoNome.getText(),campoTel.getText(),campoEnd.getText(),comboCidade.getSelectedItem().toString(), campoId.getText());
       	}
    	catch (SQLException e) {
          	JOptionPane.showMessageDialog(null,"Verifique os dados informado!", "Erro de Operação", getDefaultCloseOperation());
       		
       	}
       	finally {
            atualizarListaPessoas();
       	}
	
    }//GEN-LAST:event_btAlterarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        // TODO add your handling code here:
    	if (campoId.getText().isEmpty()) {
    		JOptionPane.showMessageDialog(null, "Informar um id para excluir", "Erro de Operação", getDefaultCloseOperation());
    		return;
    	}
    	
       	if (!App.isNumeric(campoId.getText())) {
    		JOptionPane.showMessageDialog(null, "Informar um id valido", "Erro de Operação", getDefaultCloseOperation());
    		return;
    	}
       	
       	PessoaDAO dao = new PessoaDAO();
       	 
       	dao.delPessoa(campoId.getText());
        atualizarListaPessoas();    	
    	
    }//GEN-LAST:event_btExcluirActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(CadastroPessoa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CadastroPessoa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btAlterar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btIncluir;
    private javax.swing.JTextField campoEnd;
    private javax.swing.JTextField campoId;
    private javax.swing.JTextField campoNome;
    private javax.swing.JTextField campoTel;
    private javax.swing.JComboBox<String> comboCidade;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextPane panelPessoas;
    // End of variables declaration//GEN-END:variables
    
    
    private void atualizarListaPessoas() {
        try {
         	PessoaDAO dao = new PessoaDAO();
         	List ls = dao.getPessoas();
          	String lsPessoas = "";
         	for (int i = 0; i < ls.countItems(); i++)  {
                 lsPessoas += ls.getItem(i) + "\n";
             }
         	panelPessoas.setText(lsPessoas);
         } catch (Exception e) {
             e.printStackTrace();
         }
     }

     private void preencherComboCidades() {
         try {
             CidadeDAO dao = new CidadeDAO();
             List ls = dao.getComboCidades();
             comboCidade.removeAllItems();
             String lsCidades = "";
         	for (int i = 0; i < ls.countItems(); i++)  {
                 comboCidade.addItem(ls.getItem(i));
             }
             
         } catch (Exception e) {
             e.printStackTrace();
         }
     }
    
}
