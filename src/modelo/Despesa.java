package modelo;

public class Despesa {

    private String nome;
    private Double valor;
    private int id;

    public Despesa(String nome, Double valor) {
        this.nome = nome;
        this.valor = valor;
    }

    public Despesa(String nome, Double valor, int id) {
        this.nome = nome;
        this.valor = valor;
        this.id = id;
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
}
