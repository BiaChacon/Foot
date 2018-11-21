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

public class ControladorAtletaCadastrar implements Initializable {

    AtletaDAO atletaDAO = new AtletaDAO();
    
    @FXML
    private JFXTextField textNome;
    
    @FXML
    private JFXTextField textCPF;
    
    @FXML
    private JFXTextField textEndereco;
    
    @FXML
    private JFXTextField textTelefone;
    
    @FXML
    private JFXTextField textEmail;
    
    @FXML
    private JFXTextField textSalario;
    
    @FXML
    private JFXDatePicker dateNascimento;
    
    @FXML
    private JFXButton btCadastrar, btCancelar;

    @FXML
    private void cadastrarAtleta() {
        
        double salario = Double.parseDouble(textSalario.getText());

        int telefone = Integer.parseInt(textTelefone.getText());

        Date dn = Date.from(dateNascimento.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        
        java.sql.Date dnSql = new java.sql.Date(dn.getTime());

        Atleta a = new Atleta(textNome.getText(), textCPF.getText(), dnSql, telefone, textEmail.getText(), textEndereco.getText(), salario);

        atletaDAO.insertIntoAtleta(a);

        ControladorPrincipal.controlador.gerenciarAtletas();
    }
    
    @FXML
    private void cancelarCA() {
       ControladorPrincipal.controlador.gerenciarAtletas(); 
    }
    
    /*public static void mascaraCPF(TextField textField) {

        textField.setOnKeyTyped((KeyEvent event) -> {
            if ("0123456789".contains(event.getCharacter()) == false) {
                event.consume();
            }

            if (event.getCharacter().trim().length() == 0) { // apagando

                if (textField.getText().length() == 4) {
                    textField.setText(textField.getText().substring(0, 3));
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 8) {
                    textField.setText(textField.getText().substring(0, 7));
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 12) {
                    textField.setText(textField.getText().substring(0, 11));
                    textField.positionCaret(textField.getText().length());
                }

            } else { // escrevendo

                if (textField.getText().length() == 14) {
                    event.consume();
                }

                if (textField.getText().length() == 3) {
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 7) {
                    textField.setText(textField.getText() + ".");
                    textField.positionCaret(textField.getText().length());
                }
                if (textField.getText().length() == 11) {
                    textField.setText(textField.getText() + "-");
                    textField.positionCaret(textField.getText().length());
                }

            }
        });

        textField.setOnKeyReleased((KeyEvent evt) -> {

            if (!textField.getText().matches("\\d.-*")) {
                textField.setText(textField.getText().replaceAll("[^\\d.-]", ""));
                textField.positionCaret(textField.getText().length());
            }
        });

    }
    */
    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
