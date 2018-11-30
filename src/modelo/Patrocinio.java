package modelo;

public class Patrocinio {

    private String nome;
    private Double valor;
    private int id;
    private int financeiroTime;

    public Patrocinio(String nome, Double valor, int financeiroTime) {
        this.nome = nome;
        this.valor = valor;
        this.financeiroTime = financeiroTime;
    }

    public Patrocinio(String nome, Double valor, int id, int financeiroTime) {
        this.nome = nome;
        this.valor = valor;
        this.id = id;
        this.financeiroTime = financeiroTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getFinanceiroTime() {
        return financeiroTime;
    }

    public void setFinanceiroTime(int financeiroTime) {
        this.financeiroTime = financeiroTime;
    }

}
