import vue.VuePrincipale;
import java.awt.event.ActionListener;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        // Création d'un ActionListener pour gérer les clics sur les boutons de la grille
        ActionListener actionListenerGrille = e -> {
            System.out.println("Clic sur la colonne: " + e.getActionCommand());
            // Gestion des clics sur les boutons de la grille
        };

        // Création d'un ActionListener pour le menu "Nouvelle Partie"
        ActionListener actionListenerNouvellePartie = e -> {
            System.out.println("Nouvelle Partie démarrée");
            // Logique pour initialiser une nouvelle partie
        };

        // Utilisation de SwingUtilities.invokeLater pour garantir que l'UI soit bien créée dans le thread EDT
        SwingUtilities.invokeLater(() -> {
            VuePrincipale vuePrincipale = new VuePrincipale(actionListenerGrille, actionListenerNouvellePartie);
            vuePrincipale.setVisible(true);
        });
    }
}
