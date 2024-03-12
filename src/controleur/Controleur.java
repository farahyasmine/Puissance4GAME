package controleur;

import model.Jeu;
import vue.VueJeu;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
    private Jeu jeu;
    private VueJeu vueJeu;

    public Controleur(Jeu jeu, VueJeu vueJeu) {
        this.jeu = jeu;
        this.vueJeu = vueJeu;
        // Configure la vue pour utiliser ce contrôleur comme ActionListener pour ses boutons
        this.vueJeu.setBoutonListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Extrait le numéro de colonne à partir de la commande d'action
        String cmd = e.getActionCommand();
        if (cmd.startsWith("COLONNE_")) {
            int colonne = Integer.parseInt(cmd.substring(8));
            if (jeu.jouer(colonne)) {
                mettreAJourVue();
                if (jeu.verifierVictoire()) {
                    vueJeu.afficherMessage("Le joueur " + jeu.getJoueurActuel() + " gagne !");
                    vueJeu.desactiverChoix(); // Empêche d'autres mouvements après la victoire
                } else if (jeu.estPlein()) {
                    vueJeu.afficherMessage("Match nul !");
                    vueJeu.desactiverChoix(); // Empêche d'autres mouvements après un match nul
                }
                jeu.changerJoueur(); // Passe au prochain joueur
            } else {
                vueJeu.afficherMessage("Mouvement invalide. Veuillez réessayer.");
            }
        }
    }

    private void mettreAJourVue() {
        // Mise à jour de la grille dans la vue basée sur le modèle actuel
        int[][] grille = jeu.getGrille();
        for (int i = 0; i < grille.length; i++) {
            for (int j = 0; j < grille[i].length; j++) {
                if (grille[i][j] == 1) {
                    vueJeu.afficherJeton(i, j, Color.RED);
                } else if (grille[i][j] == 2) {
                    vueJeu.afficherJeton(i, j, Color.YELLOW);
                }
            }
        }
    }

    public void demarrerNouvellePartie() {
        jeu.reinitialiserJeu();
        vueJeu.reinitialiserGrille();
        vueJeu.reactiverChoix();
        mettreAJourVue();
    }
}