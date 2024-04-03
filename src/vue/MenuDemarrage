package vue;

import javax.swing.*;
import java.awt.*;

public class MenuDemarrage extends JFrame {
    private JButton boutonJoueurVsJoueur = new JButton("Joueur vs Joueur");
    private JButton boutonJoueurVsIA = new JButton("Joueur vs IA");

    public MenuDemarrage() {
        setTitle("Choix du Mode");
        setSize(300, 200);
        setLayout(new FlowLayout());
        add(boutonJoueurVsJoueur);
        add(boutonJoueurVsIA);

        boutonJoueurVsJoueur.addActionListener(e -> {
            String nomJoueur1 = JOptionPane.showInputDialog("Nom Joueur 1 :");
            String nomJoueur2 = JOptionPane.showInputDialog("Nom Joueur 2 :");
            demarrerJeu(nomJoueur1, nomJoueur2);
        });

        boutonJoueurVsIA.addActionListener(e -> {
            String nomJoueur = JOptionPane.showInputDialog("Nom Joueur :");
            demarrerJeu(nomJoueur, "IA");
        });

        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void demarrerJeu(String nomJoueur1, String nomJoueur2) {
        // Fermez ce menu de démarrage
        this.dispose();

        // Ici, créez et affichez votre interface de jeu, par exemple :
        VueJeu vueJeu = new VueJeu(); // Assurez-vous que VueJeu peut être initialisé ainsi ou ajustez selon vos besoins
        vueJeu.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MenuDemarrage::new);
    }
}
