package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import com.jfoenix.controls.JFXTimePicker;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import javafx.fxml.FXML;
import modelo.Jogo;
import persistencia.JogoDAO;

public class ControladorCalendarioAdicionarPartida {

    JogoDAO jogoDAO = new JogoDAO();

    @FXML
    private JFXDatePicker datePartida;

    @FXML
    private JFXTimePicker timePartida;

    @FXML
    private JFXTextField textCamp, textAdv, textLocal;

    @FXML
    private JFXButton btCadastrarPartida;

    @FXML
    private JFXButton btCancelar;

    @FXML
    private JFXRadioButton rbCasa, rbFora;

    @FXML
    private void cadastrarPartida() {

        int idTime = ControladorLogin.idTime;

        Date d = Date.from(datePartida.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        String date = formatador.format(d);

        int h = timePartida.getValue().getHour();
        int m = timePartida.getValue().getMinute();
        String hora = h + ":" + m;

        String dh = date + " / " + hora;

        boolean stCouF = true;
        if (rbFora.isSelected()) {
            stCouF = false;
        }

        Jogo j = new Jogo(dh, textLocal.getText(), textAdv.getText(), textCamp.getText(), false, stCouF, idTime);
        jogoDAO.insertIntoJogo(j);

        ControladorPrincipal.controlador.gerenciarJogos();
        
    }

    @FXML
    private void cancelarCP() {
        
        ControladorPrincipal.controlador.gerenciarJogos();
        
    }

}
