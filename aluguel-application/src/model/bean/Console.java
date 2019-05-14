package model.bean;

public class Console {
    private int id;
    private String numeroSerie;
    private double precoAluguel;
    private String capacArmaz;
    private int tipoConsole;
    private int conta;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumeroSerie() {
        return numeroSerie;
    }

    public void setNumeroSerie(String numeroSerie) {
        this.numeroSerie = numeroSerie;
    }

    public double getPrecoAluguel() {
        return precoAluguel;
    }

    public void setPrecoAluguel(double precoAluguel) {
        this.precoAluguel = precoAluguel;
    }

    public String getCapacArmaz() {
        return capacArmaz;
    }

    public void setCapacArmaz(String capacArmaz) {
        this.capacArmaz = capacArmaz;
    }

    public int getTipoConsole() {
        return tipoConsole;
    }

    public void setTipoConsole(int tipoConsole) {
        this.tipoConsole = tipoConsole;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }
    
    
}
