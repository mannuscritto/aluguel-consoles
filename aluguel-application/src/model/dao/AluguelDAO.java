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
import model.bean.Aluguel;

/**
 *
 * @author romer
 */
public class AluguelDAO {
    public void create(Aluguel a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO aluguel (DataInicio, DataFinal, ValorTotal, NumeroControles, CodCliente) VALUES (?, ?, ?, ?, ?)");
            stmt.setDate(1, a.getDataInicio());
            stmt.setDate(2, a.getDataFinal());
            stmt.setDouble(3, a.getValorTotal());
            stmt.setInt(4, a.getNumeroControles());
            stmt.setInt(5, a.getCliente().getId());
            
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("SELECT max(Aluguel_PK) AS codigo FROM aluguel");
            rs = stmt.executeQuery();
            while (rs.next()) {
                a.setId(rs.getInt("codigo"));
            }
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public List<Aluguel> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluguel> alugueis = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aluguel WHERE DataFechamento IS NULL AND CodCliente IN (SELECT Cliente_PK FROM cliente WHERE ativo = 1)");
            rs = stmt.executeQuery();
            
            ClienteDAO cdao = new ClienteDAO();
            while (rs.next()) {
                Aluguel a = new Aluguel();
                a.setId(rs.getInt("Aluguel_PK"));
                a.setDataAbertura(rs.getTimestamp("DataAbertura"));
                a.setDataInicio(rs.getDate("DataInicio"));
                a.setDataFinal(rs.getDate("DataFinal"));
                a.setDataFechamento(rs.getTimestamp("DataFechamento"));
                a.setValorTotal(rs.getDouble("ValorTotal"));
                a.setNumeroControles(rs.getInt("NumeroControles"));
                a.setCliente(cdao.search(rs.getInt("CodCliente")));
                alugueis.add(a);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return alugueis;
    }
    
    public void update(Aluguel a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE aluguel SET DataInicio = ?, DataFinal = ?, ValorTotal = ?, NumeroControles = ?, CodCliente = ? WHERE Aluguel_PK = ?");
            stmt.setDate(1, a.getDataInicio());
            stmt.setDate(2, a.getDataFinal());
            stmt.setDouble(3, a.getValorTotal());
            stmt.setInt(4, a.getNumeroControles());
            stmt.setInt(5, a.getCliente().getId());
            stmt.setInt(6, a.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void delete(Aluguel a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from aluguel WHERE Aluguel_PK = ?");
            stmt.setInt(1, a.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void disable(Aluguel a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE aluguel SET DataFechamento = current_timestamp() WHERE Aluguel_PK = ?");
            stmt.setInt(1, a.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Fechado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao fechar: " + ex);
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public void renew(Aluguel a) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE aluguel SET DataFinal = ? WHERE Aluguel_PK = ?");
            stmt.setDate(1, a.getDataFinal());
            stmt.setInt(2, a.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null, "Renovado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao renovar aluguel: " + ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
        
    }
    
}
