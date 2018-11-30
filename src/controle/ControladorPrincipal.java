package controle;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import modelo.Time;

public class ControladorPrincipal implements Initializable {

    static ControladorPrincipal controlador;

    Time t = new Time();

    @FXML
    private JFXButton btInicio, btAtleta, btCalendario, btFinanceiro, btConfiguracao, btSobre, btSair;

    @FXML
    BorderPane borderPrincipal;

    @FXML
    private AnchorPane anchorInicial;

    @FXML
    Label labelPrincipal;

    @FXML
    private Label labelNomeTime;

    @FXML
    private Label labelDataFundacao;

    @FXML
    private ImageView imagem;

    @FXML
    private Label labelPatrimonio;

    @FXML
    private void inicio() {

        borderPrincipal.setCenter(anchorInicial);
        labelPrincipal.setText("INÍCIO");

        labelNomeTime.setText(ControladorLogin.time.getNome());

        double num = ControladorLogin.time.getPatrimonio();
        String p = Double.toString(num);
        labelPatrimonio.setText(p);

        String d = String.valueOf(ControladorLogin.time.getDataFundacao());
        labelDataFundacao.setText(d);

    }

    @FXML
    void gerenciarAtletas() {

        try {
            Parent gerenciarAtleta = FXMLLoader.load(getClass().getResource("/visao/Atleta.fxml"));
            borderPrincipal.setCenter(gerenciarAtleta);
            labelPrincipal.setText("ATLETA");
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void gerenciarJogos() {

        try {
            Parent gerenciarJogos = FXMLLoader.load(getClass().getResource("/visao/Calendario.fxml"));
            borderPrincipal.setCenter(gerenciarJogos);
            labelPrincipal.setText("CALENDÁRIO");
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void financeiro() {

        try {
            Parent financeiro = FXMLLoader.load(getClass().getResource("/visao/Financeiro.fxml"));
            borderPrincipal.setCenter(financeiro);
            labelPrincipal.setText("FINANCEIRO");
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void sobre() {

        try {
            Parent sobre = FXMLLoader.load(getClass().getResource("/visao/Sobre.fxml"));
            borderPrincipal.setCenter(sobre);
            labelPrincipal.setText("SOBRE");
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    void configuracao() {

        try {
            Parent configuracao = FXMLLoader.load(getClass().getResource("/visao/ConfiguracaoTime.fxml"));
            borderPrincipal.setCenter(configuracao);
            labelPrincipal.setText("CONFIGURAÇÕES");
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void sair() {

        ControladorLogin.controladorLogin.inicio();
        ControladorLogin.idTime = 0;

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        controlador = this;
        inicio();

    }

}
