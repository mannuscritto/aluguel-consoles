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
import model.bean.Jogo;

/**
 *
 * @author romer
 */
public class JogoDAO {
    public void create(Jogo j) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("INSERT INTO jogo (Titulo,Genero,FaixaEtaria,Plataforma,PrecoCompra,TipoMidia,Quantidade,PrecoAluguel,PrecoVenda) VALUES (?,?,?,?,?,?,?,?,?)");
            stmt.setString(1, j.getTitulo());
            stmt.setString(2, j.getGenero());
            stmt.setString(3, j.getFaixaEtaria());
            stmt.setInt(4, j.getPlataforma().getId());
            stmt.setDouble(5, j.getPrecoCompra());
            stmt.setString(6, j.getTipoMidia());
            stmt.setInt(7, j.getQuantidade());
            stmt.setDouble(8, j.getPrecoAluguel());
            stmt.setDouble(9, j.getPrecoVenda());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Salvo com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao salvar: " + ex);
            
           
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
    
    public List<Jogo> read(){
        
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        
        List<Jogo> jogos = new ArrayList<>();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM Jogo");
            rs = stmt.executeQuery();
            
            while (rs.next())
            {
                Jogo jogo = new Jogo();
                TipoConsoleDAO tpdao = new TipoConsoleDAO();
                jogo.setId(rs.getInt("Jogo_PK"));
                jogo.setTitulo(rs.getString("Titulo"));
                jogo.setGenero(rs.getString("Genero"));
                jogo.setFaixaEtaria(rs.getString("FaixaEtaria"));
                jogo.setPlataforma(tpdao.search(rs.getInt("Plataforma")));
                jogo.setPrecoCompra(rs.getDouble("PrecoCompra"));
                jogo.setTipoMidia(rs.getString("TipoMidia"));
                jogo.setQuantidade(rs.getInt("Quantidade"));
                jogo.setPrecoAluguel(rs.getDouble("PrecoAluguel"));
                jogo.setPrecoVenda(rs.getDouble("PrecoVenda"));
                jogos.add(jogo);
                
            }
                    
            } 
        catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        finally
        {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return jogos;
    }
     public void update(Jogo j) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("UPDATE jogo SET Titulo = ?,Genero = ?,FaixaEtaria = ?"
                    + ",Plataforma = ?,PrecoCompra = ?,TipoMidia = ?,Quantidade = ?"
                    + ",PrecoAluguel = ?,PrecoVenda = ? WHERE Jogo_PK = ?");
            stmt.setString(1, j.getTitulo());
            stmt.setString(2, j.getGenero());
            stmt.setString(3, j.getFaixaEtaria());
            stmt.setInt(4, j.getPlataforma().getId());
            stmt.setDouble(5, j.getPrecoCompra());
            stmt.setString(6, j.getTipoMidia());
            stmt.setInt(7, j.getQuantidade());
            stmt.setDouble(8, j.getPrecoAluguel());
            stmt.setDouble(9, j.getPrecoVenda());
            stmt.setInt(10, j.getId());
            
            stmt.executeUpdate();
            
            //JOptionPane.showMessageDialog(null, "Atualizado com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Atualizar: " + ex);
            
           
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    
    }
      public void delete(Jogo j) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        
        try {
            stmt = con.prepareStatement("DELETE from jogo WHERE Jogo_PK = ?");
            stmt.setInt(1, j.getId());
            
            stmt.executeUpdate();
            
            JOptionPane.showMessageDialog(null, "Excluido com sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao excluir: " + ex);
          
        } finally {
            ConnectionFactory.closeConnection(con, stmt);
        }
    }
      
     public Jogo search(int pk) {
        Connection con = ConnectionFactory.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        Jogo j = new Jogo();
        
        try {
            stmt = con.prepareStatement("SELECT * FROM jogo WHERE Jogo_PK = ?");
            stmt.setInt(1, pk);
            rs = stmt.executeQuery();
            
            if (rs.last()) {
                TipoConsoleDAO tpdao = new TipoConsoleDAO();
                j.setId(rs.getInt("Jogo_PK"));
                j.setTitulo(rs.getString("Titulo"));
                j.setGenero(rs.getString("Genero"));
                j.setFaixaEtaria(rs.getString("FaixaEtaria"));
                j.setPlataforma(tpdao.search(rs.getInt("Plataforma")));
                j.setPrecoCompra(rs.getDouble("PrecoCompra"));
                j.setTipoMidia(rs.getString("TipoMidia"));
                j.setQuantidade(rs.getInt("Quantidade"));
                j.setPrecoAluguel(rs.getDouble("PrecoAluguel"));
                j.setPrecoVenda(rs.getDouble("PrecoVenda"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(JogoDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            ConnectionFactory.closeConnection(con, stmt, rs);
        }
        
        return j;
    }
}
