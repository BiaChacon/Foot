package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import modelo.Time;
import persistencia.TimeDAO;

public class ControladorEditarTime implements Initializable {

    TimeDAO timeDAO = new TimeDAO();

    Time t;

    @FXML
    private JFXTextField textNomeT;

    @FXML
    private JFXDatePicker dtFund;

    @FXML
    private JFXTextField textUser;

    @FXML
    private JFXPasswordField textSenha;

    @FXML
    private JFXButton btCancelarEdit, btEdit;

    @FXML
    private void cancelarEdit() {
        ControladorPrincipal.controlador.configuracao();
    }

    @FXML
    private void editarTime() {

        Date df = Date.from(dtFund.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date dfSql = new java.sql.Date(df.getTime());

        Time team = new Time(ControladorLogin.idTime, textUser.getText(), textSenha.getText(), textNomeT.getText(), dfSql, ControladorLogin.time.getPatrimonio());

        Boolean v = timeDAO.verificarTime(team.getUsuario());
        System.out.println(v);
        if (v) {
            if (textUser.getText().equals(ControladorLogin.time.getUsuario())) {
                timeDAO.UpdateIntoTime(team);
                ControladorLogin.time = team;
                ControladorPrincipal.controlador.configuracao();

            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atenção");
                alert.setHeaderText("Nome de usuário de Time já existe");
                alert.setContentText("Escolha um usuário que não existe");
                alert.showAndWait();
            }
        } else {
            timeDAO.UpdateIntoTime(team);
            ControladorLogin.time = team;
            ControladorPrincipal.controlador.configuracao();

        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        t = ControladorLogin.time;

        textUser.setText(t.getUsuario());

        textSenha.setText(t.getSenha());

        textNomeT.setText(t.getNome());

        dtFund.setValue(t.getDataFundacao().toLocalDate());

    }

}
