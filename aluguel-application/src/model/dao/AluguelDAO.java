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
            stmt = con.prepareStatement("INSERT INTO aluguel (DataAbertura, DataInicio, DataFinal, DataFechamento, ValorTotal, NumeroControles, CodCliente) VALUES (?, ?, ?, ?, ?, ?, ?)");
            stmt.setDate(1, a.getDataAbertura());
            stmt.setDate(2, a.getDataInicio());
            stmt.setDate(3, a.getDataFinal());
            stmt.setDate(4, a.getDataFechamento());
            stmt.setDouble(5, a.getValorTotal());
            stmt.setInt(6, a.getNumeroControles());
            stmt.setInt(7, a.getCliente());
            
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
                a.setDataAbertura(rs.getDate("DataAbertura"));
                a.setDataFinal(rs.getDate("DataFinal"));
                a.setDataFechamento(rs.getDate("DataFechamento"));
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
}
