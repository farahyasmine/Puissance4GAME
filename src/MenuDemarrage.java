import javax.swing.*;
import java.awt.event.ActionEvent;

public class MenuDemarrage extends JFrame {
    private JTextField nomJoueur1 = new JTextField("Joueur 1");
    private JTextField nomJoueur2 = new JTextField("IA");
    private JButton boutonDemarrer = new JButton("Démarrer");

    public MenuDemarrage() {
        setTitle("Puissance 4 - Choix du Mode");
        setSize(300, 200);
        setLayout(new BoxLayout(getContentPane(), BoxLayout.Y_AXIS));
        add(new JLabel("Nom Joueur 1 :"));
        add(nomJoueur1);
        add(new JLabel("Nom Joueur 2 / IA :"));
        add(nomJoueur2);
        boutonDemarrer.addActionListener(this::demarrerJeu);
        add(boutonDemarrer);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    private void demarrerJeu(ActionEvent e) {
        // Initialisation et démarrage du jeu avec les noms des joueurs
        // Vous devez adapter cette partie pour intégrer correctement avec votre logique de jeu existante
        System.out.println("Démarrage du jeu avec " + nomJoueur1.getText() + " et " + nomJoueur2.getText());
        // Fermez ce menu et ouvrez la fenêtre de jeu principale
    }

}
