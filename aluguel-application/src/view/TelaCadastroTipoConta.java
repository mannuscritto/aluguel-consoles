/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.TipoConsole;
import model.bean.TipoConta;
import model.dao.TipoConsoleDAO;
import model.dao.TipoContaDAO;

/**
 *
 * @author romer
 */
public class TelaCadastroTipoConta extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroTipoConta
     */
    public TelaCadastroTipoConta() {
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        readJTable();
    }
    
    public void readJTable() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtbTipoConta.getModel();
        modelo.setNumRows(0);
        TipoContaDAO tcdao = new TipoContaDAO();
        
        for (TipoConta tc: tcdao.read()) {
            modelo.addRow(new Object[] {
               tc.getId(),
               tc.getTitulo(),
               tc.getPrecoCompra()
            });
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel2 = new javax.swing.JLabel();
        jtfTitulo = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfPrecoCompra = new javax.swing.JTextField();
        jbtnCadastrar = new javax.swing.JButton();
        jbtnAtualizar = new javax.swing.JButton();
        jbtnExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTipoConta = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Tipo Conta");

        jLabel2.setText("Título");

        jLabel3.setText("Preço de Compra");

        jbtnCadastrar.setLabel("Cadastrar");
        jbtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCadastrarActionPerformed(evt);
            }
        });

        jbtnAtualizar.setLabel("Atualizar");
        jbtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAtualizarActionPerformed(evt);
            }
        });

        jbtnExcluir.setLabel("Excluir");
        jbtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcluirActionPerformed(evt);
            }
        });

        jtbTipoConta.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Titulo", "Preço de Compra"
            }
        ));
        jtbTipoConta.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTipoContaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTipoConta);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jtfPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCadastrar)
                    .addComponent(jbtnAtualizar)
                    .addComponent(jbtnExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 367, Short.MAX_VALUE)
                .addContainerGap())
        );

        setBounds(0, 0, 656, 519);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCadastrarActionPerformed
        // TODO add your handling code here:
        TipoConta tc = new TipoConta();
        TipoContaDAO dao = new TipoContaDAO();
        if (jtfPrecoCompra.getText().isEmpty() || jtfTitulo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Preencha os campos de texto!");
        } else {
            tc.setPrecoCompra(Double.parseDouble(jtfPrecoCompra.getText()));
            tc.setTitulo(jtfTitulo.getText());
            dao.create(tc);
            readJTable();   
        }
        
        jtfTitulo.setText("");
        jtfPrecoCompra.setText("");
    }//GEN-LAST:event_jbtnCadastrarActionPerformed

    private void jbtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAtualizarActionPerformed
        // TODO add your handling code here:
        if (jtbTipoConta.getSelectedRow() != -1) {
            TipoConta tc = new TipoConta();
            TipoContaDAO dao = new TipoContaDAO();
            tc.setTitulo(jtfTitulo.getText());
            tc.setPrecoCompra(Double.parseDouble(jtfPrecoCompra.getText()));
            tc.setId((int)jtbTipoConta.getValueAt(jtbTipoConta.getSelectedRow(), 0));
            dao.update(tc);
            readJTable();

            jtfTitulo.setText("");
            jtfPrecoCompra.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para atualizar!");
        }
    }//GEN-LAST:event_jbtnAtualizarActionPerformed

    private void jbtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirActionPerformed
        // TODO add your handling code here:
        if (jtbTipoConta.getSelectedRow() != -1) {
            TipoConta tc = new TipoConta();
            TipoContaDAO dao = new TipoContaDAO();
            tc.setId((int)jtbTipoConta.getValueAt(jtbTipoConta.getSelectedRow(), 0));
            dao.delete(tc);
            readJTable();

            jtfTitulo.setText("");
            jtfPrecoCompra.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir!");
        }
    }//GEN-LAST:event_jbtnExcluirActionPerformed

    private void jtbTipoContaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTipoContaMouseClicked
        // TODO add your handling code here:
        if (jtbTipoConta.getSelectedRow() != -1) {
            jtfTitulo.setText(jtbTipoConta.getValueAt(jtbTipoConta.getSelectedRow(), 1).toString());
            jtfPrecoCompra.setText(jtbTipoConta.getValueAt(jtbTipoConta.getSelectedRow(), 2).toString());
        }
    }//GEN-LAST:event_jtbTipoContaMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCadastroTipoConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroTipoConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroTipoConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroTipoConta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroTipoConta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtnAtualizar;
    private javax.swing.JButton jbtnCadastrar;
    private javax.swing.JButton jbtnExcluir;
    private javax.swing.JTable jtbTipoConta;
    private javax.swing.JTextField jtfPrecoCompra;
    private javax.swing.JTextField jtfTitulo;
    // End of variables declaration//GEN-END:variables
}
