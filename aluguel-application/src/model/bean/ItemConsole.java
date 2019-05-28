package model.bean;

public class ItemConsole {
    private int id;
    private Aluguel aluguel;
    private Console console;

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

    public Console getConsole() {
        return console;
    }

    public void setConsole(Console console) {
        this.console = console;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }
    
    
}
