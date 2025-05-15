package fr.uge.yams.controller;

import java.util.HashMap;
import java.util.Map;

import fr.uge.yams.combination.Carre;
import fr.uge.yams.combination.Chance;
import fr.uge.yams.combination.Combination;
import fr.uge.yams.combination.FullHouse;
import fr.uge.yams.combination.LargeStraight;
import fr.uge.yams.combination.Sacrifice;
import fr.uge.yams.combination.SmallStraight;
import fr.uge.yams.combination.ThreeOfAKind;
import fr.uge.yams.combination.YamsCombination;

public class Computer {
	public static Combination chooseBestCombination(Board board) {
		Map<Combination, Integer> scores = new HashMap<>();
		Combination[] combinations = {
	            new ThreeOfAKind(),
	            new FullHouse(),
	            new Carre(),
	            new SmallStraight(),
	            new LargeStraight(),
	            new Chance(),
	            new YamsCombination(),
	            new Sacrifice()
	        };
		for (Combination combi : combinations) { // On teste toute les combinaisons
			int score = combi.score(board);
	        scores.put(combi, score); // On les mets dans scores
		}
		Combination bestcombi = null;
		int maxScore = -1;
	    
	    for (Map.Entry<Combination, Integer> entry : scores.entrySet()) {
	        if (entry.getValue() > maxScore) { // On voit laquelle a la meilleure valeur
	            maxScore = entry.getValue(); // Normalement à la fin du programme ça prendra le meilleure score (j'espère)
	            bestcombi = entry.getKey();
	        }
	    }
	    
	    System.out.println("AI Score = " + maxScore); // Au moins on annonce et on s'embete pas
	    return bestcombi; 
	}
}
