package vue;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class GrillePanel extends JPanel {
    // Puissance 4 a 6 lignes
    private final int lignes = 6;
    // 7 colonnes
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
                button.setActionCommand(Integer.toString(j));
                button.addActionListener(actionListener);
                // Ajout du bouton à la grille des boutons
                boutons[i][j] = button;
                // Ajout du bouton au panel
                add(button);
            }
        }

        // Appel du controleur pour mettre à jour l'affichage de la grille
        public void miseAJourGrille;char[][] etatGrille; {
            for (int i = 0; i < lignes; i++) {
                for (int j = 0; j < colonnes; j++) {
                    if (etatGrille[i][j] == 'X') {
                        boutons[i][j].setText("X");
                    } else if (etatGrille[i][j] == 'O') {
                        boutons[i][j].setText("O");
                    } else {
                        boutons[i][j].setText("");
                    }
                }
            }
        }
    }
}
