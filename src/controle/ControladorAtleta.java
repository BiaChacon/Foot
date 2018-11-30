package controle;

import com.jfoenix.controls.JFXButton;
import java.io.IOException;
import java.net.URL;
import java.sql.Date;
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
import javafx.scene.control.ButtonType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Atleta;
import persistencia.AtletaDAO;

public class ControladorAtleta implements Initializable {

    static ControladorAtleta c;

    Atleta a;

    AtletaDAO atletaDAO = new AtletaDAO();

    @FXML
    private JFXButton btCadastrar, btAtualizar, btRemover;

    @FXML
    private TableView<Atleta> tabelaAtleta;

    @FXML
    private TableColumn<Atleta, String> colunaNomeAtleta;

    @FXML
    private TableColumn<Atleta, Date> colunaDataNascAtleta;

    @FXML
    private TableColumn<Atleta, Double> colunaSalarioAtleta;

    @FXML
    private TableColumn<Atleta, String> colunaCPFAtleta;

    @FXML
    private TableColumn<Atleta, Integer> colunaTelefoneAtleta;

    @FXML
    private TableColumn<Atleta, String> colunaEnderecoAtleta;

    @FXML
    private TableColumn<Atleta, String> colunaEmailAtleta;

    private ObservableList<Atleta> listaAtleta = FXCollections.observableArrayList();

    public void tabelaAtleta() {

        listaAtleta.clear();
        listaAtleta.addAll(atletaDAO.readAtleta());
        tabelaAtleta.setItems(listaAtleta);
        
    }

    @FXML
    private void cadastrarAtleta() {
        
        try {
            Parent cadastrarAtleta = FXMLLoader.load(getClass().getResource("/visao/AtletaCadastrar.fxml"));
            ControladorPrincipal.controlador.borderPrincipal.setCenter(cadastrarAtleta);
            ControladorPrincipal.controlador.labelPrincipal.setText("CADASTRAR ATLETA");
        } catch (IOException ex) {
            Logger.getLogger(ControladorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    @FXML
    private void removerAtleta() {
        
        if (tabelaAtleta.getSelectionModel().isEmpty()) {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText("Atleta não escolhido");
            alert.setContentText("Escolha um atleta para remover");
            alert.showAndWait();
            
        } else {
            
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Confirmar exclusão de atleta");
            alert.setContentText("Tem certeza que deseja excluir o atleta?");
            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                atletaDAO.deleteFromAtleta(tabelaAtleta.getSelectionModel().getSelectedItem());
                int indice = tabelaAtleta.getSelectionModel().getSelectedIndex();
                tabelaAtleta.getItems().remove(indice);
            }
            
        }
        
    }

    @FXML
    private void atualizarAtleta() {
        
        a = tabelaAtleta.getSelectionModel().getSelectedItem();
        
        if (tabelaAtleta.getSelectionModel().isEmpty()) {
            
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText("Atleta não escolhido");
            alert.setContentText("Escolha um atleta para atualizar");
            alert.showAndWait();
            
        } else {
            
            try {
                Parent atualizarAtleta = FXMLLoader.load(getClass().getResource("/visao/AtletaAtualizar.fxml"));

                ControladorPrincipal.controlador.borderPrincipal.setCenter(atualizarAtleta);
                ControladorPrincipal.controlador.labelPrincipal.setText("ATUALIZAR ATLETA");

            } catch (IOException ex) {
                Logger.getLogger(ControladorAtleta.class.getName()).log(Level.SEVERE, null, ex);
            }
            
        }
        
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        colunaNomeAtleta.setCellValueFactory(new PropertyValueFactory<Atleta, String>("nome"));

        colunaCPFAtleta.setCellValueFactory(new PropertyValueFactory<Atleta, String>("cpf"));

        colunaDataNascAtleta.setCellValueFactory(new PropertyValueFactory<Atleta, Date>("dataNasc"));

        colunaTelefoneAtleta.setCellValueFactory(new PropertyValueFactory<Atleta, Integer>("telefone"));

        colunaEmailAtleta.setCellValueFactory(new PropertyValueFactory<Atleta, String>("email"));

        colunaEnderecoAtleta.setCellValueFactory(new PropertyValueFactory<Atleta, String>("endereco"));

        colunaSalarioAtleta.setCellValueFactory(new PropertyValueFactory<Atleta, Double>("salario"));

        tabelaAtleta();
        
        c = this;
        
    }

}
