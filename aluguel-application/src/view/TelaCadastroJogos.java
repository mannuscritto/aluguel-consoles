/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;
import model.bean.Jogo;
import model.bean.TipoConsole;
import model.dao.JogoDAO;
import model.dao.TipoConsoleDAO;

/**
 *
 * @author Bruno
 */
public class TelaCadastroJogos extends javax.swing.JFrame {

    /**
     * Creates new form CadastroJogos
     */
    public TelaCadastroJogos() {
        initComponents();
        readJComboBoxPlataforma();
        readJTable();
        
    }
    
    public void readJTable()
    {
        DefaultTableModel modelo = (DefaultTableModel) jtabelJogos.getModel();
        modelo = (DefaultTableModel) jtabelJogos.getModel();
        modelo.setNumRows(0);
        JogoDAO jdao = new JogoDAO();
        
        for(Jogo j: jdao.read())
        {
            modelo.addRow(new Object[]{
                j.getId(),
                j.getTitulo(),
                j.getPlataforma(),
                j.getPrecoVenda(),
                j.getPrecoAluguel()
            });
        }
    }
    
    public void readJComboBoxPlataforma() {
        TipoConsoleDAO dao = new TipoConsoleDAO();
        for (TipoConsole tc: dao.read()) {
            jcbPlataforma.addItem(tc);
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

        jlTitulo = new javax.swing.JLabel();
        jlGenero = new javax.swing.JLabel();
        jlFaixaEtaria = new javax.swing.JLabel();
        jlPlataforma = new javax.swing.JLabel();
        jlTipoMidia = new javax.swing.JLabel();
        jlQuantidade = new javax.swing.JLabel();
        jlPrecoCompra = new javax.swing.JLabel();
        jlPrecoVenda = new javax.swing.JLabel();
        jlPrecoAluguel = new javax.swing.JLabel();
        jtTitulo = new javax.swing.JTextField();
        jcbGenero = new javax.swing.JComboBox<>();
        jtQuantidade = new javax.swing.JTextField();
        jcbTipoMidia = new javax.swing.JComboBox<>();
        jtPrecoCompra = new javax.swing.JTextField();
        jtCompraVenda = new javax.swing.JTextField();
        jtPrecoAluguel = new javax.swing.JTextField();
        jbCadastrar = new javax.swing.JButton();
        jcbFaixaEtaria = new javax.swing.JComboBox<>();
        jbAlterar = new javax.swing.JButton();
        jbExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jtabelJogos = new javax.swing.JTable();
        jcbPlataforma = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro Jogos");

        jlTitulo.setText("Título");

        jlGenero.setText("Gênero");

        jlFaixaEtaria.setText("Faixa Etária");

        jlPlataforma.setText("Plataforma");

        jlTipoMidia.setText("Tipo da Mídia");

        jlQuantidade.setText("Quantidade");

        jlPrecoCompra.setText("Preço da Mídia");

        jlPrecoVenda.setText("Preço de Venda");

        jlPrecoAluguel.setText("Preço de Aluguel");

        jtTitulo.setToolTipText("");

        jcbGenero.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Gênero", "Ação / Aventura", "Luta", "FPS", "RPG", "Construção / Gerenciamento", "Vida Virtual", "Música / Ritmo", "Simulação", "Corrida", "Terror" }));

        jcbTipoMidia.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione um Tipo de Mídia", "Mídia Digital", "Mídia Física" }));

        jbCadastrar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbCadastrar.setText("Cadastrar");
        jbCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbCadastrarActionPerformed(evt);
            }
        });

        jcbFaixaEtaria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Selecione uma Faixa Etária", "Em análise", "Maiores de 3 anos", "Livre para todos", "Maiores de 10 anos", "Maiores de 13 anos", "Maiores de 17 anos", "Conteúdo Adulto 18+", "Crianças e Adultos" }));

        jbAlterar.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbAlterar.setText("Alterar");
        jbAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbAlterarActionPerformed(evt);
            }
        });

        jbExcluir.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jbExcluir.setText("Excluir");
        jbExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbExcluirActionPerformed(evt);
            }
        });

        jtabelJogos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "Título", "Plataforma", "Preço Venda", "Preço Aluguel"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jtabelJogos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jtabelJogosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jtabelJogos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jbCadastrar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jbAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jbExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlPrecoVenda)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtCompraVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlPrecoAluguel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtPrecoAluguel))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlTipoMidia)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbTipoMidia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlPrecoCompra)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtPrecoCompra))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jlFaixaEtaria)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbFaixaEtaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlPlataforma)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbPlataforma, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addComponent(jlTitulo)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jlGenero)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(18, 18, 18)
                        .addComponent(jlQuantidade)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jtQuantidade, javax.swing.GroupLayout.DEFAULT_SIZE, 87, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlGenero)
                    .addComponent(jtTitulo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbGenero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlQuantidade)
                    .addComponent(jtQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlTitulo))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlFaixaEtaria)
                    .addComponent(jcbFaixaEtaria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPlataforma)
                    .addComponent(jcbPlataforma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlTipoMidia)
                    .addComponent(jcbTipoMidia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPrecoCompra)
                    .addComponent(jtPrecoCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlPrecoVenda)
                    .addComponent(jtCompraVenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlPrecoAluguel)
                    .addComponent(jtPrecoAluguel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbCadastrar)
                    .addComponent(jbAlterar)
                    .addComponent(jbExcluir))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 240, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(9, 9, 9))
        );

        setSize(new java.awt.Dimension(656, 519));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jbCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbCadastrarActionPerformed
        // TODO add your handling code here:
       Jogo j = new Jogo();
       JogoDAO dao = new JogoDAO();
       
       j.setTitulo(jtTitulo.getText());
       j.setGenero(String.valueOf(jcbGenero.getSelectedItem()));
       j.setQuantidade(Integer.parseInt(jtQuantidade.getText()));
       j.setFaixaEtaria(String.valueOf(jcbFaixaEtaria.getSelectedItem()));
       j.setPlataforma((TipoConsole)jcbPlataforma.getSelectedItem());
       j.setTipoMidia(String.valueOf(jcbTipoMidia.getSelectedItem()));
       j.setPrecoCompra(Double.parseDouble(jtPrecoCompra.getText()));
       j.setPrecoVenda(Double.parseDouble(jtCompraVenda.getText()));
       j.setPrecoAluguel(Double.parseDouble(jtPrecoAluguel.getText()));
       dao.create(j);
       
       
       jtTitulo.setText("");
       jcbGenero.setSelectedItem("");
       jcbFaixaEtaria.setSelectedItem("");
       jcbPlataforma.setSelectedIndex(0);
       jcbTipoMidia.setSelectedItem("");
       jtQuantidade.setText("");
       jtPrecoCompra.setText("");
       jtCompraVenda.setText("");
       jtPrecoAluguel.setText("");
       
       readJTable();
       
    }//GEN-LAST:event_jbCadastrarActionPerformed
   
    private void jbAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbAlterarActionPerformed
        // TODO add your handling code here:
        if (jtabelJogos.getSelectedRow() != -1)
        {
             Jogo j = new Jogo();
             JogoDAO dao = new JogoDAO();
       
             j.setTitulo(jtTitulo.getText());
             j.setGenero(String.valueOf(jcbGenero.getSelectedItem()));
             j.setQuantidade(Integer.parseInt(jtQuantidade.getText()));
             j.setFaixaEtaria(String.valueOf(jcbFaixaEtaria.getSelectedItem()));
             j.setPlataforma((TipoConsole)jcbPlataforma.getSelectedItem());
             j.setTipoMidia(String.valueOf(jcbTipoMidia.getSelectedItem()));
             j.setPrecoCompra(Double.parseDouble(jtPrecoCompra.getText()));
             j.setPrecoVenda(Double.parseDouble(jtCompraVenda.getText()));
             j.setPrecoAluguel(Double.parseDouble(jtPrecoAluguel.getText()));
             j.setId((int)jtabelJogos.getValueAt(jtabelJogos.getSelectedRow(), 0));
             dao.update(j);
       
       
             jtTitulo.setText("");
             jcbGenero.setSelectedItem("");
             jcbFaixaEtaria.setSelectedItem("");
             jcbPlataforma.setSelectedIndex(0);
             jcbTipoMidia.setSelectedItem("");
             jtQuantidade.setText("");
             jtPrecoCompra.setText("");
             jtCompraVenda.setText("");
             jtPrecoAluguel.setText("");
       
             readJTable();            
        }
    }//GEN-LAST:event_jbAlterarActionPerformed

    private void jbExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbExcluirActionPerformed
        // TODO add your handling code here:
        if (jtabelJogos.getSelectedRow() != -1)
        {
             Jogo j = new Jogo();
             JogoDAO dao = new JogoDAO();          
             j.setId((int)jtabelJogos.getValueAt(jtabelJogos.getSelectedRow(), 0));
             dao.delete(j);
       
       
             jtTitulo.setText("");
             jcbGenero.setSelectedItem("");
             jcbFaixaEtaria.setSelectedItem("");
             jcbPlataforma.setSelectedIndex(0);
             jcbTipoMidia.setSelectedItem("");
             jtQuantidade.setText("");
             jtPrecoCompra.setText("");
             jtCompraVenda.setText("");
             jtPrecoAluguel.setText("");
       
             readJTable();
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Selecione um jogo para excluir.");
        }
        
    }//GEN-LAST:event_jbExcluirActionPerformed

    private void jtabelJogosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jtabelJogosMouseClicked
        // TODO add your handling code here:
        int row = jtabelJogos.getSelectedRow();
        if (row != -1) {
            JogoDAO dao = new JogoDAO();
            Jogo j = dao.search(Integer.parseInt(jtabelJogos.getValueAt(row, 0).toString()));
            jtTitulo.setText(jtabelJogos.getValueAt(row, 1).toString());
            jcbGenero.setSelectedItem(j.getGenero());
            jtQuantidade.setText(String.valueOf(j.getQuantidade()));
            jcbFaixaEtaria.setSelectedItem(j.getFaixaEtaria());
            jcbPlataforma.getModel().setSelectedItem(jtabelJogos.getValueAt(row, 2));
            jcbTipoMidia.setSelectedItem(j.getTipoMidia());
            jtPrecoCompra.setText(String.valueOf(j.getPrecoCompra()));
            jtCompraVenda.setText(jtabelJogos.getValueAt(row, 3).toString());
            jtPrecoAluguel.setText(jtabelJogos.getValueAt(row, 4).toString());
        }
    }//GEN-LAST:event_jtabelJogosMouseClicked

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
            java.util.logging.Logger.getLogger(TelaCadastroJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaCadastroJogos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaCadastroJogos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbAlterar;
    private javax.swing.JButton jbCadastrar;
    private javax.swing.JButton jbExcluir;
    private javax.swing.JComboBox<String> jcbFaixaEtaria;
    private javax.swing.JComboBox<String> jcbGenero;
    private javax.swing.JComboBox<Object> jcbPlataforma;
    private javax.swing.JComboBox<String> jcbTipoMidia;
    private javax.swing.JLabel jlFaixaEtaria;
    private javax.swing.JLabel jlGenero;
    private javax.swing.JLabel jlPlataforma;
    private javax.swing.JLabel jlPrecoAluguel;
    private javax.swing.JLabel jlPrecoCompra;
    private javax.swing.JLabel jlPrecoVenda;
    private javax.swing.JLabel jlQuantidade;
    private javax.swing.JLabel jlTipoMidia;
    private javax.swing.JLabel jlTitulo;
    private javax.swing.JTextField jtCompraVenda;
    private javax.swing.JTextField jtPrecoAluguel;
    private javax.swing.JTextField jtPrecoCompra;
    private javax.swing.JTextField jtQuantidade;
    private javax.swing.JTextField jtTitulo;
    private javax.swing.JTable jtabelJogos;
    // End of variables declaration//GEN-END:variables
}
