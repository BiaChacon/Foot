package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

public class ControladorLogin implements Initializable {

    static ControladorLogin controladorLogin;

    @FXML
    private BorderPane borderLogin;
    @FXML
    private AnchorPane anchorLogin;
    @FXML
    private JFXButton login;
    @FXML
    private JFXButton btCadastrar;
    @FXML
    private JFXTextField textSenha;
    @FXML
    private JFXTextField textUser;
    
    @FXML
    void login() {

        try {
            Parent login = FXMLLoader.load(getClass().getResource("/visao/Principal.fxml"));
            borderLogin.setCenter(login);
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void cadastrarTime() {

        try {
            Parent cadastrarTime = FXMLLoader.load(getClass().getResource("/visao/CadastrarTime.fxml"));
            borderLogin.setCenter(cadastrarTime);
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    void inicio(){
       
        try {
            Parent inicio = FXMLLoader.load(getClass().getResource("/visao/Login.fxml"));
            borderLogin.setCenter(inicio);
        } catch (IOException ex) {
            Logger.getLogger(ControladorLogin.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        controladorLogin = this;
    }

}
