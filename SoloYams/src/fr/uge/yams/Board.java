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
    private int cases = 5;
    private final ArrayList<Dice> garde = new ArrayList<>();

    /**
     * Constructeur du plateau.
     * Initialise automatiquement 5 dés avec des valeurs aléatoires.
     */
    public Board() {
        int count = 0;
    	for (int i = 1; i <= 5; i++) {
            fiveDice.add(new Dice()); // Génère un nouveau dé et l'ajoute à la liste
        }
        
        for (Dice de : fiveDice) {
        	count++;
        	if (count <= cases) {
        		garde.add(de);
        	}
        }
    }

    /**
     * Relance un des dés du plateau à la position spécifiée.
     * 
     * @param pos la position du dé à relancer (entre 1 et 5 inclus)
     * @throws IllegalArgumentException si la position est en dehors de l'intervalle valide
     */
    public void reroll(int pos) {
        if (pos < 1 || pos > cases) {
            throw new IllegalArgumentException("La position doit être entre 1 et le nombre de cases actuelles.");
        }
        // Remplace le dé à la position indiquée par un nouveau dé
        Dice reroll = new Dice();
        fiveDice.set(pos - 1, reroll);
        garde.set(pos - 1, reroll);
    }
    
    public void sacrifice() {
        if (cases > 0) {
            cases -= 1;
            garde.remove(cases); 
            System.out.println("You got " + cases + " cases left");
        } else {
            System.out.println("No more dice to sacrifice!");
        }
    }
    /**
     * Donne une représentation textuelle du plateau de jeu, avec l'affichage de chaque dé.
     * 
     * @return une chaîne de caractères représentant les 5 dés du plateau
     */
    @Override
    public String toString() {
        var builder = new StringBuilder();
        for (int i = 0; i < cases; i++) {
            builder.append(garde.get(i).toString()); // Ajoute la représentation de chaque dé
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
    
    /**
     * Retourne la liste des 5 dés du plateau.
     * 
     * Cette méthode permet d'accéder à la liste des dès qu'on a actuellement.
     * sur le plateau de jeu. La liste retournée est une ArrayList contenant des objets Dice.
     * 
     * @return une ArrayList contenant les 5 dés du plateau
     */
    public ArrayList<Dice> getFiveDice() {
        return garde;
    }

}
