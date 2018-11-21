package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Time;

public class TimeDAO {
    
   private ConnectionDatabase c = new ConnectionDatabase();

    private final String INSERT = "INSERT INTO TIME(usuario, senha, nome, dataFundacao, patrimonio) VALUES (?, ?, ?, ?, ?);";

    private final String UPDATE = "UPDATE TIME  SET usuario = ?, senha = ?, nome = ?, dataFundacao = ?, patrimonio = ? WHERE id = ?;";

    private final String DELETE = "DELETE FROM TIME WHERE id = ?;";

    private final String LISTTIME = "SELECT * FROM TIME";

    public void insertIntoTime(Time t) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(INSERT);
            pst.setString(1, t.getUsuario());
            pst.setString(2, t.getSenha());
            pst.setString(3, t.getNome());
            pst.setDate(4, t.getDataFundacao());
            pst.setDouble(5, t.getPatrimonio());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro"+ex);
        }
        c.dbConnectionClose();

    }

    public void UpdateIntoTime(Time t) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(UPDATE);
            pst.setString(1, t.getUsuario());
            pst.setString(2, t.getSenha());
            pst.setString(3, t.getNome());
            pst.setDate(4, t.getDataFundacao());
            pst.setDouble(5, t.getPatrimonio());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.dbConnectionClose();

    }

    public void deleteFromTime(Time t) {
        try {
            c.dbConnection();
            PreparedStatement pst = c.getConnection().prepareStatement(DELETE);
            pst.setInt(1, t.getId());
            pst.execute();
            c.dbConnectionClose();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Time> readTime() {
        ArrayList<Time> listaTime = new ArrayList<>();
        try {
            c.dbConnection();
            PreparedStatement ps;
            ps = c.getConnection().prepareStatement(LISTTIME);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Time t = new Time(
                        rs.getInt("id"),
                        rs.getString("usuario"),
                        rs.getString("senha"),
                        rs.getString("nome"),
                        rs.getDate("dataFundacao"),
                        rs.getDouble("patrimonio")
                );
                listaTime.add(t);
            }
            c.dbConnectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaTime;
    } 
}
