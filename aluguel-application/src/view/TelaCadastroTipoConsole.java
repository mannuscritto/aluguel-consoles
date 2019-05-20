/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.TipoConsole;
import model.dao.TipoConsoleDAO;

/**
 *
 * @author romer
 */
public class TelaCadastroTipoConsole extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroTipoConsole
     */
    public TelaCadastroTipoConsole() {
        initComponents();
        readJTable();
    }
    
    public void readJTable() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtbTipoConsole.getModel();
        modelo.setNumRows(0);
        TipoConsoleDAO tpdao = new TipoConsoleDAO();
        
        for (TipoConsole tp: tpdao.read()) {
            modelo.addRow(new Object[] {
               tp.getId(),
               tp.getMarca(),
               tp.getModelo()
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

        jtfMarca = new javax.swing.JTextField();
        jtfModelo = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jbtnCadastrar = new javax.swing.JButton();
        jbtnExcluir = new javax.swing.JButton();
        jbtnAtualizar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbTipoConsole = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Tipo de Consoles");
        setResizable(false);

        jLabel2.setText("Marca");

        jLabel3.setText("Modelo");

        jbtnCadastrar.setLabel("Cadastrar");
        jbtnCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnCadastrarActionPerformed(evt);
            }
        });

        jbtnExcluir.setLabel("Excluir");
        jbtnExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnExcluirActionPerformed(evt);
            }
        });

        jbtnAtualizar.setLabel("Atualizar");
        jbtnAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAtualizarActionPerformed(evt);
            }
        });

        jtbTipoConsole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "ID", "Marca", "Modelo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbTipoConsole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbTipoConsoleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbTipoConsole);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbtnCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnAtualizar, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbtnExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel2))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel3)
                                    .addComponent(jtfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))))
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
                        .addComponent(jtfMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 132, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtnCadastrar)
                    .addComponent(jbtnAtualizar)
                    .addComponent(jbtnExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        setBounds(0, 0, 656, 519);
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnCadastrarActionPerformed
        // TODO add your handling code here:
        
        TipoConsole tp = new TipoConsole();
        TipoConsoleDAO dao = new TipoConsoleDAO();
        tp.setMarca(jtfMarca.getText());
        tp.setModelo(jtfModelo.getText());
        dao.create(tp);
        readJTable();
        
        jtfMarca.setText("");
        jtfModelo.setText("");
    }//GEN-LAST:event_jbtnCadastrarActionPerformed

    private void jtbTipoConsoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbTipoConsoleMouseClicked
        // TODO add your handling code here:
        
        if (jtbTipoConsole.getSelectedRow() != -1) {
            jtfMarca.setText(jtbTipoConsole.getValueAt(jtbTipoConsole.getSelectedRow(), 1).toString());
            jtfModelo.setText(jtbTipoConsole.getValueAt(jtbTipoConsole.getSelectedRow(), 2).toString());
        }
        
    }//GEN-LAST:event_jtbTipoConsoleMouseClicked

    private void jbtnAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAtualizarActionPerformed
        // TODO add your handling code here:
        
        if (jtbTipoConsole.getSelectedRow() != -1) {
            TipoConsole tp = new TipoConsole();
            TipoConsoleDAO dao = new TipoConsoleDAO();
            tp.setMarca(jtfMarca.getText());
            tp.setModelo(jtfModelo.getText());
            tp.setId((int)jtbTipoConsole.getValueAt(jtbTipoConsole.getSelectedRow(), 0));
            dao.update(tp);
            readJTable();

            jtfMarca.setText("");
            jtfModelo.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para atualizar!");
        }
    }//GEN-LAST:event_jbtnAtualizarActionPerformed

    private void jbtnExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnExcluirActionPerformed
        // TODO add your handling code here:
        
        if (jtbTipoConsole.getSelectedRow() != -1) {
            TipoConsole tp = new TipoConsole();
            TipoConsoleDAO dao = new TipoConsoleDAO();
            tp.setId((int)jtbTipoConsole.getValueAt(jtbTipoConsole.getSelectedRow(), 0));
            dao.delete(tp);
            readJTable();

            jtfMarca.setText("");
            jtfModelo.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir!");
        }
        
    }//GEN-LAST:event_jbtnExcluirActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroTipoConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroTipoConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroTipoConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroTipoConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroTipoConsole().setVisible(true);
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
    private javax.swing.JTable jtbTipoConsole;
    private javax.swing.JTextField jtfMarca;
    private javax.swing.JTextField jtfModelo;
    // End of variables declaration//GEN-END:variables
}
