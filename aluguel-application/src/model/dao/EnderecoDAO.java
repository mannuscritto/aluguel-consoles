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
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import model.bean.Endereco;

/**
 *
 * @author romer
 */
public class EnderecoDAO {
    public void create(Endereco end){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO endereco (id, rua, numero, complemento, bairro, cidade, uf, cep, cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, end.getId());
            stmt.setString(2, end.getRua());
            stmt.setString(3, end.getComplemento());
            stmt.setString(4, end.getBairro());
            stmt.setString(5, end.getCidade());
            stmt.setString(6, end.getUf());
            stmt.setString(7, end.getCep());
            stmt.setInt(8, end.getCliente());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            Logger.getLogger(ConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Endereco> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Endereco> Enderecos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Endereco");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("id"));
                endereco.setRua(rs.getString("Rua"));
                endereco.setNumero(rs.getInt("Numero"));
                endereco.setComplemento(rs.getString("Complemento"));
                endereco.setBairro(rs.getString("Bairro"));
                endereco.setCidade(rs.getString("Cidade"));
                endereco.setUf(rs.getString("Uf"));
                endereco.setCep(rs.getString("Cep"));
                endereco.setCliente(rs.getInt("cliente"));
                
              
                endereco.add(endereco);
                
            }
                    
            } 
        catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return enderecos;
    }
     public void update(Enderecos end) {
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
      public void delete(Endereco end) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from jogo WHERE Endereco_PK = ?");
            stmt.setInt(1, end.getId());
            
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
