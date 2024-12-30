package Projet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;

public class CreateDB {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/";
        String user = "root";
        String password = "";

        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement()) {

            // Create the database if it doesn't exist
            stmt.execute("CREATE DATABASE IF NOT EXISTS PROG_BD");
            stmt.execute("USE PROG_BD");

            // Drop the table if it exists and create it with the required structure
            stmt.execute("DROP TABLE IF EXISTS programmeur");
            stmt.execute("""
                CREATE TABLE programmeur(
                    ID INT AUTO_INCREMENT PRIMARY KEY,
                    NOM VARCHAR(50) NOT NULL,
                    PRENOM VARCHAR(50) NOT NULL,
                    ADRESSE VARCHAR(100),
                    PSEUDO VARCHAR(50),
                    HOBBY VARCHAR(50),
                    RESPONSABLE VARCHAR(50),
                    ANNAISSANCE INT NOT NULL,
                    SALAIRE DOUBLE NOT NULL,
                    PRIME DOUBLE NOT NULL
                )
            """);

            // Insert sample data
            stmt.execute("""
                INSERT INTO programmeur (NOM, PRENOM, ADRESSE, PSEUDO, HOBBY, RESPONSABLE, ANNAISSANCE, SALAIRE, PRIME) VALUES
                ('Stroustrup', 'Bjarne', '294 rue C++', 'c++1', 'Voyages', 'Karim Lahlou', 1950, 2466.0, 80.0),
                ('Turing', 'Alan', 'Enigma Road', 'tur01', 'Mathematics', 'John von Neumann', 1912, 3000.0, 100.0),
                ('Lovelace', 'Ada', 'Computing Ave', 'adaL', 'Poetry', 'Charles Babbage', 1815, 2800.0, 90.0),
                ('Simpson', 'Homer', '742 Evergreen Terrace', 'homerdev', 'Bowling', 'Mr. Burns', 1989, 276.0, 12.0),
                ('Lagaffe', 'Gaston', 'Rue des farces', 'gastondev', 'Comics', 'Franquin', 1964, 278.0, 14.0)
            """);

            // Query and display the data
            ResultSet rs = stmt.executeQuery("SELECT * FROM programmeur");
            while (rs.next()) {
                System.out.println(
                        "ID: " + rs.getInt("ID") +
                                ", Nom: " + rs.getString("NOM") +
                                ", Prénom: " + rs.getString("PRENOM") +
                                ", Adresse: " + rs.getString("ADRESSE") +
                                ", Pseudo: " + rs.getString("PSEUDO") +
                                ", Hobby: " + rs.getString("HOBBY") +
                                ", Responsable: " + rs.getString("RESPONSABLE") +
                                ", Année de naissance: " + rs.getInt("ANNAISSANCE") +
                                ", Salaire: " + rs.getDouble("SALAIRE") +
                                ", Prime: " + rs.getDouble("PRIME")
                );
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
