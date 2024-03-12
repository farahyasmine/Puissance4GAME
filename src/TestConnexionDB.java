import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestConnexionDB {
    public static void main(String[] args) {
        // Remplacez ces valeurs par celles de votre base de données
        String url = "jdbc:mysql://localhost:8889/puissance4";
        String user = "root";
        String password = "root";

        try {
            // Tentative de connexion
            Connection conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connexion à la base de données réussie !");
        } catch (SQLException e) {
            System.out.println("Échec de la connexion à la base de données.");
            e.printStackTrace();
        }
    }
}
