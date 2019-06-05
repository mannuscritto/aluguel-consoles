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
import model.bean.ItemConsole;

/**
 *
 * @author romer
 */
public class ItemConsoleDAO {
    public void create(ItemConsole ic) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO itemconsole (Aluguel, Console) VALUES (?, ?)");
            stmt.setInt(1, ic.getAluguel().getId());
            stmt.setInt(2, ic.getConsole().getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<ItemConsole> read(int aluguel) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<ItemConsole> itensconsole = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM itemconsole WHERE Aluguel = ?");
            stmt.setInt(1, aluguel);
            rs = stmt.executeQuery();
            
            ConsoleDAO cdao = new ConsoleDAO();
            while (rs.next()) {
                ItemConsole ic = new ItemConsole();
                ic.setId(rs.getInt("ItemConsole_PK"));
                ic.setConsole(cdao.search(rs.getInt("Console")));
                itensconsole.add(ic);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return itensconsole;
    }
    
    public void update(ItemConsole ic) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE itemconsole SET Aluguel = ?, Console = ? WHERE ItemConsole_PK = ?");
            stmt.setInt(1, ic.getAluguel().getId());
            stmt.setInt(2, ic.getConsole().getId());
            stmt.setInt(3, ic.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(ItemConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(ItemConsole ic) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from itemconsole WHERE ItemConsole_PK = ?");
            stmt.setInt(1, ic.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(ItemConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public boolean exists(ItemConsole ic) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql;
        
        try {
            sql = "SELECT * FROM itemconsole WHERE Aluguel = ? AND Console = ?";
            stmt = con.prepareStatement(sql);
            stmt.setInt(1, ic.getAluguel().getId());
            stmt.setInt(2, ic.getConsole().getId());
            
            rs = stmt.executeQuery();
            
            if (rs.last()) {
                return true;
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao checar: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return false;
    }
    
}
