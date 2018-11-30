package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import modelo.Patrocinio;
import persistencia.PatrocinioDAO;

public class ControladorFinanceiroAddPatrocinio {

    PatrocinioDAO patrocinioDAO = new PatrocinioDAO();

    @FXML
    private JFXTextField textNomeP;

    @FXML
    private JFXTextField textValorP;

    @FXML
    private JFXButton btAddPatrocinio;

    @FXML
    private JFXButton btCancelar;

    @FXML
    private void addPatrocinio() {

        int idFinanceiroTime = ControladorLogin.idTime;

        double valorP = Double.parseDouble(textValorP.getText());

        Patrocinio p = new Patrocinio(textNomeP.getText(), valorP, idFinanceiroTime);

        patrocinioDAO.insertIntoPatrocinio(p);

        ControladorPrincipal.controlador.financeiro();

    }

    @FXML
    private void cancelarAP() {

        ControladorPrincipal.controlador.financeiro();

    }

}
