package persistencia;

import controle.ControladorLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Financeiro;

public class FinanceiroDAO {

    private ConnectionDatabase c = new ConnectionDatabase();

    private final String INSERT = "INSERT INTO FINANCEIRO(dataBalanco, patrocinios, despesas, lucroPartidas, salarios, total, ID_TEAM) VALUES (?, ?, ?, ?, ?, ?, ?);";

    private final String DELETE = "DELETE FROM FINANCEIRO WHERE id = ?;";

    private final String LISTFINANCEIRO = "SELECT * FROM FINANCEIRO";

    public void insertIntoFinanceiro(Financeiro f) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(INSERT);
            pst.setDate(1, f.getDataBalanco());
            pst.setDouble(2, f.getPatrocinios());
            pst.setDouble(3, f.getDespesas());
            pst.setDouble(4, f.getLucroPartidas());
            pst.setDouble(5, f.getSalarios());
            pst.setDouble(6, f.getTotal());
            pst.setInt(7, f.getTime());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro" + ex);
        }
        c.dbConnectionClose();

    }

    public void deleteFromFinanceiro(Financeiro f) {
        try {
            c.dbConnection();
            PreparedStatement pst = c.getConnection().prepareStatement(DELETE);
            pst.setInt(1, f.getId());
            pst.execute();
            System.out.println(DELETE);

            c.dbConnectionClose();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Financeiro> readFinanceiro() {
        ArrayList<Financeiro> listaFinanceiro = new ArrayList<>();
        try {
            c.dbConnection();
            PreparedStatement ps;
            ps = c.getConnection().prepareStatement(LISTFINANCEIRO);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                if (rs.getInt("ID_TEAM") == ControladorLogin.idTime) {
                    Financeiro f = new Financeiro(
                            rs.getInt("id"),
                            rs.getDate("dataBalanco"),
                            rs.getDouble("patrocinios"),
                            rs.getDouble("despesas"),
                            rs.getDouble("lucroPartidas"),
                            rs.getDouble("salarios"),
                            rs.getDouble("total"),
                            rs.getInt("ID_TEAM")
                    );
                    listaFinanceiro.add(f);
                }

            }
            c.dbConnectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaFinanceiro;
    }

}
