package modelo;

import java.sql.Date;

public class Time {

    private int id;
    private String usuario;
    private String senha;
    private String nome;
    private Date dataFundacao;
    private double patrimonio;

    public Time(int id, String usuario, String senha, String nome, Date dataFundacao, double patrimonio) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.patrimonio = patrimonio;
    }

    public Time(String usuario, String senha, String nome, Date dataFundacao, double patrimonio) {
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.patrimonio = patrimonio;
    }

    public Time(String usuario, String senha) {
        this.usuario = usuario;
        this.senha = senha;
    }

    public Time() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getPatrimonio() {
        return patrimonio;
    }

    public void setPatrimonio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Date getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(Date dataFundacao) {
        this.dataFundacao = dataFundacao;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

}
