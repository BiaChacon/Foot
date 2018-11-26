package persistencia;

import controle.ControladorLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Despesa;

public class DespesaDAO {

    private ConnectionDatabase c = new ConnectionDatabase();

    private final String INSERT = "INSERT INTO DESPESA(nome, valor, ID_TEAM) VALUES (?, ?, ?);";

    private final String DELETE = "DELETE FROM DESPESA WHERE id = ?;";

    private final String LISTDESPESA = "SELECT * FROM DESPESA";

    public void insertIntoDespesa(Despesa d) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(INSERT);
            pst.setString(1, d.getNome());
            pst.setDouble(2, d.getValor());
            pst.setInt(3, d.getFinanceiroTime());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro" + ex);
        }
        c.dbConnectionClose();

    }

    public void deleteFromDespesa(Despesa d) {
        try {
            c.dbConnection();
            PreparedStatement pst = c.getConnection().prepareStatement(DELETE);
            pst.setInt(1, d.getId());
            pst.execute();
            c.dbConnectionClose();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Despesa> readDespesa() {
        ArrayList<Despesa> listaDespesa = new ArrayList<>();
        try {
            c.dbConnection();
            PreparedStatement ps;
            ps = c.getConnection().prepareStatement(LISTDESPESA);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if(rs.getInt("ID_TEAM") == ControladorLogin.idTime){
                    Despesa d = new Despesa(
                            rs.getString("nome"),
                            rs.getDouble("valor"),
                            rs.getInt("id"),
                            rs.getInt("ID_TEAM")
                    );
                    listaDespesa.add(d);
                }
            }
            c.dbConnectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaDespesa;
    }
}
