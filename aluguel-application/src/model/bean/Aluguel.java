package model.bean;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class Aluguel {
    private int id;
    private Date dataAbertura;
    private Date dataInicio;
    private Date dataFinal;
    private Date dataFechamento;
    private double valorTotal;
    private int numeroControles;
    private Cliente cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataAbertura() {
        return dataAbertura;
    }

    public void setDataAbertura(Date dataAbertura) {
        this.dataAbertura = dataAbertura;
    }

    public Date getDataInicio() {
        return dataInicio;
    }

    public void setDataInicio(Date dataInicio) {
        this.dataInicio = dataInicio;
    }
    
    public void setDataInicio(String dataInicio) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date textFieldAsDate = null;
        
        try {
            textFieldAsDate = sdf.parse(dataInicio);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter String para Date: " + ex);
        }
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.dataInicio = Date.valueOf(sdf.format(textFieldAsDate));
    }

    public Date getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(Date dataFinal) {
        this.dataFinal = dataFinal;
    }
    
    public void setDataFinal(String dataFinal) {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        java.util.Date textFieldAsDate = null;
        
        try {
            textFieldAsDate = sdf.parse(dataFinal);
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao converter String para Date: " + ex);
        }
        sdf = new SimpleDateFormat("yyyy-MM-dd");
        this.dataFinal = Date.valueOf(sdf.format(textFieldAsDate));
    }

    public Date getDataFechamento() {
        return dataFechamento;
    }

    public void setDataFechamento(Date dataFechamento) {
        this.dataFechamento = dataFechamento;
    }

    public double getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(double valorTotal) {
        this.valorTotal = valorTotal;
    }

    public int getNumeroControles() {
        return numeroControles;
    }

    public void setNumeroControles(int numeroControles) {
        this.numeroControles = numeroControles;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }
}
