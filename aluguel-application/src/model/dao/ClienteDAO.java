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
import model.bean.Cliente;

/**
 *
 * @author romer
 */
public class ClienteDAO {
    public void create(Cliente cl){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente (PrimeiroNome, UltimoNome, Email, Documento, TipoCliente) VALUES (?, ?, ?, ?, ?)");
            stmt.setString(1, cl.getPrimeiroNome());
            stmt.setString(2, cl.getUltimoNome());
            stmt.setString(3, cl.getEmail());
            stmt.setString(4, cl.getDocumento());
            stmt.setInt(5, cl.getTipocliente());
            stmt.executeUpdate();
            
            stmt = con.prepareStatement("SELECT max(Cliente_PK) as codigo FROM Cliente");
            rs = stmt.executeQuery();
            while (rs.next()) {
                cl.setId(rs.getInt("codigo"));
            }
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar cliente: " + ex);
            Logger.getLogger(ConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
    }
    
    public List<Cliente> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Cliente> clientes = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Cliente");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Cliente cliente = new Cliente();
                cliente.setId(rs.getInt("Cliente_PK"));
                cliente.setPrimeiroNome(rs.getString("PrimeiroNome"));
                cliente.setUltimoNome(rs.getString("UltimoNome"));
                cliente.setEmail(rs.getString("Email"));
                cliente.setDocumento(rs.getString("Documento"));
                cliente.setTipocliente(rs.getInt("TipoCliente"));
                clientes.add(cliente);
                
            }
                    
            } 
        catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return clientes;
    }
     public void update(Cliente c) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET PrimeiroNome = ?, UltimoNome = ?, Email = ?, Documento = ?, TipoCliente = ? WHERE Cliente_PK = ?");
            stmt.setString(1, c.getPrimeiroNome());
            stmt.setString(2, c.getUltimoNome());
            stmt.setString(3, c.getEmail());
            stmt.setString(4, c.getDocumento());
            stmt.setInt(5, c.getTipocliente());
            stmt.setInt(6, c.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao atualizar: " + ex);
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    public void delete(Cliente cl) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;

        try {
            stmt = con.prepareStatement("DELETE from cliente WHERE Cliente_PK = ?");
            stmt.setInt(1, cl.getId());

            stmt.executeUpdate();

            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);

        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

}
    

