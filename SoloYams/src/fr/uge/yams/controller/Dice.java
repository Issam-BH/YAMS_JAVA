package fr.uge.yams.controller;

import java.util.Random;

/**
 * Représente un dé à 6 faces utilisé dans le jeu de Yams.
 * Cette classe est immutable : chaque instance représente un dé avec une valeur fixe entre 1 et 6.
 * Elle offre également la possibilité de relancer le dé pour obtenir une nouvelle valeur aléatoire.
 *
 * @param value la valeur du dé, comprise entre 1 et 6
 */
public record Dice(int value) {

    /**
     * Constructeur compact (automatiquement appelé lors de toute création d'une instance).
     * Vérifie que la valeur fournie est bien comprise entre 1 et 6.
     *
     * @throws IllegalArgumentException si la valeur est inférieure à 1 ou supérieure à 6
     */
    public Dice {
        if (value > 6 || value < 1) {
            throw new IllegalArgumentException("La valeur du dé doit être entre 1 et 6.");
        }
    }

    /**
     * Constructeur sans argument qui génère automatiquement une valeur aléatoire entre 1 et 6.
     */
    public Dice() {
        // new Random().nextInt(6) + 1 : génère un nombre entre 1 (inclus) et 7 (exclus)
        this(new Random().nextInt(6) + 1);
    }

    /**
     * Relance le dé, c'est-à-dire génère un nouveau dé avec une valeur aléatoire.
     *
     * @return un nouvel objet Dice avec une nouvelle valeur entre 1 et 6
     */
    public Dice reroll() {
        return new Dice(); // relance en créant un nouveau dé
    }

    /**
     * Fournit une représentation textuelle du dé, dans un format graphique simple.
     *
     * @return une chaîne de caractères représentant le dé avec sa valeur actuelle
     */
    @Override
    public String toString() {
        // Format simplifié d’un dé : encadré avec la valeur au centre
        return "-------\n" + "|  " + value + "  |\n" + "-------\n";
    }
    
    /*
     * Exemple de sortie du toString :
     * -------
     * |  5  |
     * -------
     */
}
