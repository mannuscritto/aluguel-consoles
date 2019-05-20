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
    public void create(TipoConsole tp) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tipoconsole (Modelo, Marca) VALUES (?, ?)");
            stmt.setString(1, tp.getModelo());
            stmt.setString(2, tp.getMarca());
            
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
                TipoConsole tp = new TipoConsole();
                tp.setId(rs.getInt("TipoConsole_PK"));
                tp.setMarca(rs.getString("Marca"));
                tp.setModelo(rs.getString("Modelo"));
                tiposconsoles.add(tp);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return tiposconsoles;
    }
    
    public void update(TipoConsole tp) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tipoconsole SET Modelo = ?, Marca = ? WHERE TipoConsole_PK = ?");
            stmt.setString(1, tp.getModelo());
            stmt.setString(2, tp.getMarca());
            stmt.setInt(3, tp.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(TipoConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(TipoConsole tp) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from tipoconsole WHERE TipoConsole_PK = ?");
            stmt.setInt(1, tp.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(TipoConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
}
