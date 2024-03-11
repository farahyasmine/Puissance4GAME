public class Puissance4 {
    private final int ROWS = 6;
    private final int COLS = 7;
    private int[][] grid = new int[ROWS][COLS];
    private int currentPlayer = 1; // 1 pour Joueur 1, 2 pour Joueur 2 ou IA
    private boolean gameEnded = false;

    public Puissance4() {
        initializeGrid();
    }

    private void initializeGrid() {
        for (int i = 0; i < ROWS; i++) {
            for (int j = 0; j < COLS; j++) {
                grid[i][j] = 0; // 0 indique une cellule vide
            }
        }
    }

    public boolean play(int column) {
        if (column < 0 || column >= COLS || gameEnded || grid[0][column] != 0) {
            return false; // Coup invalide
        }

        for (int i = ROWS - 1; i >= 0; i--) {
            if (grid[i][column] == 0) {
                grid[i][column] = currentPlayer;
                if (checkVictory(i, column)) {
                    gameEnded = true;
                    System.out.println("Le joueur " + currentPlayer + " gagne !");
                    // Ici, vous pourriez appeler une méthode pour enregistrer le résultat dans la base de données
                }
                currentPlayer = currentPlayer == 1 ? 2 : 1;
                return true;
            }
        }
        return false;
    }

    private boolean checkVictory(int row, int col) {
        int player = grid[row][col];
        if (player == 0) return false; // Pas de pion à cette position

        // Vérifiez horizontalement, verticalement, et les deux diagonales
        return (checkLine(player, row, col, 0, 1) || // Horizontal
                checkLine(player, row, col, 1, 0) || // Vertical
                checkLine(player, row, col, 1, 1) || // Diagonale montante
                checkLine(player, row, col, 1, -1));  // Diagonale descendante
    }

    private boolean checkLine(int player, int row, int col, int dRow, int dCol) {
        int count = 1;
        int r, c;

        // Comptez dans la direction positive
        r = row + dRow;
        c = col + dCol;
        while (r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] == player) {
            count++;
            r += dRow;
            c += dCol;
        }

        // Comptez dans la direction négative
        r = row - dRow;
        c = col - dCol;
        while (r >= 0 && r < ROWS && c >= 0 && c < COLS && grid[r][c] == player) {
            count++;
            r -= dRow;
            c -= dCol;
        }

        return count >= 4;
    }

    // Méthode pour choisir une colonne aléatoirement pour l'IA
    // À améliorer pour une vraie stratégie
    public void playAI() {
        if (gameEnded) return;

        int column;
        do {
            column = (int)(Math.random() * COLS);
        } while (!play(column));
    }

    public static void main(String[] args) {
        Puissance4 game = new Puissance4();
        // Ici, vous pouvez simuler une partie ou intégrer avec l'interface utilisateur pour les interactions
    }
}
