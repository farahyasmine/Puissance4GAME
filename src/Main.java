

import model.Jeu;
import vue.VueJeu;
import controleur.Controleur;
import javax.swing.SwingUtilities;

public class Main {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            Jeu jeu = new Jeu(); // Crée l'instance du modèle
            VueJeu vueJeu = new VueJeu(); // Crée l'instance de la vue
            Controleur controleur = new Controleur(jeu, vueJeu); // Crée l'instance du contrôleur et le lie au modèle et à la vue

            vueJeu.setBoutonListener(controleur); // Configure la vue pour utiliser le contrôleur comme ActionListener pour ses boutons
        });
    }
}
