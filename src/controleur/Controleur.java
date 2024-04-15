package controleur;

import model.IA;
import model.Jeu;
import vue.VueJeu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Controleur implements ActionListener {
    private final Jeu jeu;
    private final VueJeu vueJeu;
    private final IA ia;
    private boolean jouerContreIA;

    public Controleur(Jeu jeu, VueJeu vueJeu) {
        this.jeu = jeu;
        this.vueJeu = vueJeu;
        this.ia = new IA(jeu);
        this.vueJeu.setBoutonListener(this);
      
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String cmd = e.getActionCommand();

        if (cmd.equals("MODE_IA")) {
            jouerContreIA = true;
            demarrerNouvellePartie();
        } else if (cmd.equals("MODE_JVJ")) {
            jouerContreIA = false;
            demarrerNouvellePartie();
        } else if (cmd.startsWith("COLONNE_")) {
            int colonne = Integer.parseInt(cmd.substring(8));
            gererJeu(colonne);
        }
        if (jouerContreIA && jeu.getJoueurActuel() == 2 && !jeu.verifierVictoire() && !jeu.estPlein()) {
            jouerCoupIA(); // L'IA joue après le joueur humain si nécessaire
        }
    }


    private void demarrerNouvellePartie() {
        jeu.reinitialiserJeu();
        vueJeu.reinitialiserGrille();
        vueJeu.reactiverChoix();
        mettreAJourVue();
    }

    private void gererJeu(int colonne) {
        if (jeu.jouer(colonne)) {
            mettreAJourVue();
            verifierEtatJeu();
        } else {
            vueJeu.afficherMessage("Mouvement invalide. Veuillez réessayer.");
        }
    }

    private void jouerCoupIA() {
        int colonne = ia.jouerCoup();
        if (jeu.jouer(colonne)) { // Assurez-vous que l'IA a joué avant de mettre à jour la vue
            mettreAJourVue();
            verifierEtatJeu();
        }
    }

    private void verifierEtatJeu() {
        if (jeu.verifierVictoire()) {
            vueJeu.afficherMessage("Le joueur " + jeu.getJoueurActuel() + " gagne !");
            vueJeu.desactiverChoix();
        } else if (jeu.estPlein()) {
            vueJeu.afficherMessage("Match nul !");
            vueJeu.desactiverChoix();
        } else {
            jeu.changerJoueur();
        }
    }

    private void mettreAJourVue() {
        int[][] grille = jeu.getGrille();
        for (int i = 0; i < jeu.getLignes(); i++) {
            for (int j = 0; j < jeu.getColonnes(); j++) {
                if (grille[i][j] == 1) {
                    vueJeu.afficherJeton(i, j, Color.RED);
                } else if (grille[i][j] == 2) {
                    vueJeu.afficherJeton(i, j, Color.YELLOW);
                } else {
                    vueJeu.effacerJeton(i, j); // Vous devez implémenter cette méthode dans VueJeu
                }
            }
        }
    }
}
