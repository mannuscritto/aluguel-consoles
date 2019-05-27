package model.bean;

public class Console {
    private int id;
    private String numeroSerie;
    private double precoAluguel;
    private String capacArmaz;
    private TipoConsole tipoConsole;
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

    public TipoConsole getTipoConsole() {
        return tipoConsole;
    }

    public void setTipoConsole(TipoConsole tipoConsole) {
        this.tipoConsole = tipoConsole;
    }

    public int getConta() {
        return conta;
    }

    public void setConta(int conta) {
        this.conta = conta;
    }

    @Override
    public String toString() {
        return getNumeroSerie();
    }
    
}
