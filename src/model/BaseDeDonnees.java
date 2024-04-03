package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BaseDeDonnees {
    private final String url = "jdbc:mysql://localhost:3306/puissance4";
    private final String user = "root";
    private final String password = "";

    public BaseDeDonnees() {
        try {

            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    private Connection connecter() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }

    public void enregistrerPartie(String joueur1, String joueur2, String gagnant) {
        String sql = "INSERT INTO parties (joueur1_id, joueur2_id, gagnant_id) VALUES (?, ?, ?);";

        try (Connection conn = connecter();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {


            pstmt.setInt(1, Integer.parseInt(joueur1));
            pstmt.setInt(2, Integer.parseInt(joueur2));
            pstmt.setInt(3, gagnant != null ? Integer.parseInt(gagnant) : null);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void afficherParties() {
        String sql = "SELECT * FROM parties;";

        try (Connection conn = connecter();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                System.out.println("Partie " + rs.getInt("partie_id") + " : Joueur 1 - " + rs.getString("joueur1_id") +
                        ", Joueur 2 - " + rs.getString("joueur2_id") + ", Gagnant - " + rs.getString("gagnant_id"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
