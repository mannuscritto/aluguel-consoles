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
        
        try {
            stmt = con.prepareStatement("INSERT INTO cliente (primeiroNome, ultimoNome, email, documento, tipocliente) VALUES (?, ?, ?, ?, ?, ?)");
            stmt.setString(1, cl.getPrimeiroNome());
            stmt.setString(2, cl.getUltimoNome());
            stmt.setString(3, cl.getEmail());
            stmt.setString(4, cl.getDocumento());
            stmt.setInt(5, cl.getTipocliente());
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(ConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
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
                
                cliente.setPrimeiroNome(rs.getString("primeiroNome"));
                cliente.setUltimoNome(rs.getString("ultimoNome"));
                cliente.setEmail(rs.getString("email"));
                cliente.setDocumento(rs.getString("documento"));
                cliente.setTipocliente(rs.getInt("id"));
                cliente.add(cliente);
                
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
     public void update(Cliente cl) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE cliente SET PrimeiroNome = ?,UltimoNome = ?,Email = ?"
                    + ",Documento = ?,TipoCliente = ? WHERE Cliente_PK = ?");
            stmt.setString(1, cl.getPrimeiroNome());
            stmt.setString(2, cl.getUltimoNome());
            stmt.setString(3, cl.getEmail());
            stmt.setString(4, cl.getDocumento());
            stmt.setInt(5, cl.getTipocliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            
           
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
      public void delete(Cliente cl) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from jogo WHERE Cliente_PK = ?");
            stmt.setInt(1, cl.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
          
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public void create() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    

