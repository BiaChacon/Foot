package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.time.ZoneId;
import java.util.Date;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import modelo.Time;
import persistencia.TimeDAO;

public class ControladorCadastrarTime {

    TimeDAO timeDAO = new TimeDAO();

    @FXML
    private JFXButton btCadastrarTime, btCancelarCt;

    @FXML
    private JFXDatePicker dtFund;

    @FXML
    private JFXTextField textSenha, textPatrimonio, textNomeTime, textUser;
    @FXML
    private Label labelMensg;

    @FXML
    private void cancelarCt() {
        ControladorLogin.controladorLogin.inicio();
    }

    @FXML
    private void cadastrarTime() {

        Date df = Date.from(dtFund.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date dfSql = new java.sql.Date(df.getTime());

        double patrimonio = Double.parseDouble(textPatrimonio.getText());

        Time t = new Time(textUser.getText(), textSenha.getText(), textNomeTime.getText(), dfSql, patrimonio);

        Boolean v = timeDAO.verificarTime(t);
        if (v) {
            labelMensg.setText("Usuário já existe");
        } else {
            timeDAO.insertIntoTime(t);
            ControladorLogin.controladorLogin.inicio();
        }
    }

}
