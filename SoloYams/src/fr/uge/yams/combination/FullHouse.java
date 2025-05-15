package fr.uge.yams.combination;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import fr.uge.yams.model.Board;
import fr.uge.yams.model.Dice;

/**
 * Représente la combinaison "Full House" dans le jeu de Yams.
 * 
 * Un Full House est une combinaison composée de trois dés identiques (un brelan)
 * et de deux autres dés identiques (une paire), comme [2, 2, 3, 3, 3].
 *
 */
public record FullHouse() implements Combination {

    /**
     * Calcule le score pour la combinaison "Full House".
     * 
     * @param board le plateau de jeu actuel
     * @return 25 si Full House est détecté (actuellement toujours 25, sans analyse)
     */
	@Override
	public int score(Board board) {
	    Map<Integer, Integer> compteur = new HashMap<>();
	    @SuppressWarnings("unused")
		int totalDes = 0;

	    ArrayList<Dice> dices = board.getFiveDice();

	    // Compter les occurrences et additionner les valeurs
	    for (Dice de : dices) {
	        int val = de.value();
	        totalDes += val;
	        compteur.put(val, compteur.getOrDefault(val, 0) + 1);
	    }

	    boolean hasThree = false;
	    boolean hasTwo = false;

	    for (int count : compteur.values()) {
	        if (count == 3) {
	            hasThree = true;
	        } else if (count == 2) {
	            hasTwo = true;
	        }
	    }

	    return (hasThree && hasTwo) ? 25 : 0;
	}


    /**
     * Fournit une représentation textuelle de cette combinaison.
     * 
     * @return "Full House"
     */
    @Override
    public String toString() {
        return "Full House";
    }
}
