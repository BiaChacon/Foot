package modelo;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class Atleta {

    private String nome, cpf, email, endereco;
    private int telefone;
    private double salario;
    private Date dataNasc;
    //private String date;
    
    public Atleta(String nome, String cpf, Date dataNasc, int telefone, String email, String endereco, double salario) {
        this.nome = nome;
        this.cpf = cpf;
        this.email = email;
        this.telefone = telefone;
        this.endereco = endereco;
        this.dataNasc = dataNasc;
        this.salario = salario;
        
        /*SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
        date = formatter.format(dataNasc);*/
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public Date getDataNasc() {
        return dataNasc;
    }

    public void setDataNasc(Date dataNasc) {
        this.dataNasc = dataNasc;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    @Override
    public String toString() {
        return nome;
    }
}
