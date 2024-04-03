

package model;

public class Jeu {
    private final int LIGNES = 6; // Nombre de lignes
    public final int COLONNES = 7;
    private final int[][] grille = new int[LIGNES][COLONNES];
    private int joueurActuel;

    // Méthode pour obtenir le nombre de lignes
    public int getLignes() {
        return LIGNES;
    }

    // Méthode pour obtenir le nombre de colonnes
    public int getColonnes() {
        return COLONNES;
    }

    public Jeu() {
        reinitialiserJeu();
    }

    public void reinitialiserJeu() {
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                grille[i][j] = 0; // 0 représente une cellule vide
            }
        }
        joueurActuel = 1; // Joueur 1 commence
    }

    public boolean jouer(int colonne) {
        if (colonne < 0 || colonne >= COLONNES) {
            return false; // Coup invalide si la colonne est hors limites
        }

        // Trouve la première cellule vide dans la colonne (de bas en haut)
        for (int i = LIGNES - 1; i >= 0; i--) {
            if (grille[i][colonne] == 0) {
                grille[i][colonne] = joueurActuel; // Place le jeton du joueur actuel
                if (verifierVictoire(i, colonne, joueurActuel)) {
                    System.out.println("Le joueur " + joueurActuel + " gagne !");
                    // Vous pouvez appeler une méthode pour gérer la fin du jeu ici
                }
                joueurActuel = (joueurActuel == 1) ? 2 : 1; // Change de joueur
                return true; // Coup valide
            }
        }

        return false; // Coup invalide si la colonne est pleine
    }

    private boolean verifierVictoire(int ligne, int colonne, int joueur) {
        // Vérifiez horizontalement, verticalement, et les deux diagonales pour une victoire
        return verifierDirection(ligne, colonne, 0, 1, joueur) || // Horizontal
                verifierDirection(ligne, colonne, 1, 0, joueur) || // Vertical
                verifierDirection(ligne, colonne, 1, 1, joueur) || // Diagonale descendante
                verifierDirection(ligne, colonne, 1, -1, joueur);  // Diagonale ascendante
    }

    private boolean verifierDirection(int ligne, int colonne, int deltaLigne, int deltaColonne, int joueur) {
        int compte = 1; // Compte le jeton actuel
        int r, c;

        // Comptez dans une direction
        r = ligne + deltaLigne;
        c = colonne + deltaColonne;
        while (r >= 0 && r < LIGNES && c >= 0 && c < COLONNES && grille[r][c] == joueur) {
            compte++;
            r += deltaLigne;
            c += deltaColonne;
        }

        // Comptez dans la direction opposée
        r = ligne - deltaLigne;
        c = colonne - deltaColonne;
        while (r >= 0 && r < LIGNES && c >= 0 && c < COLONNES && grille[r][c] == joueur) {
            compte++;
            r -= deltaLigne;
            c -= deltaColonne;
        }

        return compte >= 4; // Victoire si au moins 4 jetons sont alignés
    }

    public int[][] getGrille() {
        return grille;
    }

    public boolean estPlein() {
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                if (grille[i][j] == 0) {
                    return false; // Il reste des mouvements possibles
                }
            }
        }
        return true; // La grille est pleine
    }

    public void changerJoueur() {
        joueurActuel = (joueurActuel == 1) ? 2 : 1;
    }

    public int getJoueurActuel() {
        return joueurActuel;
    }

    public boolean verifierVictoire() {
        for (int i = 0; i < LIGNES; i++) {
            for (int j = 0; j < COLONNES; j++) {
                if (grille[i][j] == joueurActuel) { // Vérifiez seulement si la cellule appartient au joueur actuel
                    // Vérifiez dans toutes les directions à partir de cette cellule
                    if (verifierDirection(i, j, 0, 1, joueurActuel) || // Horizontal
                            verifierDirection(i, j, 1, 0, joueurActuel) || // Vertical
                            verifierDirection(i, j, 1, 1, joueurActuel) || // Diagonale descendante
                            verifierDirection(i, j, 1, -1, joueurActuel)) {  // Diagonale montante
                        return true; // Le joueur actuel a gagné
                    }
                }
            }
        }
        return false; // Aucun gagnant trouvé

    }
}
