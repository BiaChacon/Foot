package modelo;

import javafx.scene.image.ImageView;

public class Time {
    
    private int id;
    private String usuario;
    private String senha;
    private String nome;
    private String dataFundacao;
    private double patrimonio;
    private ImageView fotoTime;

    public Time(int id, String usuario, String senha, String nome, String dataFundacao, double patrimonio, ImageView fotoTime) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.patrimonio = patrimonio;
        this.fotoTime = fotoTime;
    }

    public Time(int id, String nome, String dataFundacao, double patrimonio) {
        this.id = id;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.patrimonio = patrimonio;
    }

    
    public Time(int id, String nome, String dataFundacao, double patrimonio, ImageView fotoTime) {
        this.id = id;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.patrimonio = patrimonio;
        this.fotoTime = fotoTime;
    }

    public Time(String nome, double patrimonio, String dataFundacao) {
        this.nome = nome;
        this.patrimonio = patrimonio;
        this.dataFundacao = dataFundacao;
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
    
    public ImageView getFotoTime() {
        return fotoTime;
    }

    public void setFotoTime(ImageView fotoTime) {
        this.fotoTime = fotoTime;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPatrocinio() {
        return patrimonio;
    }

    public void setPatrocinio(double patrimonio) {
        this.patrimonio = patrimonio;
    }

    public String getDataFundacao() {
        return dataFundacao;
    }

    public void setDataFundacao(String dataFundacao) {
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
