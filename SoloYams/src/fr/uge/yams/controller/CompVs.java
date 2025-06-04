package fr.uge.yams.controller;

import java.util.Scanner;

import fr.uge.yams.Yams;
import fr.uge.yams.model.Board;
import fr.uge.yams.model.BonusCombination;
import fr.uge.yams.model.CombinationChoice;
import fr.uge.yams.model.Computer;
import fr.uge.yams.model.ScoreSheet;
import fr.uge.yams.vue.Vue;

public class CompVs {
	public static void compVs(String name) {
		var scoreSheetIA = new ScoreSheet(); 
        var scoreSheet = new ScoreSheet();
        var scanner = new Scanner(System.in);
        var bonus1 = BonusCombination.parseCombination();
        var bonus2 = BonusCombination.parseCombination();

        int maxchoice1 = 3;
        int finalScore1 = 0;
        
        int finalScore2 = 0;
        
        
        
        System.out.println("Bonus received J1 : " + bonus1.name());
        System.out.println("Bonus received COMP : " + bonus2.name());



        // Nombre de tours total à adapter
        int totalRounds = 8; // 4 tours chacun
        
        for (var roundCounter = 0; roundCounter < totalRounds; roundCounter++) {
            if (roundCounter % 2 == 0) { // Tour du joueur
                System.out.println("Welcome in round " + (roundCounter / 2 + 1) + " - " + name + "'s turn");
                
                
                
                if (bonus1.score() == 1) {
                	maxchoice1 += 1;
                } else if (bonus1.score() == 3) {
                	maxchoice1 += 99; 
                }
                
                // Nouvelle main de dés pour le joueur
                var board = new Board();
                System.out.println(board);

                boolean hasScored = false;

                for (var updateCounter = 0; updateCounter < maxchoice1; updateCounter++) {
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
            } else { // Tour de l'IA
                System.out.println("Round " + ((roundCounter / 2) + 1) + " - AI Turn!");
                

                // Nouvelle main de dés pour l'IA
                var boardIA = new Board();
                System.out.println("AI rolls: " + boardIA);
                
                // Logique de l'IA pour choisir la meilleure combinaison
                var combi = Computer.chooseBestCombination(boardIA);
                scoreSheetIA.updateScore(combi, boardIA);
                System.out.println("AI chooses: " + combi.getClass().getSimpleName());
                System.out.println("AI score sheet: " + scoreSheetIA);
            }
        }
        
        // Affichage des scores finaux
        System.out.println("\nFinal scores:");
        
        if (bonus2.score() == 1) { // Compensation vu que l'ia peut pas reroll
        	finalScore2 += scoreSheetIA.scoreTotal() + 10; 
        } else if (bonus2.score() == 3) {
        	finalScore2 += scoreSheetIA.scoreTotal() + 30; 
        }
        
        if (bonus1.score() == 2) {
        	finalScore1 = scoreSheet.scoreTotal() * 2;
        } else {
        	finalScore1 = scoreSheet.scoreTotal();
        }
        System.out.println(name + ": " + finalScore1);
        System.out.println("Computer: " + finalScore2);
        
        // Détermination du gagnant
        if (finalScore1 > finalScore2) {
            System.out.println(name + " has Won !!!");
        } else if (finalScore1 < finalScore2) {
            System.out.println("The computer has won!");
        } else {
            System.out.println("It's a tie!");
        }
        scanner.close();

	}
}
