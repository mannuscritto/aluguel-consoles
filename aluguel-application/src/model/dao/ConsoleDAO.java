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
import model.bean.Console;

/**
 *
 * @author romer
 */
public class ConsoleDAO {
    public void create(Console c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO console (NumeroSerie, PrecoAluguel, CapacArmaz, CodTipoConsole, CodConta) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, c.getNumeroSerie());
            stmt.setDouble(2, c.getPrecoAluguel());
            stmt.setString(3, c.getCapacArmaz());
            stmt.setInt(4, c.getTipoConsole().getId());
            stmt.setInt(5, c.getConta().getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(ConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Console> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Console> consoles = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM console");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Console c = new Console();
                TipoConsoleDAO tcdao = new TipoConsoleDAO();
                ContaDAO cdao = new ContaDAO();
                c.setId(rs.getInt("Console_PK"));
                c.setNumeroSerie(rs.getString("NumeroSerie"));
                c.setPrecoAluguel(rs.getDouble("PrecoAluguel"));
                c.setCapacArmaz(rs.getString("CapacArmaz"));
                c.setConta(cdao.search(rs.getInt("CodConta")));
                c.setTipoConsole(tcdao.search(rs.getInt("CodTipoConsole")));
                consoles.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return consoles;
    }
    
    public void update(Console c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE console SET NumeroSerie = ?, PrecoAluguel = ?, CapacArmaz = ?, CodTipoConsole = ?, CodConta = ? WHERE Console_PK = ?");
            stmt.setString(1, c.getNumeroSerie());
            stmt.setDouble(2, c.getPrecoAluguel());
            stmt.setString(3, c.getCapacArmaz());
            stmt.setInt(4, c.getTipoConsole().getId());
            stmt.setInt(5, c.getConta().getId());
            stmt.setInt(6, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(ConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Console c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from console WHERE Console_PK = ?");
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(ConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
