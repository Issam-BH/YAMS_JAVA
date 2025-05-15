package fr.uge.yams.combination;

import fr.uge.yams.model.Board;
import fr.uge.yams.model.Dice;

/**
 * Représente la combinaison "Chance" dans le jeu de Yams.
 * 
 * La Chance ne nécessite aucune condition particulière.
 * Le score est simplement la somme des valeurs des 5 dés.
 */
public record Chance() implements Combination {

    /**
     * Calcule le score pour la combinaison "Chance".
     * 
     * @param board le plateau de jeu actuel
     * @return la somme des valeurs des 5 dés
     */
    @Override
    public int score(Board board) {
        int total = 0;
        for (Dice de : board.getFiveDice()) {
            total += de.value();
        }
        return total;
    }

    /**
     * Retourne le nom de cette combinaison.
     * 
     * @return "Chance"
     */
    @Override
    public String toString() {
        return "Chance";
    }
}

