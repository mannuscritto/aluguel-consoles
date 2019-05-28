package model.bean;

public class ItemConsole {
    private int id;
    private Aluguel aluguel;
    private int console;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Aluguel getAluguel() {
        return aluguel;
    }

    public void setAluguel(Aluguel aluguel) {
        this.aluguel = aluguel;
    }

    public int getConsole() {
        return console;
    }

    public void setConsole(int console) {
        this.console = console;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }
    
    
}
