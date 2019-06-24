/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Cliente;
import model.bean.Endereco;
import model.bean.Telefone;
import model.dao.ClienteDAO;
import model.dao.EnderecoDAO;
import model.dao.TelefoneDAO;

/**
 *
 * @author Bruno
 */
public class TelaCadastroCliente extends javax.swing.JFrame {

    /**
     * Creates new form ListaClientes
     */
    public TelaCadastroCliente() {
        setExtendedState(MAXIMIZED_BOTH);
        initComponents();
        readJTable();
    }
    
    public void readJTable() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtbCliente.getModel();
        modelo.setNumRows(0);
        ClienteDAO dao = new ClienteDAO();
        
        for (Cliente c: dao.read()) {
            modelo.addRow(new Object[] {
               c.getId(),
               c.getPrimeiroNome(),
               c.getUltimoNome(),
               c.getDocumento(),
            });
        }
    }
    
    private void resetCampos() {
       jcbTipoCliente.setSelectedIndex(0);
       jtPrimeiroNome.setText("");
       jtCNPJ.setText("");
       jtUltimoNome.setText("");
       jtEmail.setText("");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jlPrimeiroNome = new javax.swing.JLabel();
        jtPrimeiroNome = new javax.swing.JTextField();
        jlUltimoNome = new javax.swing.JLabel();
        jtUltimoNome = new javax.swing.JTextField();
        jlEmail = new javax.swing.JLabel();
        jtEmail = new javax.swing.JTextField();
        jlCNPJ = new javax.swing.JLabel();
        jtCNPJ = new javax.swing.JTextField();
        jbCadastrar = new javax.swing.JButton();
        jLabel8 = new javax.swing.JLabel();
        jcbTipoCliente = new javax.swing.JComboBox<>();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Clientes");

        jlPrimeiroNome.setText("Primeiro Nome");

        jlUltimoNome.setText("Último Nome");

        jlEmail.setText("Email");

        jlCNPJ.setText("CPF/CNPJ");

        jbCadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jLabel8.setText("Tipo de Cliente");

        jcbTipoCliente.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione o tipo", "Pessoa Física", "Pessoa Jurídica" }));

        jbAlterar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jtbCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "PrimeiroNome", "UltimoNome", "Documento"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbClienteMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtbCliente);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 620, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 152, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlPrimeiroNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtPrimeiroNome, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlUltimoNome)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtUltimoNome))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlCNPJ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtCNPJ))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbCadastrar, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jbAlterar)
                                .addGap(18, 18, 18)
                                .addComponent(jbExcluir))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlEmail)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jcbTipoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCNPJ)
                    .addComponent(jtCNPJ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrimeiroNome)
                    .addComponent(jtPrimeiroNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlUltimoNome)
                    .addComponent(jtUltimoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlEmail)
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(129, 129, 129)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbAlterar)
                    .addComponent(jbExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 203, Short.MAX_VALUE)
                .addContainerGap())
        );

        setSize(new java.awt.Dimension(656, 519));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        Cliente cl = new Cliente();
        ClienteDAO dao = new ClienteDAO();
        cl.setPrimeiroNome(jtPrimeiroNome.getText());
        cl.setUltimoNome(jtUltimoNome.getText());
        cl.setEmail(jtEmail.getText());
        cl.setDocumento(jtCNPJ.getText());
        if (jcbTipoCliente.getSelectedIndex() > 0) {
            cl.setTipocliente(jcbTipoCliente.getSelectedIndex());
        }

        dao.create(cl);

        JOptionPane.showMessageDialog(this, "Código do cliente: " + cl.getId());
        readJTable();
        resetCampos();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        if (jtbCliente.getSelectedRow() != -1) {       
            Cliente cl = new Cliente();
            ClienteDAO dao = new ClienteDAO();
            cl.setPrimeiroNome(jtPrimeiroNome.getText());
            cl.setUltimoNome(jtUltimoNome.getText());
            cl.setEmail(jtEmail.getText());
            cl.setDocumento(jtCNPJ.getText());
            if (jcbTipoCliente.getSelectedIndex() > 0) {
                cl.setTipocliente(jcbTipoCliente.getSelectedIndex());
            }
            cl.setId((int)jtbCliente.getValueAt(jtbCliente.getSelectedRow(), 0));
            dao.update(cl);
            TelaCadastroEndereco telaend = new TelaCadastroEndereco();
            telaend.setVisible(true);
            resetCampos();
            readJTable(); 
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        // TODO add your handling code here:
         if (jtbCliente.getSelectedRow() != -1) {
             Cliente cl = new Cliente();
             ClienteDAO dao = new ClienteDAO();          
             cl.setId((int)jtbCliente.getValueAt(jtbCliente.getSelectedRow(), 0));
             dao.delete(cl);
       
             resetCampos();
             readJTable();
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um Cliente para excluir.");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jtbClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbClienteMouseClicked
        // TODO add your handling code here:
        int row = jtbCliente.getSelectedRow();
        if (row != -1) {
            ClienteDAO dao = new ClienteDAO();
            int codigo = Integer.parseInt(jtbCliente.getValueAt(row, 0).toString());
            Cliente c = dao.search(codigo);
            jtPrimeiroNome.setText(jtbCliente.getValueAt(row, 1).toString());
            jtUltimoNome.setText(jtbCliente.getValueAt(row, 2).toString());
            jtEmail.setText(c.getEmail());
            jtCNPJ.setText(jtbCliente.getValueAt(row, 3).toString());
            jcbTipoCliente.setSelectedIndex(c.getTipocliente());
        }
    }//GEN-LAST:event_jtbClienteMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroCliente().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox<String> jcbTipoCliente;
    private javax.swing.JLabel jlCNPJ;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlPrimeiroNome;
    private javax.swing.JLabel jlUltimoNome;
    private javax.swing.JTextField jtCNPJ;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtPrimeiroNome;
    private javax.swing.JTextField jtUltimoNome;
    private javax.swing.JTable jtbCliente;
    // End of variables declaration//GEN-END:variables

}
