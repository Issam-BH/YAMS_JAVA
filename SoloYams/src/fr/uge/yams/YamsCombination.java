package fr.uge.yams;

import java.util.HashMap;

/**
 * Représente la combinaison "Yam's" dans le jeu de Yams.
 * 
 * Un Yam's est obtenu lorsque les 5 dés affichent exactement la même valeur.
 * Par exemple, [6,6,6,6,6].
 */
public record YamsCombination() implements Combination {

    /**
     * Calcule le score pour la combinaison "Yam's".
     * 
     * @param board le plateau de jeu actuel
     * @return 50 si les 5 dés sont identiques, sinon 0
     */
    @Override
    public int score(Board board) {
        var compteur = new HashMap<Integer, Integer>();

        for (Dice de : board.getFiveDice()) {
            int val = de.value();
            compteur.put(val, compteur.getOrDefault(val, 0) + 1);
        }

        for (int count : compteur.values()) {
            if (count == 5) {
                return 50;
            }
        }

        return 0;
    }

    /**
     * Retourne le nom de cette combinaison.
     * 
     * @return "Yam's"
     */
    @Override
    public String toString() {
        return "Yam's";
    }
}
