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
import model.bean.TipoConsole;

/**
 *
 * @author romer
 */
public class TipoConsoleDAO {
    public void create(TipoConsole tc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tipoconsole (Modelo, Marca) VALUES (?, ?)");
            stmt.setString(1, tc.getModelo());
            stmt.setString(2, tc.getMarca());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(TipoConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<TipoConsole> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TipoConsole> tiposconsoles = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tipoconsole");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                TipoConsole tc = new TipoConsole();
                tc.setId(rs.getInt("TipoConsole_PK"));
                tc.setMarca(rs.getString("Marca"));
                tc.setModelo(rs.getString("Modelo"));
                tiposconsoles.add(tc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return tiposconsoles;
    }
    
    public void update(TipoConsole tc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tipoconsole SET Modelo = ?, Marca = ? WHERE TipoConsole_PK = ?");
            stmt.setString(1, tc.getModelo());
            stmt.setString(2, tc.getMarca());
            stmt.setInt(3, tc.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(TipoConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(TipoConsole tc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from tipoconsole WHERE TipoConsole_PK = ?");
            stmt.setInt(1, tc.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(TipoConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public TipoConsole search(int pk) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        TipoConsole tc = new TipoConsole();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tipoconsole WHERE TipoConsole_PK = ?");
            stmt.setInt(1, pk);
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                tc.setId(rs.getInt("TipoConsole_PK"));
                tc.setMarca(rs.getString("Marca"));
                tc.setModelo(rs.getString("Modelo"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return tc;
    }
}
