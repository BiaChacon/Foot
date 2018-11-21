package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import modelo.Jogo;
import persistencia.JogoDAO;

public class ControladorCalendarioConcluirPartida {

    JogoDAO jogoDAO = new JogoDAO();
    private int partidaID;

    @FXML
    private JFXButton btConcluirPartida;

    @FXML
    private JFXTextField textLucro;
    @FXML
    private JFXButton btCancelarAL;

    public void setPartidaID(int id) {
        partidaID = id;
    }
    
    @FXML
    private void concluirPartida() {
        
        double lucro = Double.parseDouble(textLucro.getText());

        Jogo j = new Jogo(lucro, true);
        j.setId(partidaID);

        jogoDAO.updateLucroIntoJogo(j);

        ControladorPrincipal.controlador.gerenciarJogos();
    }

    @FXML
    private void cancelarAL() {
        ControladorPrincipal.controlador.gerenciarJogos();
    }

}
