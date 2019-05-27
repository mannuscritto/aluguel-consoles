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
        
        try {
            stmt = con.prepareStatement("INSERT INTO aluguel (DataInicio, DataFinal, ValorTotal, NumeroControles, CodCliente) VALUES (?, ?, ?, ?, ?)");
            stmt.setDate(1, a.getDataInicio());
            stmt.setDate(2, a.getDataFinal());
            stmt.setDouble(3, a.getValorTotal());
            stmt.setInt(4, a.getNumeroControles());
            stmt.setInt(5, a.getCliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(AluguelDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Aluguel> read() {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        List<Aluguel> alugueis = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM aluguel");
            rs = stmt.executeQuery();
            
            while (rs.next()) {
                Aluguel a = new Aluguel();
                a.setId(rs.getInt("Aluguel_PK"));
                a.setDataAbertura(rs.getString("DataAbertura"));
                a.setDataFinal(rs.getString("DataFinal"));
                a.setDataFechamento(rs.getString("DataFechamento"));
                a.setValorTotal(rs.getDouble("ValorTotal"));
                a.setNumeroControles(rs.getInt("NumeroControles"));
                a.setCliente(rs.getInt("CodCliente"));
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
            stmt.setInt(5, a.getCliente());
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
}
