package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GrillePanel extends JPanel {
    // Puissance 4 a 6 lignes
    private final int lignes = 6;

    // et 7 colonnes
    private final int colonnes = 7;
    // La grille de boutons
    private JButton[][] boutons;

    public GrillePanel(ActionListener actionListener) {
        setLayout(new GridLayout(lignes, colonnes));
        boutons = new JButton[lignes][colonnes];
        initGrille(actionListener);
    }

    private void initGrille(ActionListener actionListener) {
        for (int i = 0; i < lignes; i++) {
            for (int j = 0; j < colonnes; j++) {
                JButton button = new JButton();
                button.addActionListener(actionListener);
                boutons[i][j] = button;
                add(button);
            }
        }
    }

    // Méthode pour obtenir le bouton à une certaine position dans la grille
    public JButton getBouton(int ligne, int colonne) {
        return boutons[ligne][colonne];
    }

    // Méthode pour remplir une case avec une couleur spécifiée
    public void remplirCase(int ligne, int colonne, Color couleur) {
        boutons[ligne][colonne].setBackground(couleur);
        boutons[ligne][colonne].setOpaque(true);
        boutons[ligne][colonne].setBorderPainted(false);
    }

    // Méthode pour effacer le contenu d'une case
    public void effacerCase(int ligne, int colonne) {
        boutons[ligne][colonne].setBackground(null);
        boutons[ligne][colonne].setOpaque(false);
        boutons[ligne][colonne].setBorderPainted(true);
    }
}
