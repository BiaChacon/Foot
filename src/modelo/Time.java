package modelo;

import java.sql.Date;
import javafx.scene.image.ImageView;

public class Time {
    
    private int id;
    private String usuario;
    private String senha;
    private String nome;
    private Date dataFundacao;
    private double patrimonio;
    private ImageView fotoTime;

    public Time(int id, String usuario, String senha, String nome, Date dataFundacao, double patrimonio, ImageView fotoTime) {
        this.id = id;
        this.usuario = usuario;
        this.senha = senha;
        this.nome = nome;
        this.dataFundacao = dataFundacao;
        this.patrimonio = patrimonio;
        this.fotoTime = fotoTime;
    }

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
