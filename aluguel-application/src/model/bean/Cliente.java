package model.bean;

public class Cliente {
    private int id;
    private String primeiroNome;
    private String ultimoNome;
    private String email;
    private String documento;
    private int tipocliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPrimeiroNome() {
        return primeiroNome;
    }

    public void setPrimeiroNome(String primeiroNome) {
        this.primeiroNome = primeiroNome;
    }

    public String getUltimoNome() {
        return ultimoNome;
    }

    public void setUltimoNome(String ultimoNome) {
        this.ultimoNome = ultimoNome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public int getTipocliente() {
        return tipocliente;
    }

    public void setTipocliente(int tipocliente) {
        this.tipocliente = tipocliente;
    }

    @Override
    public String toString() {
        return getPrimeiroNome();
    }
}
