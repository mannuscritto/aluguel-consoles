/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Console;
import model.bean.TipoConsole;
import model.dao.ConsoleDAO;
import model.dao.TipoConsoleDAO;

/**
 *
 * @author Lucas Santos
 */
public class TelaCadastroConsole extends javax.swing.JFrame {

    /**
     * Creates new form TelaCadastroConsole
     */
    public TelaCadastroConsole() {
        initComponents();
        readJTable();
        readJComboBoxTipoConsole();
    }

    public void readJComboBoxTipoConsole() {
        TipoConsoleDAO dao = new TipoConsoleDAO();
        
        for (TipoConsole tc: dao.read()) {
            jcbTipoConsole.addItem(tc);
        }
    }
    
    public void readJTable() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtbConsole.getModel();
        modelo.setNumRows(0);
        ConsoleDAO consoledao = new ConsoleDAO();
        
        for (Console c: consoledao.read()) {
            modelo.addRow(new Object[] {
               c.getId(),
               c.getNumeroSerie(),
               c.getCapacArmaz(),
               c.getPrecoAluguel(),
               c.getTipoConsole(),
               c.getConta()
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

        jLabel1 = new javax.swing.JLabel();
        jtfNumeroSerie = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jtfPrecoAluguel = new javax.swing.JTextField();
        jbCadastrar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jbAlterar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbConsole = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jtfCapacArmaz = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jtfConta = new javax.swing.JTextField();
        jcbTipoConsole = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Consoles");

        jLabel1.setText("Número de série");

        jLabel2.setText("Armazenamento");

        jLabel4.setText("Preco de Aluguel");

        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jtbConsole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Número de serie", "Armazenamento", "Preço de Aluguel", "Tipo do console", "Conta"
            }
        ));
        jtbConsole.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbConsoleMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbConsole);

        jLabel5.setText("Tipo de Console");

        jLabel3.setText("Conta");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 628, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(jLabel5))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(jbAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(jbExcluir))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jtfPrecoAluguel, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                                    .addComponent(jtfConta))
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jtfCapacArmaz, javax.swing.GroupLayout.DEFAULT_SIZE, 151, Short.MAX_VALUE)
                            .addComponent(jcbTipoConsole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfNumeroSerie, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(jcbTipoConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jtfPrecoAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfCapacArmaz, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jtfConta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbAlterar)
                    .addComponent(jbExcluir)
                    .addComponent(jbCadastrar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 290, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        Console c = new Console();
        ConsoleDAO dao = new ConsoleDAO();
        c.setNumeroSerie(jtfNumeroSerie.getText());
        c.setPrecoAluguel(Double.parseDouble(jtfPrecoAluguel.getText()));
        c.setCapacArmaz(jtfCapacArmaz.getText());
        c.setTipoConsole((TipoConsole)jcbTipoConsole.getSelectedItem());
        c.setConta(Integer.parseInt(jtfConta.getText()));
        dao.create(c);
        readJTable();
        
        jtfNumeroSerie.setText("");
        jtfPrecoAluguel.setText("");
        jtfCapacArmaz.setText("");
        jcbTipoConsole.setSelectedIndex(0);
        jtfConta.setText("");
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        if (jtbConsole.getSelectedRow() != -1) {
            Console c = new Console();
            ConsoleDAO dao = new ConsoleDAO();
            c.setNumeroSerie(jtfNumeroSerie.getText());
            c.setPrecoAluguel(Double.parseDouble(jtfPrecoAluguel.getText()));
            c.setCapacArmaz(jtfCapacArmaz.getText());
            c.setTipoConsole((TipoConsole)jcbTipoConsole.getSelectedItem());
            c.setConta(Integer.parseInt(jtfConta.getText()));
            c.setId((int)jtbConsole.getValueAt(jtbConsole.getSelectedRow(), 0));
            dao.update(c);
            readJTable();

            jtfNumeroSerie.setText("");
            jtfPrecoAluguel.setText("");
            jtfCapacArmaz.setText("");
            jcbTipoConsole.setSelectedIndex(0);
            jtfConta.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para atualizar!");
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        // TODO add your handling code here:
        if (jtbConsole.getSelectedRow() != -1) {
            Console c = new Console();
            ConsoleDAO dao = new ConsoleDAO();
            c.setId((int)jtbConsole.getValueAt(jtbConsole.getSelectedRow(), 0));
            dao.delete(c);
            readJTable();

            jtfNumeroSerie.setText("");
            jtfPrecoAluguel.setText("");
            jtfCapacArmaz.setText("");
            jcbTipoConsole.setSelectedIndex(0);
            jtfConta.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir!");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jtbConsoleMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbConsoleMouseClicked
        // TODO add your handling code here:
        if (jtbConsole.getSelectedRow() != -1) {
            jtfNumeroSerie.setText(jtbConsole.getValueAt(jtbConsole.getSelectedRow(), 1).toString());
            jtfCapacArmaz.setText(jtbConsole.getValueAt(jtbConsole.getSelectedRow(), 2).toString());
            jtfPrecoAluguel.setText(jtbConsole.getValueAt(jtbConsole.getSelectedRow(), 3).toString());
            jcbTipoConsole.setSelectedItem(jtbConsole.getValueAt(jtbConsole.getSelectedRow(), 4));
            jtfConta.setText(jtbConsole.getValueAt(jtbConsole.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jtbConsoleMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCadastroConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroConsole.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroConsole().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox<Object> jcbTipoConsole;
    private javax.swing.JTable jtbConsole;
    private javax.swing.JTextField jtfCapacArmaz;
    private javax.swing.JTextField jtfConta;
    private javax.swing.JTextField jtfNumeroSerie;
    private javax.swing.JTextField jtfPrecoAluguel;
    // End of variables declaration//GEN-END:variables
}
