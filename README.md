Introduction

Ce projet implémente une version du jeu classique Puissance 4 en Java avec une interface graphique Swing. 
Le jeu permet à deux joueurs, un humain et une IA, de s'affronter en plaçant alternativement des pions dans une grille verticale. 
Le but est d'aligner quatre pions de sa propre couleur horizontalement, verticalement, ou en diagonale.

Fonctionnalités

•	Choix entre joueur humain et IA pour chaque joueur.
•	Interface graphique pour l'interaction avec le jeu.
•	Gestion des tours et détection automatique de la fin de partie.
•	Historique de partie enregistré dans un fichier log.
•	Gestion des erreurs et affichage de messages d'erreur pertinents.
•	Fonctionnalité additionnelle permettant de bloquer temporairement des colonnes.

Installation

Prérequis : Java JDK 11 ou supérieur.

Lancement du Jeu

1.	Clonez ou téléchargez le dossier du projet sur votre machine.
2.	Ouvrez un terminal et naviguez jusqu'au dossier du projet.
3.	Compilez les fichiers sources avec la commande :

 javac -d bin src/vue/*.java src/controleur/*.java src/modele/*.java

Ensuite, exécutez l'application en utilisant :

java -cp bin vue.Main 

Utilisation

•	Au démarrage, un menu permet de choisir entre un joueur humain et une IA pour les deux joueurs. Les noms des joueurs peuvent également être saisis.
•	Utilisez l'interface graphique pour placer les pions dans la grille. Le joueur 1 utilise les pions rouges, et le joueur 2 (ou l'IA) utilise les pions bleus.
•	La partie se termine lorsque l'un des joueurs aligne quatre pions ou que la grille est complètement remplie.
•	Les résultats et les messages d'erreur sont affichés directement dans l'interface graphique et enregistrés dans le fichier log.txt.

Fonctionnalité de Blocage de Colonnes

Les joueurs ont la possibilité de bloquer temporairement une colonne pour un certain nombre de tours. 
Cela empêche l'adversaire de placer un pion dans cette colonne.

Comment Bloquer une Colonne

•	Pendant votre tour, avant de placer un pion, vous pouvez choisir de bloquer une colonne en cliquant sur un bouton dédié dans l'interface graphique.
•	La colonne restera bloquée pour un nombre prédéfini de tours.
•	Un indicateur visuel montre les colonnes actuellement bloquées.

Contribution

Ce projet est ouvert aux contributions. Si vous souhaitez proposer des améliorations ou des corrections, veuillez suivre les étapes suivantes :
1.	Forker le dépôt.
2.	Créer une nouvelle branche pour votre fonctionnalité ou correction.
3.	Soumettre une pull request pour révision.

Auteurs

Ce projet a été développé par Yasmine Cherait, Pernella Lumbu et Jade Kabou dans le cadre du cours de Java POO enseigné par Madame Bennai. 
![image](https://github.com/farahyasmine/Puissance4GAME/assets/125458656/28eba7f8-f7fd-4590-bbee-efab26a7a070)
