/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
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
        initComponents();
    }
    
    private void resetCampos() {
       jcbTipoCliente.setSelectedIndex(0);
       jtPrimeiroNome.setText("");
       jtCNPJ.setText("");
       jtUltimoNome.setText("");
       jtEmail.setText("");
       jtDDD.setText("");
       jtTelefone.setText("");
       jtRua.setText("");
       jtBairro.setText("");
       jtCidade.setText("");
       jtNumero.setText("");
       jtCEP.setText("");
       jtComplemento.setText("");
       jtCNPJ.setText("");
       jcbUF.setSelectedIndex(0);
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
        jlCEP = new javax.swing.JLabel();
        jtCEP = new javax.swing.JTextField();
        jlUF = new javax.swing.JLabel();
        jcbUF = new javax.swing.JComboBox<>();
        jlCidade = new javax.swing.JLabel();
        jtCidade = new javax.swing.JTextField();
        jlBairro = new javax.swing.JLabel();
        jtBairro = new javax.swing.JTextField();
        jlRua = new javax.swing.JLabel();
        jtRua = new javax.swing.JTextField();
        jlNumero = new javax.swing.JLabel();
        jtNumero = new javax.swing.JTextField();
        jlComplemento = new javax.swing.JLabel();
        jtComplemento = new javax.swing.JTextField();
        jbCadastrar = new javax.swing.JButton();
        jlTelefone = new javax.swing.JLabel();
        jtTelefone = new javax.swing.JTextField();
        jlDDD = new javax.swing.JLabel();
        jtDDD = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jcbTipoCliente = new javax.swing.JComboBox<>();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtbCliente = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Cadastro de Clientes");

        jlPrimeiroNome.setText("Primeiro Nome");

        jlUltimoNome.setText("Último Nome");

        jlEmail.setText("Email");

        jlCNPJ.setText("CPF/CNPJ");

        jlCEP.setText("CEP");

        jlUF.setText("UF");

        jcbUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um UF", "AC", "AL", "AP", "AM", "BA", "CE", "DF", "ES", "GO", "MA", "MT", "MS", "MG", "PA", "PB", "PR", "PE", "PI", "RJ", "RN", "RS", "RO", "RR", "SC", "SP", "SE", "TO" }));

        jlCidade.setText("Cidade");

        jlBairro.setText("Bairro");

        jlRua.setText("Rua");

        jlNumero.setText("Número");

        jlComplemento.setText("Complemento");

        jbCadastrar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jlTelefone.setText("Telefone");

        jlDDD.setText("DDD");

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
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "PrimeiroNome", "UltimoNome", "Email", "Documento", "Tipo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
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
                    .addComponent(jScrollPane1)
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
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jlUltimoNome)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlDDD)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtDDD)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jlTelefone)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtTelefone))
                                    .addComponent(jtUltimoNome)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlCNPJ)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtCNPJ))))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jlRua)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtRua, javax.swing.GroupLayout.PREFERRED_SIZE, 291, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlNumero)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jlCEP)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtCEP, javax.swing.GroupLayout.DEFAULT_SIZE, 114, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlCidade)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtCidade))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlBairro)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtBairro))
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
                                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 282, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlUF)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbUF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addComponent(jlComplemento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtComplemento)))
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
                    .addComponent(jtEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlDDD)
                    .addComponent(jtDDD, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTelefone))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlRua)
                    .addComponent(jtRua, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlNumero)
                    .addComponent(jtNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlCEP)
                    .addComponent(jtCEP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlBairro)
                    .addComponent(jtBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlComplemento)
                    .addComponent(jtComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlCidade)
                    .addComponent(jtCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlUF)
                    .addComponent(jcbUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbAlterar)
                    .addComponent(jbExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 173, Short.MAX_VALUE)
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

        dao.create();

        Endereco e = new Endereco()       ;
        EnderecoDAO edao = new EnderecoDAO();
        e.setRua(jtRua.getText());
        e.setNumero(Integer.parseInt(jtNumero.getText()));
        e.setComplemento(jtComplemento.getText());
        e.setBairro(jtBairro.getText());
        e.setCidade(jtCidade.getText());
        e.setUf(jtUltimoNome.getText());
        e.setCep(jtCEP.getText());
        e.setCliente(cl.getId());
        edao.create(e);

        Telefone t = new Telefone();
        TelefoneDAO tdao = new TelefoneDAO();
        t.setCodArea(Integer.parseInt(jtDDD.getText()));
        t.setNumero(Long.parseLong(jtTelefone.getText()));
        t.setCliente(cl.getId());
        tdao.create(t);

        readJTable();
        resetCampos();
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        if (jtabelClientes.getSelectedRow() != -1) {       
            Cliente cl = new Cliente();
            ClienteDAO dao = new ClienteDAO();
            cl.setPrimeiroNome(jtPrimeiroNome.getText());
            cl.setUltimoNome(jtUltimoNome.getText());
            cl.setEmail(jtEmail.getText());
            cl.setDocumento(jtCNPJ.getText());
            dao.update(cl);

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
    private javax.swing.JComboBox<String> jcbUF;
    private javax.swing.JLabel jlBairro;
    private javax.swing.JLabel jlCEP;
    private javax.swing.JLabel jlCNPJ;
    private javax.swing.JLabel jlCidade;
    private javax.swing.JLabel jlComplemento;
    private javax.swing.JLabel jlDDD;
    private javax.swing.JLabel jlEmail;
    private javax.swing.JLabel jlNumero;
    private javax.swing.JLabel jlPrimeiroNome;
    private javax.swing.JLabel jlRua;
    private javax.swing.JLabel jlTelefone;
    private javax.swing.JLabel jlUF;
    private javax.swing.JLabel jlUltimoNome;
    private javax.swing.JTextField jtBairro;
    private javax.swing.JTextField jtCEP;
    private javax.swing.JTextField jtCNPJ;
    private javax.swing.JTextField jtCidade;
    private javax.swing.JTextField jtComplemento;
    private javax.swing.JTextField jtDDD;
    private javax.swing.JTextField jtEmail;
    private javax.swing.JTextField jtNumero;
    private javax.swing.JTextField jtPrimeiroNome;
    private javax.swing.JTextField jtRua;
    private javax.swing.JTextField jtTelefone;
    private javax.swing.JTextField jtUltimoNome;
    private javax.swing.JTable jtbCliente;
    // End of variables declaration//GEN-END:variables

    private void readJTable() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
