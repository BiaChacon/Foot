package persistencia;

import controle.ControladorLogin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Jogo;
import modelo.Partida;

public class JogoDAO {

    private ConnectionDatabase c = new ConnectionDatabase();

    private final String INSERT = "INSERT INTO JOGO(dataHoraPartida, localJogo, adversario, competicao, status, stCouF, ID_TEAM) VALUES (?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATEJOGO = "UPDATE JOGO SET lucroPartida = ?, status = ? WHERE id = ?;";

    private final String DELETE = "DELETE FROM JOGO WHERE id = ?;";

    private final String LISTJOGO = "SELECT * FROM JOGO";

    public void insertIntoJogo(Jogo j) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(INSERT);
            pst.setString(1, j.getDataHoraPartida());
            pst.setString(2, j.getLocalJogo());
            pst.setString(3, j.getAdversario());
            pst.setString(4, j.getCompeticao());
            pst.setBoolean(5, j.isConcluida());
            pst.setBoolean(6, j.isStCouF());
            pst.setInt(7, j.getTime());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.dbConnectionClose();

    }

    public void updateLucroIntoJogo(Jogo j) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(UPDATEJOGO);
            pst.setDouble(1, j.getLucroPartida());
            pst.setBoolean(2, j.isConcluida());
            pst.setInt(3, j.getId());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.dbConnectionClose();

    }

    public void deleteFromJogo(Partida p) {
        try {
            c.dbConnection();
            PreparedStatement pst = c.getConnection().prepareStatement(DELETE);
            pst.setInt(1, p.getId());
            pst.execute();
            c.dbConnectionClose();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Jogo> readJogo() {
        ArrayList<Jogo> listaJogo = new ArrayList<>();
        try {
            c.dbConnection();
            PreparedStatement ps;
            ps = c.getConnection().prepareStatement(LISTJOGO);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                if (rs.getInt("ID_TEAM") == ControladorLogin.idTime) {
                    Jogo j = new Jogo(
                            rs.getInt("id"),
                            rs.getString("dataHoraPartida"),
                            rs.getString("localJogo"),
                            rs.getString("adversario"),
                            rs.getString("competicao"),
                            rs.getDouble("lucroPartida"),
                            rs.getBoolean("status"),
                            rs.getBoolean("stCouF"),
                            rs.getInt("ID_TEAM")
                    );
                    listaJogo.add(j);
                }

            }
            c.dbConnectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaJogo;
    }
}
