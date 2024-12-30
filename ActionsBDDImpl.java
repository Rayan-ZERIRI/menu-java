import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ActionsBDDImpl implements ActionsBDD {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/PROG_BD";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private Connection connect() throws SQLException {
        return DriverManager.getConnection(DB_URL, DB_USER, DB_PASSWORD);
    }

    @Override
    public void afficherProgrammeurs() {
        String query = "SELECT * FROM Programmeur";
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                System.out.println("ID: " + rs.getInt("id") +
                        ", Nom: " + rs.getString("nom") +
                        ", Prénom: " + rs.getString("prenom") +
                        ", Année de naissance: " + rs.getInt("anNaissance") +
                        ", Salaire: " + rs.getDouble("salaire") +
                        ", Prime: " + rs.getDouble("prime"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean supprimerProgrammeur(int id) {
        String query = "DELETE FROM Programmeur WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Programmeur supprimé avec succès.");
                return true;
            } else {
                System.out.println("ID non trouvé.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public void terminerProgramme() {
        System.out.println("Programme terminé.");
        System.exit(0);
    }
}
