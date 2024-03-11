package vue;

import javax.swing.*;
import java.awt.event.ActionListener;

public class VuePrincipale extends JFrame {
    private GrillePanel grillePanel;

    public VuePrincipale(ActionListener actionListenerGrille, ActionListener actionListenerNouvellePartie) {
        super("Puissance 4");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        initUI(actionListenerGrille, actionListenerNouvellePartie);

        // Taille du jeu et de la barre de menu
        setSize(600, 400);

        // Centrage de la fenêtre sur l'écran
        setLocationRelativeTo(null);
    }

    private void initUI(ActionListener actionListenerGrille, ActionListener actionListenerNouvellePartie) {
        grillePanel = new GrillePanel(actionListenerGrille);

        // Ajout de grillePanel
        this.add(grillePanel);

        // Configuration de la barre de menu
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Jeu");
        JMenuItem nouvellePartie = new JMenuItem("Nouvelle Partie");
        nouvellePartie.addActionListener(actionListenerNouvellePartie);
        menu.add(nouvellePartie);
        menuBar.add(menu);
        this.setJMenuBar(menuBar);
    }
} 
