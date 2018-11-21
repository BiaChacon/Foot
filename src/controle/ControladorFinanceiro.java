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
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import modelo.Atleta;
import modelo.Despesa;
import modelo.Financeiro;
import modelo.Patrocinio;
import persistencia.AtletaDAO;
import persistencia.DespesaDAO;
import persistencia.FinanceiroDAO;
import persistencia.PatrocinioDAO;

public class ControladorFinanceiro implements Initializable {

    FinanceiroDAO financeiroDAO = new FinanceiroDAO();

    PatrocinioDAO patrocinioDAO = new PatrocinioDAO();

    DespesaDAO despesaDAO = new DespesaDAO();

    AtletaDAO atletaDAO = new AtletaDAO();

    @FXML
    private TabPane tabPaneFinanceiro;
    @FXML
    private TableView<Financeiro> tebelaTotal;
    @FXML
    private TableView<Patrocinio> tabPat;
    @FXML
    private TableColumn<Financeiro, Date> colunaData;
    @FXML
    private TableColumn<Financeiro, Double> colunaPatricios;
    @FXML
    private TableColumn<Financeiro, Double> colunaDespesas;
    @FXML
    private TableColumn<Financeiro, Double> colunaSalarios;
    @FXML
    private TableColumn<Financeiro, Double> colunaLucroPartidas;
    @FXML
    private TableColumn<Financeiro, Double> colunaTotal;
    @FXML
    private JFXButton btGerarTotal, btRemoverTotal;

    private ObservableList<Financeiro> listaFinanceiro = FXCollections.observableArrayList();

    public void tebelaTotal() {
        listaFinanceiro.clear();
        listaFinanceiro.addAll(financeiroDAO.readFinanceiro());
        tebelaTotal.setItems(listaFinanceiro);
    }

