package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javafx.fxml.FXML;
import modelo.Atleta;
import modelo.Despesa;
import modelo.Financeiro;
import modelo.Jogo;
import modelo.Patrocinio;
import persistencia.AtletaDAO;
import persistencia.DespesaDAO;
import persistencia.FinanceiroDAO;
import persistencia.JogoDAO;
import persistencia.PatrocinioDAO;
import persistencia.TimeDAO;

public class ControladorFinanceiroGerarTotal {

    FinanceiroDAO financeiroDAO = new FinanceiroDAO();

    JogoDAO jogoDAO = new JogoDAO();

    AtletaDAO atletaDAO = new AtletaDAO();

    PatrocinioDAO patrocinioDAO = new PatrocinioDAO();

    DespesaDAO despesaDAO = new DespesaDAO();

    TimeDAO timeDAO = new TimeDAO();

    @FXML
    private JFXDatePicker dateBalanco;

    @FXML
    private JFXButton btGerar;

    @FXML
    private JFXButton btCancelar;

    @FXML
    private void gerarBalancoTotal() {

        int idTime = ControladorLogin.idTime;

        Date db = Date.from(dateBalanco.getValue().atStartOfDay(ZoneId.systemDefault()).toInstant());
        java.sql.Date dbSql = new java.sql.Date(db.getTime());

        Financeiro f = new Financeiro();

        TimeDAO timeDAO = new TimeDAO();

        f.setDataBalanco(dbSql);
        f.setPatrocinios((ArrayList<Patrocinio>) patrocinioDAO.readPatrocinio());
        f.setDespesas((ArrayList<Despesa>) despesaDAO.readDespesa());
        f.setLucroPartidas((ArrayList<Jogo>) jogoDAO.readJogo());
        f.setSalarios((ArrayList<Atleta>) atletaDAO.readAtleta());
        f.setTotal(0, f.getPatrocinios(), f.getLucroPartidas(), f.getDespesas(), f.getSalarios());
        f.setTime(idTime);

        double patrimonio = ControladorLogin.time.getPatrimonio() + f.getTotal();
        ControladorLogin.time.setPatrimonio(patrimonio);
        timeDAO.UpdateIntoTime(ControladorLogin.time);

        financeiroDAO.insertIntoFinanceiro(f);

        ControladorPrincipal.controlador.financeiro();

    }

    @FXML
    private void cancelarGB() {

        ControladorPrincipal.controlador.financeiro();

    }

}
