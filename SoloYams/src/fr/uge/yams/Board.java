package fr.uge.yams;

import java.util.ArrayList;

/**
 * Représente le plateau de jeu dans le Yams, contenant un ensemble de 5 dés.
 * 
 * Cette classe permet d'initialiser une série de dés, d'en relancer certains,
 * et de fournir une représentation textuelle du plateau.
 */
public class Board {

    // Liste contenant les 5 dés du jeu
    private final ArrayList<Dice> fiveDice = new ArrayList<>();

    /**
     * Constructeur du plateau.
     * Initialise automatiquement 5 dés avec des valeurs aléatoires.
     */
    public Board() {
        for (int i = 1; i <= 5; i++) {
            fiveDice.add(new Dice()); // Génère un nouveau dé et l'ajoute à la liste
        }
    }

    /**
     * Relance un des dés du plateau à la position spécifiée.
     * 
     * @param pos la position du dé à relancer (entre 1 et 5 inclus)
     * @throws IllegalArgumentException si la position est en dehors de l'intervalle valide
     */
    public void reroll(int pos) {
        if (pos < 1 || pos > 5) {
            throw new IllegalArgumentException("La position doit être entre 1 et 5.");
        }
        // Remplace le dé à la position indiquée par un nouveau dé
        fiveDice.set(pos - 1, new Dice());
    }

    /**
     * Donne une représentation textuelle du plateau de jeu, avec l'affichage de chaque dé.
     * 
     * @return une chaîne de caractères représentant les 5 dés du plateau
     */
    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            builder.append(fiveDice.get(i).toString()); // Ajoute la représentation de chaque dé
        }
        builder.append("\n").append("-----------------\n"); // Séparation visuelle
        return builder.toString();
    }

    /**
     * Méthode principale de test.
     * Affiche un plateau, relance le deuxième dé, puis affiche le plateau modifié.
     *
     * @param args les arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {
        var board = new Board();
        System.out.println(board); // Affiche les 5 dés initiaux

        board.reroll(2); // Relance le deuxième dé
        System.out.println(board); // Affiche le plateau après relance
    }
}
