package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Patrocinio;

public class PatrocinioDAO {

    private ConnectionDatabase c = new ConnectionDatabase();

    private final String INSERT = "INSERT INTO PATROCINIO(nome, valor) VALUES (?, ?);";

    private final String DELETE = "DELETE FROM PATROCINIO WHERE id = ?;";

    private final String LISTPATROCINIO = "SELECT * FROM PATROCINIO";

    public void insertIntoPatrocinio(Patrocinio p) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(INSERT);
            pst.setString(1, p.getNome());
            pst.setDouble(2, p.getValor());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro" + ex);
        }
        c.dbConnectionClose();

    }

    public void deleteFromPatrocinio(Patrocinio p) {
        try {
            c.dbConnection();
            PreparedStatement pst = c.getConnection().prepareStatement(DELETE);
            System.out.println("o id é "+p.getId());
            pst.setInt(1, p.getId());
            pst.execute();
            System.out.println("tatata");
            
            c.dbConnectionClose();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Patrocinio> readPatrocinio() {
        ArrayList<Patrocinio> listaPatrocinio = new ArrayList<>();
        try {
            c.dbConnection();
            PreparedStatement ps;
            ps = c.getConnection().prepareStatement(LISTPATROCINIO);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Patrocinio p = new Patrocinio(
                        rs.getString("nome"),
                        rs.getDouble("valor"),
                        rs.getInt("id")
                );
                listaPatrocinio.add(p);
            }
            c.dbConnectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaPatrocinio;
    }
}
