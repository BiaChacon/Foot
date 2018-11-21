package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.text.SimpleDateFormat;
import java.time.ZoneId;
import java.util.Date;
import javafx.fxml.FXML;
import modelo.Time;

public class ControladorEditarTime {

    Time t = new Time();
    
    @FXML
    private JFXTextField textNomeT;

    @FXML
    private JFXButton btCancelarEdit, btEdit;

    @FXML
    private JFXDatePicker dtFund;

    @FXML
    private void cancelarEdit() {
        ControladorPrincipal.controlador.configuracao();
    }

    @FXML
    private void editarTime() {
        
        /*nome = textNomeT.getText();

        Date d = Date.from(dtFund.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        SimpleDateFormat formatador = new SimpleDateFormat("dd-MM-yyyy");
        dataFund = formatador.format(d);
        
        t.setNome(nome);
        t.setDataFundacao(dataFund);*/
        
        ControladorPrincipal.controlador.configuracao();
        
    }

}
