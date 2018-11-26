package modelo;

import java.sql.Date;
import java.util.ArrayList;

public class Financeiro {

    private int id;
    private Date dataBalanco;
    private double patrocinios;
    private double despesas;
    private double lucroPartidas;
    private double salarios;
    private double total;
    private int time;

    public Financeiro(int id, Date dataBalanco, double patrocinios, double despesas, double lucroPartidas, double salarios, double total, int time) {
        this.id = id;
        this.dataBalanco = dataBalanco;
        this.patrocinios = patrocinios;
        this.despesas = despesas;
        this.lucroPartidas = lucroPartidas;
        this.salarios = salarios;
        this.total = total;
        this.time = time;
    }

    public Financeiro() {}

    private ArrayList<Patrocinio> listaPatrocinio = new ArrayList<>();

    private ArrayList<Despesa> listaDespesa = new ArrayList<>();

    private ArrayList<Partida> listaJogo = new ArrayList<>();

    private ArrayList<Atleta> listaAtleta = new ArrayList<>();

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getDataBalanco() {
        return dataBalanco;
    }

    public void setDataBalanco(Date dataBalanco) {
        this.dataBalanco = dataBalanco;
    }

    public double getPatrocinios() {
        return patrocinios;
    }

    public void setPatrocinios(ArrayList<Patrocinio> listaPatrocinio) {
        for (int i = 0; i < listaPatrocinio.size(); i++) {
            patrocinios += listaPatrocinio.get(i).getValor();
        }
        this.patrocinios = patrocinios;
    }

    public double getDespesas() {
        return despesas;
    }

    public void setDespesas(ArrayList<Despesa> listaDespesa) {
        for (int i = 0; i < listaDespesa.size(); i++) {
            despesas += listaDespesa.get(i).getValor();
        }
        this.despesas = despesas;
    }

    public double getLucroPartidas() {
        return lucroPartidas;
    }

    public void setLucroPartidas(ArrayList<Jogo> listaJogo) {
        for (int i = 0; i < listaJogo.size(); i++) {
            lucroPartidas += listaJogo.get(i).getLucroPartida();
        }
        this.lucroPartidas = lucroPartidas;
    }

    public double getSalarios() {
        return salarios;
    }

    public void setSalarios(ArrayList<Atleta> listaAtleta) {
        for (int i = 0; i < listaAtleta.size(); i++) {
            salarios += listaAtleta.get(i).getSalario();
        }
        this.salarios = salarios;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total, double patrocinios, double lucroPartidas, double despesas, double salarios) {
        total = (patrocinios + lucroPartidas) - (despesas + salarios);
        this.total = total;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }
    
}
