package controle;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;

public class ControladorConfiguracaoTime {

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
    
}
