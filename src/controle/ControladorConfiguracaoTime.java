package controle;

import java.io.IOException;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import persistencia.TimeDAO;

public class ControladorConfiguracaoTime {

    TimeDAO timeDAO = new TimeDAO();

    @FXML
    private void editarTime() {

        try {
            Parent editarTime = FXMLLoader.load(getClass().getResource("/visao/EditarTime.fxml"));
            ControladorPrincipal.controlador.borderPrincipal.setCenter(editarTime);
        } catch (IOException ex) {
            Logger.getLogger(ControladorConfiguracaoTime.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void editarImagem() {

    }

    @FXML
    private void apagarTime() {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Confirmação");
        alert.setHeaderText("Confirmar exclusão de Time");
        alert.setContentText("Tem certeza que deseja excluir o Time?");
        Optional<ButtonType> result = alert.showAndWait();
        if (result.get() == ButtonType.OK) {
            timeDAO.deleteFromTime(ControladorLogin.idTime);
        }

        ControladorLogin.controladorLogin.inicio();
        
    }

}
