package vue;


import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.awt.Color;

public class VueJeu extends JFrame {
    private final int COLONNES = 7;
    private final int LIGNES = 6;
    private JButton[] boutonsChoix;
    private JLabel[][] grille;

    public VueJeu() {
        initUI();
    }

    private void initUI() {
        setTitle("Puissance 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel panelGrille = new JPanel(new GridLayout(LIGNES, COLONNES));
        grille = new JLabel[LIGNES][COLONNES];

        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                grille[i][j] = new JLabel();
                grille[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                grille[i][j].setBorder(BorderFactory.createLineBorder(Color.BLACK));
                panelGrille.add(grille[i][j]);
            }
        }

        JPanel panelChoix = new JPanel(new GridLayout(1, COLONNES));
        boutonsChoix = new JButton[COLONNES];
        for (int i = 0; i < COLONNES; i++) {
            boutonsChoix[i] = new JButton(Integer.toString(i + 1));
            panelChoix.add(boutonsChoix[i]);
        }

        add(panelGrille, BorderLayout.CENTER);
        add(panelChoix, BorderLayout.SOUTH);

        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void setBoutonListener(ActionListener listener) {
        for (JButton bouton : boutonsChoix) {
            bouton.addActionListener(listener);
            bouton.setActionCommand("COLONNE_" + bouton.getText());
        }
    }

    public void afficherJeton(int ligne, int colonne, Color couleur) {
        SwingUtilities.invokeLater(() -> {
            grille[ligne][colonne].setOpaque(true);
            grille[ligne][colonne].setBackground(couleur);
        });
    }

    public void afficherMessage(String message) {
        SwingUtilities.invokeLater(() -> JOptionPane.showMessageDialog(this, message));
    }

    public void reinitialiserGrille() {
        SwingUtilities.invokeLater(() -> {
            for (JLabel[] row : grille) {
                for (JLabel cell : row) {
                    cell.setOpaque(false);
                    cell.setBackground(getContentPane().getBackground());
                }
            }
        });
    }

    public void desactiverChoix() {
        SwingUtilities.invokeLater(() -> {
            for (JButton bouton : boutonsChoix) {
                bouton.setEnabled(false);
            }
        });
    }

    public void reactiverChoix() {
        SwingUtilities.invokeLater(() -> {
            for (JButton bouton : boutonsChoix) {
                bouton.setEnabled(true);
            }
        });
    }
}
