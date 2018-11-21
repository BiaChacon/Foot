package persistencia;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.Atleta;

public class AtletaDAO {

    private ConnectionDatabase c = new ConnectionDatabase();

    private final String INSERT = "INSERT INTO ATLETA(nome, cpf, dataNasc, telefone, email, endereco, salario) VALUES (?, ?, ?, ?, ?, ?, ?);";

    private final String UPDATE = "UPDATE ATLETA SET nome = ?, dataNasc = ?, telefone = ?, email = ?, endereco = ?, salario = ? WHERE cpf = ?;";

    private final String DELETE = "DELETE FROM ATLETA WHERE cpf = ?;";

    private final String LISTATLETA = "SELECT * FROM ATLETA";

    public void insertIntoAtleta(Atleta a) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(INSERT);
            pst.setString(1, a.getNome());
            pst.setString(2, a.getCpf());
            pst.setDate(3, a.getDataNasc());
            pst.setInt(4, a.getTelefone());
            pst.setString(5, a.getEmail());
            pst.setString(6, a.getEndereco());
            pst.setDouble(7, a.getSalario());
            pst.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
            System.out.println("erro"+ex);
        }
        c.dbConnectionClose();

    }

    public void UpdateIntoAtleta(Atleta a) {
        c.dbConnection();
        try {
            PreparedStatement pst = c.getConnection().prepareStatement(UPDATE);
            pst.setString(1, a.getNome());
            pst.setDate(2, a.getDataNasc());
            pst.setInt(3, a.getTelefone());
            pst.setString(4, a.getEmail());
            pst.setString(5, a.getEndereco());
            pst.setDouble(6, a.getSalario());
            pst.setString(7, a.getCpf());
            pst.executeUpdate();
            System.out.println("oi");
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        c.dbConnectionClose();

    }

    public void deleteFromAtleta(Atleta a) {
        try {
            c.dbConnection();
            PreparedStatement pst = c.getConnection().prepareStatement(DELETE);
            pst.setString(1, a.getCpf());
            pst.execute();
            c.dbConnectionClose();
        } catch (SQLException ex) {
            Logger.getLogger(ConnectionDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public List<Atleta> readAtleta() {
        ArrayList<Atleta> listaAtleta = new ArrayList<>();
        try {
            c.dbConnection();
            PreparedStatement ps;
            ps = c.getConnection().prepareStatement(LISTATLETA);

            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                Atleta a = new Atleta(
                        rs.getString("nome"),
                        rs.getString("cpf"),
                        rs.getDate("dataNasc"),
                        rs.getInt("telefone"),
                        rs.getString("email"),
                        rs.getString("endereco"),
                        rs.getDouble("salario")
                );
                listaAtleta.add(a);
            }
            c.dbConnectionClose();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return listaAtleta;
    }
}
