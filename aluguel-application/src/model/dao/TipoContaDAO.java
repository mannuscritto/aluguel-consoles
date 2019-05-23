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
import model.bean.TipoConta;

/**
 *
 * @author romer
 */
public class TipoContaDAO {
    public void create(TipoConta tc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO tipoconta (Titulo, PrecoCompra) VALUES (?, ?)");
            stmt.setString(1, tc.getTitulo());
            stmt.setDouble(2, tc.getPrecoCompra());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(TipoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<TipoConta> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<TipoConta> tiposcontas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM tipoconta");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                TipoConta tc = new TipoConta();
                tc.setId(rs.getInt("TipoConta_PK"));
                tc.setTitulo(rs.getString("Titulo"));
                tc.setPrecoCompra(rs.getDouble("PrecoCompra"));
                tiposcontas.add(tc);
            }
        } catch (SQLException ex) {
            Logger.getLogger(TipoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return tiposcontas;
    }
    
    public void update(TipoConta tc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE tipoconta SET Titulo = ?, PrecoCompra = ? WHERE TipoConta_PK = ?");
            stmt.setString(1, tc.getTitulo());
            stmt.setDouble(2, tc.getPrecoCompra());
            stmt.setInt(3, tc.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(TipoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(TipoConta tc) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from tipoconta WHERE TipoConta_PK = ?");
            stmt.setInt(1, tc.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(TipoContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
