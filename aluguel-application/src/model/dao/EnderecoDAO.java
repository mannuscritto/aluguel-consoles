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
            stmt = con.prepareStatement("INSERT INTO endereco (Rua, Numero, Complemento, Bairro, Cidade, UF, CEP, Cliente) VALUES (?, ?, ?, ?, ?, ?, ?, ?)");
            stmt.setString(1, end.getRua());
            stmt.setInt(2, end.getNumero());
            stmt.setString(3, end.getComplemento());
            stmt.setString(4, end.getBairro());
            stmt.setString(5, end.getCidade());
            stmt.setString(6, end.getUf());
            stmt.setString(7, end.getCep());
            stmt.setInt(8, end.getCliente().getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar endereço: " + ex);
            Logger.getLogger(ConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Endereco> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Endereco> enderecos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Endereco");
            rs = stmt.executeQuery();
            
            ClienteDAO cdao = new ClienteDAO();
            while (rs.next())
            {
                Endereco endereco = new Endereco();
                endereco.setId(rs.getInt("Endereco_PK"));
                endereco.setRua(rs.getString("Rua"));
                endereco.setNumero(rs.getInt("Numero"));
                endereco.setComplemento(rs.getString("Complemento"));
                endereco.setBairro(rs.getString("Bairro"));
                endereco.setCidade(rs.getString("Cidade"));
                endereco.setUf(rs.getString("Uf"));
                endereco.setCep(rs.getString("Cep"));
                endereco.setCliente(cdao.search(rs.getInt("Cliente")));
                
              
                enderecos.add(endereco);
                
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
     public void update(Endereco end) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE endereco SET Rua = ?, Numero = ?, Complemento = ?, Bairro = ?, Cidade = ?, UF = ?, CEP = ?, Cliente = ? WHERE Endereco_PK = ?");
            stmt.setString(1, end.getRua());
            stmt.setInt(2, end.getNumero());
            stmt.setString(3, end.getComplemento());
            stmt.setString(4, end.getBairro());
            stmt.setString(5, end.getCidade());
            stmt.setString(6, end.getUf());
            stmt.setString(7, end.getCep());
            stmt.setInt(8, end.getCliente().getId());
            stmt.setInt(9, end.getId());
            
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
            stmt = con.prepareStatement("DELETE from endereco WHERE Endereco_PK = ?");
            stmt.setInt(1, end.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
          
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    public Endereco search(int pk) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Endereco end = new Endereco();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM endereco WHERE Endereco_PK = ?");
            stmt.setInt(1, pk);
            rs = stmt.executeQuery();
            ClienteDAO cdao = new ClienteDAO();
            if (rs.last()) {
                            
                end.setId(rs.getInt("Endereco_PK"));
                end.setBairro(rs.getString("Bairro"));
                end.setCep(rs.getString("CEP"));
                end.setCidade(rs.getString("Cidade"));
                end.setCliente(cdao.search(rs.getInt("Cliente")));
                end.setComplemento(rs.getString("Complemento"));
                end.setNumero(rs.getInt("Numero"));
                end.setRua(rs.getString("Rua"));
                end.setUf(rs.getString("UF"));
                
             
            }
        } catch (SQLException ex) {
            Logger.getLogger(EnderecoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return end;
    }
    }

