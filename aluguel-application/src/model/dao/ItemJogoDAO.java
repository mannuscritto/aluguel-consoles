/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.dao;
import connection.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.ItemJogo;

/**
 *
 * @author romer
 */
public class ItemJogoDAO {
    public void create(ItemJogo ij) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        JogoDAO jdao = new JogoDAO();
        
        try {
            stmt = con.prepareStatement("INSERT INTO itemjogo (Aluguel, Jogo, Quantidade) VALUES (?, ?, ?)");
            stmt.setInt(1, ij.getAluguel().getId());
            stmt.setInt(2, ij.getJogo().getId());
            stmt.setInt(3, ij.getQuantidade());
            
            stmt.executeUpdate();
            
            ij.getJogo().setQuantidade(ij.getJogo().getQuantidade() - ij.getQuantidade());
            
            jdao.update(ij.getJogo());
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(ItemJogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<ItemJogo> read(int aluguel) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItemJogo> itensjogo = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM itemjogo WHERE Aluguel = ?");
            stmt.setInt(1, aluguel);
            rs = stmt.executeQuery();
            
            JogoDAO jdao = new JogoDAO();
            while (rs.next()) {
                ItemJogo ij = new ItemJogo();
                ij.setId(rs.getInt("ItemJogo_PK"));
                ij.setJogo(jdao.search(rs.getInt("Jogo")));
                ij.setQuantidade(rs.getInt("Quantidade"));
                itensjogo.add(ij);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ItemJogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return itensjogo;
    }
    
    public void update(ItemJogo ij) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE itemjogo SET Aluguel = ?, Jogo = ?, Quantidade = ? WHERE ItemJogo_PK = ?");
            stmt.setInt(1, ij.getAluguel().getId());
            stmt.setInt(2, ij.getJogoId());
            stmt.setInt(3, ij.getQuantidade());
            stmt.setInt(4, ij.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(ItemJogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(ItemJogo ij) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from itemjogo WHERE ItemJogo_PK = ?");
            stmt.setInt(1, ij.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(ItemJogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean exists(ItemJogo ij) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql;
        
        try {
            sql = "SELECT * FROM itemjogo WHERE Aluguel = ? AND Jogo = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, ij.getAluguel().getId());
            stmt.setInt(2, ij.getJogo().getId());
            
            rs = stmt.executeQuery();
            
            if (rs.last()) {
                if (ij.getId() != rs.getInt("ItemJogo_PK")) {
                    ij.setId(rs.getInt("ItemJogo_PK"));
                    ij.setQuantidade(ij.getQuantidade() + rs.getInt("Quantidade"));
                }
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao checar: " + ex);
            Logger.getLogger(ItemJogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return false;
    }
}
