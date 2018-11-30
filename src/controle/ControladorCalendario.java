package controle;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import modelo.Jogo;
import modelo.Partida;
import modelo.Time;
import persistencia.JogoDAO;

public class ControladorCalendario implements Initializable {

    JogoDAO jogoDAO = new JogoDAO();

    @FXML
    private Button btAdicionarPartida, btCancelarPartida, btConcluirPartida;

    @FXML
    private TableView<Partida> tabelaCalendario;

    @FXML
    private TableColumn<Partida, String> colunaDataHorario;

    @FXML
    private TableColumn<Partida, String> colunaLocalJogo;

    @FXML
    private TableColumn<Partida, String> colunaTimeCasa;

    @FXML
    private TableColumn<Partida, String> colunaX;

    @FXML
    private TableColumn<Partida, String> coluaTimeFora;

    @FXML
    private TableColumn<Partida, String> colunaCompeticao;

    @FXML
    private TableColumn<Partida, Double> colunaRendaPartida;

    @FXML
    private TableColumn<Partida, ImageView> colunaStatusPartida;

    private ObservableList<Partida> listaPartida = FXCollections.observableArrayList();

    public List<Partida> posicao(List<Jogo> listaJogo) {

        ArrayList<Partida> listaPartida = new ArrayList<>();

        Time t = new Time();

        for (int i = 0; i < listaJogo.size(); i++) {

            Partida p = new Partida();
            p.setId(listaJogo.get(i).getId());
            p.setDataPartida(listaJogo.get(i).getDataHoraPartida());
            p.setLocal(listaJogo.get(i).getLocalJogo());
            p.setCompreticao(listaJogo.get(i).getCompeticao());
            p.setReda(listaJogo.get(i).getLucroPartida());
            p.setStatus(listaJogo.get(i).isConcluida());
            p.setStCouF(listaJogo.get(i).isStCouF());
            p.setSt();
            p.setX("  X");

            if (listaJogo.get(i).isStCouF()) {
                
                p.setTimeCasa(ControladorLogin.time.getNome());
                p.setTimeFora(listaJogo.get(i).getAdversario());
                
            } else {
                
                p.setTimeCasa(listaJogo.get(i).getAdversario());
                p.setTimeFora(ControladorLogin.time.getNome());
                
            }
            
            listaPartida.add(p);
            
        }

        return listaPartida;

    }

    public void tabelaCalendario() {

        listaPartida.clear();
        listaPartida.addAll(posicao(jogoDAO.readJogo()));
        tabelaCalendario.setItems(listaPartida);

    }

    @FXML
    private void adicionarPartida() {

        try {
            Parent adicionarPartida = FXMLLoader.load(getClass().getResource("/visao/CalendarioAdicionarPartida.fxml"));
            ControladorPrincipal.controlador.borderPrincipal.setCenter(adicionarPartida);
            ControladorPrincipal.controlador.labelPrincipal.setText("ADICIONAR PARTIDA");
        } catch (IOException ex) {
            Logger.getLogger(ControladorCalendario.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @FXML
    private void cancelarPartida() {

        Partida p = new Partida();

        p = tabelaCalendario.getSelectionModel().getSelectedItem();

        if (tabelaCalendario.getSelectionModel().isEmpty()) {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText("Partida não escolhida");
            alert.setContentText("Escolha uma partida para cancelar");
            alert.showAndWait();
            
        } else {
            
            if (!p.isStatus()) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmação");
                alert.setHeaderText("Confirmar cancelamento de partida");
                alert.setContentText("Tem certeza que deseja cancelar partida?");
                Optional<ButtonType> result = alert.showAndWait();
                if (result.get() == ButtonType.OK) {
                    jogoDAO.deleteFromJogo(tabelaCalendario.getSelectionModel().getSelectedItem());
                    int indice = tabelaCalendario.getSelectionModel().getSelectedIndex();
                    tabelaCalendario.getItems().remove(indice);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atenção");
                alert.setHeaderText("Jogo escolhido já foi concluido então não pode ser cancelado");
                alert.setContentText("Escolha um jogo que ainda não foi concluido para poder cancelar");
                alert.showAndWait();
            }
            
        }

    }

    @FXML
    private void concluirPartida() {

        Partida p = new Partida();

        p = tabelaCalendario.getSelectionModel().getSelectedItem();

        if (tabelaCalendario.getSelectionModel().isEmpty()) {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText("Jogo não escolhido");
            alert.setContentText("Escolha um jogo para concluir");
            alert.showAndWait();
            
        } else {
            
            boolean x = p.isStatus();
            
            if (x == false) {
                try {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/visao/CalendarioConcluirPartida.fxml"));
                    Parent concluirPartida = loader.load();
                    ControladorCalendarioConcluirPartida controller = loader.<ControladorCalendarioConcluirPartida>getController();
                    controller.setPartidaID(p.getId());
                    ControladorPrincipal.controlador.borderPrincipal.setCenter(concluirPartida);
                    ControladorPrincipal.controlador.labelPrincipal.setText("CONCLUIR PARTIDA");
                } catch (IOException ex) {
                    Logger.getLogger(ControladorCalendario.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Atenção");
                alert.setHeaderText("Jogo escolhido já foi concluido");
                alert.setContentText("Escolha um jogo que ainda não foi concluido");
                alert.showAndWait();
            }
            
        }

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colunaDataHorario.setCellValueFactory(new PropertyValueFactory<Partida, String>("dataPartida"));
        
        colunaLocalJogo.setCellValueFactory(new PropertyValueFactory<Partida, String>("local"));
        
        colunaCompeticao.setCellValueFactory(new PropertyValueFactory<Partida, String>("compreticao"));
        
        colunaRendaPartida.setCellValueFactory(new PropertyValueFactory<Partida, Double>("reda"));
        
        colunaX.setCellValueFactory(new PropertyValueFactory<Partida, String>("x"));
        
        coluaTimeFora.setCellValueFactory(new PropertyValueFactory<Partida, String>("timeFora"));
        
        colunaTimeCasa.setCellValueFactory(new PropertyValueFactory<Partida, String>("timeCasa"));
        
        colunaStatusPartida.setCellValueFactory(new PropertyValueFactory<Partida, ImageView>("st"));
        
        tabelaCalendario();
        
    }
    
}
