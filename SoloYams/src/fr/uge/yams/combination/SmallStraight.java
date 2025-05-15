package fr.uge.yams.combination;

import java.util.HashSet;

import fr.uge.yams.controller.Board;
import fr.uge.yams.controller.Dice;

/**
 * Représente la combinaison "Small Straight" (Petite suite) dans le jeu de Yams.
 * 
 * Une petite suite est une suite de 4 dés consécutifs parmi les 5 lancés,
 * par exemple [1,2,3,4,x] ou [3,4,5,6,x].
 */
public record SmallStraight() implements Combination {

	/**
	 * Calcule le score pour la combinaison "Petite Suite".
	 * 
	 * @param board le plateau de jeu actuel
	 * @return 30 si une suite de 4 dés consécutifs est trouvée, sinon 0
	 */
    @Override
    public int score(Board board) {
        var dices = board.getFiveDice();
        var values = new HashSet<Integer>();

        for (Dice de : dices) {
            values.add(de.value());
        }

        if ((values.contains(1) && values.contains(2) && values.contains(3) && values.contains(4)) ||
            (values.contains(2) && values.contains(3) && values.contains(4) && values.contains(5)) ||
            (values.contains(3) && values.contains(4) && values.contains(5) && values.contains(6))) {
            return 30;
        }

        return 0;
    }
    
    /**
     * Fournit une représentation textuelle de cette combinaison.
     * 
     * @return "Petite suite"
     */
    @Override
    public String toString() {
        return "Petite suite";
    }
}
