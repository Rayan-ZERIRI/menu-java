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
    public List<Programmeur> getTousProgrammeurs() {
        String query = "SELECT * FROM Programmeur";
        List<Programmeur> programmeurs = new ArrayList<>();
        try (Connection conn = connect(); Statement stmt = conn.createStatement(); ResultSet rs = stmt.executeQuery(query)) {
            while (rs.next()) {
                Programmeur programmeur = new Programmeur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("anNaissance"), rs.getDouble("salaire"), rs.getDouble("prime"));
                programmeurs.add(programmeur);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return programmeurs.toArray(new Programmeur[0]);
    }

    @Override
    public Programmeur getProgrammeurInput(int id) {
        String query = "SELECT * FROM Programmeur WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, id);
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    return new Programmeur(rs.getInt("id"), rs.getString("nom"), rs.getString("prenom"), rs.getInt("anNaissance"), rs.getDouble("salaire"), rs.getDouble("prime"));
                } else {
                    System.out.println("ID non trouvé.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean supprimerProgrammeurInput(int id) {
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
    public boolean ajouterProgrammeurInput(Programmeur p) {
        String query = "INSERT INTO Programmeur (id, nom, prenom, adresse, pseudo, hobby, responsable, anNaissance, salaire, prime) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setInt(1, p.getId());
            pstmt.setString(2, p.getNom());
            pstmt.setString(3, p.getPrenom());
            pstmt.setString(4, p.getAdresse());
            pstmt.setString(5, p.getPseudo());
            pstmt.setString(6, p.getHobby());
            pstmt.setString(7, p.getResponsable());
            pstmt.setInt(8, p.getAnNaissance());
            pstmt.setDouble(9, p.getSalaire());
            pstmt.setDouble(10, p.getPrime());
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Programmeur ajouté avec succès.");
                return true;
            } else {
                System.out.println("Erreur lors de l'ajout du programmeur.");
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean modifierSalaireInput(int id, double salaire) {
        String query = "UPDATE Programmeur SET salaire = ? WHERE id = ?";
        try (Connection conn = connect(); PreparedStatement pstmt = conn.prepareStatement(query)) {
            pstmt.setDouble(1, salaire);
            pstmt.setInt(2, id);
            int rowsAffected = pstmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Salaire modifié avec succès.");
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
