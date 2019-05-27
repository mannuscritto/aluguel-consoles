/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import model.bean.Aluguel;
import model.bean.Console;
import model.bean.ItemConsole;
import model.bean.ItemJogo;
import model.bean.Jogo;
import model.dao.AluguelDAO;
import model.dao.ConsoleDAO;
import model.dao.ItemConsoleDAO;
import model.dao.ItemJogoDAO;
import model.dao.JogoDAO;

/**
 *
 * @author Lucas Santos
 */
public class TelaCadastroAluguel extends javax.swing.JFrame {

    /**
     * Creates new form CadastroAluguel
     */
    public TelaCadastroAluguel() {
        initComponents();
        readJTable();
        readJComboBoxConsole();
        readJComboBoxJogo();
    }
    
    public void readJComboBoxConsole() {
        ConsoleDAO dao = new ConsoleDAO();
        
        for (Console c: dao.read()) {
            jcbConsole.addItem(c);
        }
    }
    
    public void readJComboBoxJogo() {
        JogoDAO dao = new JogoDAO();
        
        for (Jogo j: dao.read()) {
            jcbJogo.addItem(j);
        }
    }
    
    public void readJTable() {
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtbAluguel.getModel();
        modelo.setNumRows(0);
        AluguelDAO dao = new AluguelDAO();
        
        for (Aluguel a: dao.read()) {
            modelo.addRow(new Object[] {
               a.getId(),
               a.getDataInicio(),
               a.getDataFinal(),
               a.getValorTotal(),
               a.getNumeroControles(),
               a.getCliente()
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

        Agendar = new javax.swing.ButtonGroup();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jftDataInicio = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jftDataFinal = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jtbAluguel = new javax.swing.JTable();
        jtfCliente = new javax.swing.JTextField();
        jbtnPesquisar = new javax.swing.JButton();
        jbCadastrar = new javax.swing.JButton();
        jbAtualizar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jcbConsole = new javax.swing.JComboBox<>();
        jScrollPane5 = new javax.swing.JScrollPane();
        jtbItemConsole = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jbAdConsole = new javax.swing.JButton();
        jbRmConsole = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jtbItemJogo = new javax.swing.JTable();
        jLabel5 = new javax.swing.JLabel();
        jcbJogo = new javax.swing.JComboBox<>();
        jbAdJogo = new javax.swing.JButton();
        jbRmJogo = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jtfQuantidade = new javax.swing.JTextField();
        jtfValorTotal = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jtfNumeroControles = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de Aluguel");

        jLabel1.setText("Cliente");

        jftDataInicio.setText("01/01/2019");

        jLabel8.setText("Início");

        jftDataFinal.setText("01/01/2019");

        jLabel9.setText("Entrega");

        jtbAluguel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "ID", "Data de Início", "Data de Entrega", "Valor Total", "Controles", "Cliente"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtbAluguel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtbAluguelMouseClicked(evt);
            }
        });
        jScrollPane4.setViewportView(jtbAluguel);

        jbtnPesquisar.setText("Pesquisar");

        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jbAtualizar.setText("Atualizar");
        jbAtualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAtualizarActionPerformed(evt);
            }
        });

        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jtbItemConsole.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Modelo", "Preço", "Console", "Conta"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane5.setViewportView(jtbItemConsole);

        jLabel3.setText("Console");

        jbAdConsole.setText("Adicionar");
        jbAdConsole.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAdConsoleActionPerformed(evt);
            }
        });

        jbRmConsole.setText("Remover");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbConsole, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jbAdConsole)
                        .addGap(18, 18, 18)
                        .addComponent(jbRmConsole)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbConsole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3)
                    .addComponent(jbRmConsole)
                    .addComponent(jbAdConsole))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Consoles", jPanel1);

        jtbItemJogo.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Preço", "Quantidade", "Jogo"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane3.setViewportView(jtbItemJogo);

        jLabel5.setText("Jogo");

        jbAdJogo.setText("Adicionar");

        jbRmJogo.setText("Remover");

        jLabel4.setText("QTD");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 614, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jcbJogo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbAdJogo)
                        .addGap(18, 18, 18)
                        .addComponent(jbRmJogo)))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel4))
                    .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel5)
                        .addComponent(jcbJogo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jbAdJogo)
                        .addComponent(jbRmJogo)))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 164, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(48, 48, 48))
        );

        jTabbedPane1.addTab("Jogos", jPanel2);

        jLabel2.setText("Valor total");

        jLabel7.setText("Controles");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTabbedPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtfCliente)
                        .addGap(18, 18, 18)
                        .addComponent(jbtnPesquisar)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jftDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfNumeroControles, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtfValorTotal))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jbCadastrar)
                                .addGap(18, 18, 18)
                                .addComponent(jbAtualizar)
                                .addGap(18, 18, 18)
                                .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(jftDataInicio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(jftDataFinal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtnPesquisar))
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 252, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jtfNumeroControles, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jtfValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbAtualizar)
                    .addComponent(jbExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 252, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
        Aluguel a = new Aluguel();
        AluguelDAO dao = new AluguelDAO();
        a.setCliente(Integer.parseInt(jtfCliente.getText()));
        a.setDataInicio(jftDataInicio.getText());
        a.setDataFinal(jftDataFinal.getText());
        a.setValorTotal(Double.parseDouble(jtfValorTotal.getText()));
        a.setNumeroControles(Integer.parseInt(jtfNumeroControles.getText()));
        dao.create(a);
        
        for(int row = 0;row < jtbItemConsole.getRowCount();row++) {
            ItemConsole ic = new ItemConsole();
            ItemConsoleDAO icdao = new ItemConsoleDAO();
            ic.setAluguel(a);
            ic.setConsole(Integer.parseInt(jtbItemConsole.getValueAt(row, 3).toString()));
            icdao.create(ic);
        }
        
        for(int row = 0;row < jtbItemConsole.getRowCount();row++) {
            ItemJogo ij = new ItemJogo();
            ItemJogoDAO ijdao = new ItemJogoDAO();
            ij.setAluguel(a);
            ij.setJogoId(Integer.parseInt(jtbItemJogo.getValueAt(row, 4).toString()));
            ij.setQuantidade(Integer.parseInt(jtfQuantidade.getText()));
            ijdao.create(ij);
        }
        
        readJTable();
        
        jtfCliente.setText("");
        jftDataInicio.setText("");
        jftDataFinal.setText("");
        jtfValorTotal.setText("");
        jtfNumeroControles.setText("");
    }//GEN-LAST:event_jbCadastrarActionPerformed

    private void jbAtualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAtualizarActionPerformed
        // TODO add your handling code here:
        if (jtbAluguel.getSelectedRow() != -1) {
            Aluguel a = new Aluguel();
            AluguelDAO dao = new AluguelDAO();
            a.setCliente(Integer.parseInt(jtfCliente.getText()));
            a.setDataInicio(jftDataInicio.getText());
            a.setDataFinal(jftDataFinal.getText());
            a.setValorTotal(Double.parseDouble(jtfValorTotal.getText()));
            a.setNumeroControles(Integer.parseInt(jtfNumeroControles.getText()));
            dao.update(a);
            readJTable();

            jtfCliente.setText("");
            jftDataInicio.setText("");
            jftDataFinal.setText("");
            jtfValorTotal.setText("");
            jtfNumeroControles.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para atualizar!");
        }
    }//GEN-LAST:event_jbAtualizarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        // TODO add your handling code here:
        if (jtbAluguel.getSelectedRow() != -1) {
            Aluguel a = new Aluguel();
            AluguelDAO dao = new AluguelDAO();
            a.setId((int)jtbAluguel.getValueAt(jtbAluguel.getSelectedRow(), 0));
            dao.delete(a);
            readJTable();

            jtfCliente.setText("");
            jftDataInicio.setText("");
            jftDataFinal.setText("");
            jtfValorTotal.setText("");
            jtfNumeroControles.setText("");
        } else {
            JOptionPane.showMessageDialog(null, "Selecione um registro para excluir!");
        }
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jtbAluguelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtbAluguelMouseClicked
        // TODO add your handling code here:
        if (jtbAluguel.getSelectedRow() != -1) {
            jftDataInicio.setText(jtbAluguel.getValueAt(jtbAluguel.getSelectedRow(), 1).toString());
            jftDataFinal.setText(jtbAluguel.getValueAt(jtbAluguel.getSelectedRow(), 2).toString());
            jtfValorTotal.setText(jtbAluguel.getValueAt(jtbAluguel.getSelectedRow(), 3).toString());
            jtfNumeroControles.setText(jtbAluguel.getValueAt(jtbAluguel.getSelectedRow(), 4).toString());
            jtfCliente.setText(jtbAluguel.getValueAt(jtbAluguel.getSelectedRow(), 5).toString());
        }
    }//GEN-LAST:event_jtbAluguelMouseClicked

    private void jbAdConsoleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAdConsoleActionPerformed
        // TODO add your handling code here:
        DefaultTableModel modelo;
        modelo = (DefaultTableModel) jtbItemConsole.getModel();
        Console c = (Console)jcbConsole.getSelectedItem();
        modelo.addRow(new Object[] {
            "Não salvo",
            c.getTipoConsole().getModelo(),
            c.getPrecoAluguel(),
            c.getId(),
            c.getConta().getTipoConta().getTitulo()
        });
    }//GEN-LAST:event_jbAdConsoleActionPerformed

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
            java.util.logging.Logger.getLogger(TelaCadastroAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroAluguel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroAluguel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup Agendar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JButton jbAdConsole;
    private javax.swing.JButton jbAdJogo;
    private javax.swing.JButton jbAtualizar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JButton jbRmConsole;
    private javax.swing.JButton jbRmJogo;
    private javax.swing.JButton jbtnPesquisar;
    private javax.swing.JComboBox<Object> jcbConsole;
    private javax.swing.JComboBox<Object> jcbJogo;
    private javax.swing.JFormattedTextField jftDataFinal;
    private javax.swing.JFormattedTextField jftDataInicio;
    private javax.swing.JTable jtbAluguel;
    private javax.swing.JTable jtbItemConsole;
    private javax.swing.JTable jtbItemJogo;
    private javax.swing.JTextField jtfCliente;
    private javax.swing.JTextField jtfNumeroControles;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.JTextField jtfValorTotal;
    // End of variables declaration//GEN-END:variables
}
