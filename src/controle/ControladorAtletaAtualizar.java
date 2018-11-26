package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import modelo.Atleta;
import persistencia.AtletaDAO;

public class ControladorAtletaAtualizar implements Initializable {

    Atleta a;

    AtletaDAO atletaDAO = new AtletaDAO();

    @FXML
    private JFXTextField textNome, textCPF, textTelefone, textEndereco, textEmail, textSalario;

    @FXML
    private JFXDatePicker dateNascimento;

    @FXML
    private JFXButton btAtualizar;

    @FXML
    private void atualizarAtleta() {
        
        int idTime = ControladorLogin.idTime;
        
        double salario = Double.parseDouble(textSalario.getText());

        int telefone = Integer.parseInt(textTelefone.getText());

        Date dn = Date.from(dateNascimento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date dnSql = new java.sql.Date(dn.getTime());

        Atleta at = new Atleta(textNome.getText(), textCPF.getText(), dnSql, telefone, textEmail.getText(), textEndereco.getText(), salario, idTime);
        
        atletaDAO.UpdateIntoAtleta(at);
        
        ControladorPrincipal.controlador.gerenciarAtletas();
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        a = ControladorAtleta.c.a;

        textNome.setText(a.getNome());

        textCPF.setText(a.getCpf());
        textCPF.setDisable(true);

        dateNascimento.setValue(a.getDataNasc().toLocalDate());

        String telefone = String.valueOf(a.getTelefone());
        textTelefone.setText(telefone);

        textEmail.setText(a.getEmail());
        textEndereco.setText(a.getEndereco());

        String salario = String.valueOf(a.getSalario());
        textSalario.setText(salario);
    }
}
