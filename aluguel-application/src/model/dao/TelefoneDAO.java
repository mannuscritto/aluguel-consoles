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
import model.bean.Telefone;

/**
 *
 * @author romer
 */
public class TelefoneDAO {
    public void create(Telefone tl){
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO telefone (CodArea, Numero, Cliente) VALUES (?, ?, ?)");
            stmt.setInt(1, tl.getCodArea());
            stmt.setLong(2, tl.getNumero());
            stmt.setInt(3, tl.getCliente().getId());
        
            
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar telefone: " + ex);
            Logger.getLogger(ConsoleDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Telefone> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Telefone> telefones = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Telefone");
            rs = stmt.executeQuery();
            ClienteDAO cdao = new ClienteDAO();
            while (rs.next())
            {
                Telefone telefone = new Telefone();
                telefone.setId(rs.getInt("Telefone_PK"));
                telefone.setCodArea(rs.getInt("CodArea"));
                telefone.setNumero(rs.getLong("Numero"));
                telefone.setCliente(cdao.search(rs.getInt("Cliente")));
                telefones.add(telefone);
                
            }
                    
            } 
        catch (SQLException ex) {
            Logger.getLogger(ClienteDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return telefones;
    }
     public void update(Telefone tl) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE Telefone SET CodArea = ?,Numero = ?,Cliente = ? WHERE Telefone_PK = ?");
            stmt.setInt(1, tl.getCodArea());
            stmt.setLong(2, tl.getNumero());
            stmt.setInt(3, tl.getCliente().getId());
            stmt.setInt(4, tl.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            
           
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
      public void delete(Telefone tl) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE FROM Telefone WHERE Telefone_PK = ?");
            stmt.setInt(1, tl.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
          
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }

    

    public Telefone search(int pk) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Telefone tel = new Telefone();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM telefone WHERE Telefone_PK = ?");
            stmt.setInt(1, pk);
            rs = stmt.executeQuery();
            ClienteDAO cdao = new ClienteDAO();
            if (rs.last()) {                         
                tel.setId(rs.getInt("Telefone_PK"));
                tel.setCliente(cdao.search(rs.getInt("Cliente")));
                tel.setCodArea(rs.getInt("Telefone_PK"));
                tel.setNumero(rs.getInt("Telefone_PK"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TelefoneDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return tel;
    }
    
}
