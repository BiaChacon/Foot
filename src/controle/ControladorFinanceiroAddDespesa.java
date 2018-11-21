package controle;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import modelo.Despesa;
import persistencia.DespesaDAO;

public class ControladorFinanceiroAddDespesa {
    
    DespesaDAO despesaDAO = new DespesaDAO();
    
    @FXML
    private JFXTextField textNomeD;
    
    @FXML
    private JFXTextField textValorD;
    
    @FXML
    private JFXButton btAddDespesa;
    @FXML
    private JFXButton btCancelar;

    @FXML
    private void addDespesa() {
               
        double valorD = Double.parseDouble(textValorD.getText());
        
        Despesa d = new Despesa(textNomeD.getText(), valorD);

        despesaDAO.insertIntoDespesa(d);

        ControladorPrincipal.controlador.financeiro(); 
    }

    @FXML
    private void cancelarAD() {
        ControladorPrincipal.controlador.financeiro();
    }
}