    @FXML
    private void gerarTotal() {
        try {
            Parent gerarTotal = FXMLLoader.load(getClass().getResource("/visao/FinanceiroGerarTotal.fxml"));
            ControladorPrincipal.controlador.borderPrincipal.setCenter(gerarTotal);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removerTotal() {
        if (tebelaTotal.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText("Balanço geral não escolhido");
            alert.setContentText("Escolha um balanço geral para remover");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Confirmar exclusão de balanço geral");
            alert.setContentText("Tem certeza que deseja excluir este balanço geral?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                System.out.println("tatata");
                financeiroDAO.deleteFromFinanceiro(tebelaTotal.getSelectionModel().getSelectedItem());
                int indice = tebelaTotal.getSelectionModel().getSelectedIndex();
                tebelaTotal.getItems().remove(indice);
            }
        }
    }

    //PATROCINIOS
    @FXML
    private Tab tabPatrocinio;
    @FXML
    private TableView<Patrocinio> tabelaPatrocinio;
    @FXML
    private TableColumn<Patrocinio, String> colunaPatrocino;
    @FXML
    private TableColumn<Patrocinio, Double> colunaValorP;
    @FXML
    private JFXButton btAdicionarP, btRemoverP;

    private ObservableList<Patrocinio> listaPatrocinio = FXCollections.observableArrayList();

    public void tabelaPatrocinio() {
        listaPatrocinio.clear();
        listaPatrocinio.addAll(patrocinioDAO.readPatrocinio());
        tabelaPatrocinio.setItems(listaPatrocinio);
    }

    @FXML
    private void adicionarPatrocinio() {
        try {
            Parent addPatrocinio = FXMLLoader.load(getClass().getResource("/visao/FinanceiroAddPatrocinio.fxml"));
            ControladorPrincipal.controlador.borderPrincipal.setCenter(addPatrocinio);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removerPatrocinio() {
        if (tabelaPatrocinio.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText("Patrocinador não escolhido");
            alert.setContentText("Escolha um patrocinador para remover");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Confirmar exclusão de patrocinador");
            alert.setContentText("Tem certeza que deseja excluir o patrocinador?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                patrocinioDAO.deleteFromPatrocinio(tabelaPatrocinio.getSelectionModel().getSelectedItem());
                int indice = tabelaPatrocinio.getSelectionModel().getSelectedIndex();
                tabelaPatrocinio.getItems().remove(indice);
            }
        }
    }

    //DESPESAS
    @FXML
    private Tab tabDespesa;
    @FXML
    private TableView<Despesa> tabelaDespesa;
    @FXML
    private TableColumn<Despesa, String> colunaDespesa;
    @FXML
    private TableColumn<Despesa, Double> colunaValorD;
    @FXML
    private JFXButton btAdicionarD, btremoverD;

    private ObservableList<Despesa> listaDespesa = FXCollections.observableArrayList();

    public void tabelaDespesa() {
        listaDespesa.clear();
        listaDespesa.addAll(despesaDAO.readDespesa());
        tabelaDespesa.setItems(listaDespesa);
    }

    @FXML
    private void adicionarDespesa() {
        try {
            Parent addDespesa = FXMLLoader.load(getClass().getResource("/visao/FinanceiroAddDespesa.fxml"));
            ControladorPrincipal.controlador.borderPrincipal.setCenter(addDespesa);
        } catch (IOException ex) {
            Logger.getLogger(ControladorAtleta.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void removerDespesa() {
        if (tabelaDespesa.getSelectionModel().isEmpty()) {
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Atenção");
            alert.setHeaderText("Despesa não escolhida");
            alert.setContentText("Escolha uma despesa para remover");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmação");
            alert.setHeaderText("Confirmar exclusão de despesa");
            alert.setContentText("Tem certeza que deseja excluir o despesa?");

            Optional<ButtonType> result = alert.showAndWait();
            if (result.get() == ButtonType.OK) {
                despesaDAO.deleteFromDespesa(tabelaDespesa.getSelectionModel().getSelectedItem());
                int indice = tabelaDespesa.getSelectionModel().getSelectedIndex();
                tabelaDespesa.getItems().remove(indice);
            }
        }
    }

    //SALARIOS
    @FXML
    private TableView<Atleta> tabelaSalario;
    @FXML
    private TableColumn<Atleta, String> colunaAtleta;
    @FXML
    private TableColumn<Atleta, Double> colunaSalario;

    private ObservableList<Atleta> listaAtleta = FXCollections.observableArrayList();

    public void tabelaSalario() {
        listaAtleta.clear();
        listaAtleta.addAll(atletaDAO.readAtleta());
        tabelaSalario.setItems(listaAtleta);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        //TABELA TOTAL
        colunaData.setCellValueFactory(new PropertyValueFactory<Financeiro, Date>("dataBalanco"));
        colunaPatricios.setCellValueFactory(new PropertyValueFactory<Financeiro, Double>("patrocinios"));
        colunaDespesas.setCellValueFactory(new PropertyValueFactory<Financeiro, Double>("despesas"));
        colunaLucroPartidas.setCellValueFactory(new PropertyValueFactory<Financeiro, Double>("lucroPartidas"));
        colunaSalarios.setCellValueFactory(new PropertyValueFactory<Financeiro, Double>("salarios"));
        colunaTotal.setCellValueFactory(new PropertyValueFactory<Financeiro, Double>("total"));
        tebelaTotal();

        //TABELA PATROCINIO
        colunaPatrocino.setCellValueFactory(new PropertyValueFactory<Patrocinio, String>("nome"));
        colunaValorP.setCellValueFactory(new PropertyValueFactory<Patrocinio, Double>("valor"));
        tabelaPatrocinio();

        //TABELA DESPESAS
        colunaDespesa.setCellValueFactory(new PropertyValueFactory<Despesa, String>("nome"));
        colunaValorD.setCellValueFactory(new PropertyValueFactory<Despesa, Double>("valor"));
        tabelaDespesa();

        //TABELA SALARIOS
        colunaAtleta.setCellValueFactory(new PropertyValueFactory<Atleta, String>("nome"));
        colunaSalario.setCellValueFactory(new PropertyValueFactory<Atleta, Double>("salario"));
        tabelaSalario();
    }
}
