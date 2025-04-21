package fr.uge.yams;

import java.util.HashSet;

/**
 * Représente la combinaison "Large Straight" (Grande suite) dans le jeu de Yams.
 * 
 * Une Grande suite est une suite complète de 5 dés consécutifs,
 * par exemple [1,2,3,4,5] ou [2,3,4,5,6].
 */
public record LargeStraight() implements Combination {

	/**
     * Calcule le score pour la combinaison "Grande Suite".
     * 
     * @param board le plateau de jeu actuel
     * @return 40 si une suite de 5 dés consécutifs est trouvée, sinon 0
     */
	@Override
    public int score(Board board) {
        var dice = board.getFiveDice();
        var values = new HashSet<Integer>();

        for (Dice de : dice) {
            values.add(de.value());
        }

        if (values.size() == 5 &&
            ((values.contains(1) && values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5)) ||
             (values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5) && values.contains(6)))) {
            return 40;
        }

        return 0;
    }
    
    /**
     * Fournit une représentation textuelle de cette combinaison.
     * 
     * @return "Grande suite"
     */
    @Override
    public String toString() {
        return "Grande suite";
    }
}
