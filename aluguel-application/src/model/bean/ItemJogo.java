package model.bean;

public class ItemJogo {
    private int id;
    private Aluguel aluguel;
    private Jogo jogo;
    private int quantidade;

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

    public Jogo getJogo() {
        return jogo;
    }

    public void setJogo(Jogo jogo) {
        this.jogo = jogo;
    }

    public int getJogoId() {
        return this.jogo.getId();
    }
    
    public void setJogoId(int jogoId) {
        getJogo().setId(jogoId);
    }
    
    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        return String.valueOf(this.getId());
    }
}
