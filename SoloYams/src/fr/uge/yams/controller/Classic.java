package fr.uge.yams.controller;

import fr.uge.yams.bonuses.Bonus;

import java.util.Scanner;

import fr.uge.yams.Yams;
import fr.uge.yams.model.Board;
import fr.uge.yams.model.BonusCombination;
import fr.uge.yams.model.CombinationChoice;
import fr.uge.yams.model.ScoreSheet;
import fr.uge.yams.vue.Vue;

public class Classic {
	public static void classic(String name) {
		var scoreSheet = new ScoreSheet();
        var board = new Board();
        var scanner = new Scanner(System.in);
        var bonus = BonusCombination.parseCombination();
        int maxchoice = 3;
        int finalScore = 0;
        
        
        System.out.println("Bonus reçu : " + bonus.getClass().getSimpleName());

        if (bonus.score() == 1) {
        	maxchoice += 1;
        } else if (bonus.score() == 3) {
        	maxchoice += 99; // FUCK BALANCING TS GAME
        }
        // Nombre de tours à adapter selon les règles du jeu
        int totalRounds = 13; // Typiquement 13 dans un Yams complet
        
        for (var roundCounter = 0; roundCounter < totalRounds; roundCounter++) {
            System.out.println("Welcome in round " + (roundCounter + 1));
            
            // Créer un nouveau lancé de dés à chaque tour
            board = new Board();
            System.out.println(board);

            boolean hasScored = false;
            
            // Jusqu'à 3 relances possibles
            for (var updateCounter = 0; updateCounter < maxchoice; updateCounter++) {
                if (hasScored) {
                    break;
                }
                
                
                var choice = Vue.askReroll(scanner);
                if (choice > 0 && choice <= 5) {
                    board.reroll(choice);
                    System.out.println(board);
                } else if (choice == 0) {
                    var combinationChoice = CombinationChoice.parseCombination(Vue.askCombination(scanner));
                    scoreSheet.updateScore(combinationChoice, board);
                    System.out.println(scoreSheet);
                    hasScored = true;
                    break;
                }
            }

            // S'assurer que le joueur a noté un score avant de passer au tour suivant
            if (!hasScored) {
                var combinationChoice = CombinationChoice.parseCombination(Vue.askCombination(scanner));
                scoreSheet.updateScore(combinationChoice, board);
                System.out.println(scoreSheet);
            }
        }
        if (bonus.score() == 2) {
        	finalScore = scoreSheet.scoreTotal() * 2;
        } else {
        	finalScore = scoreSheet.scoreTotal();
        }
        System.out.println("Final score: " + finalScore);
        scanner.close();

		}
}
