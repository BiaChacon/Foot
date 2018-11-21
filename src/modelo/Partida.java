package modelo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Partida {

    Jogo j;
    Time t;
    private int id;
    private String dataPartida;
    private String local;
    private String timeCasa;
    private String x;
    private String timeFora;
    private String compreticao;
    private double reda;
    private boolean status;
    private boolean stCouF;
    private ImageView st;

    public Partida(int id, String dataPartida, String local, String timeCasa, String timeFora, String compreticao, double reda, boolean status, boolean stCouF, ImageView st) {
        this.id = id;
        this.dataPartida = dataPartida;
        this.local = local;
        this.timeCasa = timeCasa;
        this.timeFora = timeFora;
        this.compreticao = compreticao;
        this.reda = reda;
        this.status = status;
        this.stCouF = stCouF;
        this.st = st;
    }

    public Partida() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDataPartida() {
        return dataPartida;
    }

    public void setDataPartida(String dataPartida) {
        this.dataPartida = dataPartida;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public String getTimeCasa() {
        return timeCasa;
    }

    public void setTimeCasa(String timeCasa) {
        this.timeCasa = timeCasa;
    }

    public String getTimeFora() {
        return timeFora;
    }

    public void setTimeFora(String timeFora) {
        this.timeFora = timeFora;
    }

    public String getCompreticao() {
        return compreticao;
    }

    public void setCompreticao(String compreticao) {
        this.compreticao = compreticao;
    }

    public double getReda() {
        return reda;
    }

    public void setReda(double reda) {
        this.reda = reda;
    }

    public boolean isStCouF() {
        return stCouF;
    }

    public void setStCouF(boolean stCouF) {
        this.stCouF = stCouF;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public ImageView getSt() {
        return st;
    }

    public void setSt() {
        Image img;
        if (status) {
            img = new Image("visao/img/checked.png", 25, 25, false, false);
        } else {
            img = new Image("visao/img/x-button.png", 25, 25, false, false);
        }
        ImageView st = new ImageView(img);
        this.st = st;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

}
