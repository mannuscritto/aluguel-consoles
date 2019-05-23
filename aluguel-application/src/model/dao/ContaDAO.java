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
import model.bean.Conta;

/**
 *
 * @author romer
 */
public class ContaDAO {
    public void create(Conta c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO conta (PrecoAluguel, NomeUsuario, Senha, TipoConta) VALUES (?, ?, ?, ?)");
            stmt.setDouble(1, c.getPrecoAluguel());
            stmt.setString(2, c.getNomeUsuario());
            stmt.setString(3, c.getSenha());
            stmt.setInt(4, c.getTipoConta());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Conta> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Conta> contas = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM conta");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Conta c = new Conta();
                c.setId(rs.getInt("Conta_PK"));
                c.setPrecoAluguel(rs.getDouble("PrecoAluguel"));
                c.setNomeUsuario(rs.getString("NomeUsuario"));
                c.setSenha(rs.getString("Senha"));
                c.setTipoConta(rs.getInt("TipoConta"));
                contas.add(c);
            }
        } catch (SQLException ex) {
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return contas;
    }
    
    public void update(Conta c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE conta SET PrecoAluguel = ?, NomeUsuario = ?, Senha = ?, TipoConta = ? WHERE Conta_PK = ?");
            stmt.setDouble(1, c.getPrecoAluguel());
            stmt.setString(2, c.getNomeUsuario());
            stmt.setString(3, c.getSenha());
            stmt.setInt(4, c.getTipoConta());
            stmt.setInt(5, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Conta c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from conta WHERE Conta_PK = ?");
            stmt.setInt(1, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(ContaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
}
