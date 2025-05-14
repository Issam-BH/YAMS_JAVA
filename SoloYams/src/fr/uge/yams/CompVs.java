package fr.uge.yams;

import java.util.Scanner;

public class CompVs {
	public static void compVs(String name) {
		var scoreSheetIA = new ScoreSheet(); 
        var scoreSheet = new ScoreSheet();
        var scanner = new Scanner(System.in);
        
        // Nombre de tours total à adapter
        int totalRounds = 8; // 4 tours chacun
        
        for (var roundCounter = 0; roundCounter < totalRounds; roundCounter++) {
            if (roundCounter % 2 == 0) { // Tour du joueur
                System.out.println("Welcome in round " + (roundCounter / 2 + 1) + " - " + name + "'s turn");
                
                // Nouvelle main de dés pour le joueur
                var board = new Board();
                System.out.println(board);

                boolean hasScored = false;

                for (var updateCounter = 0; updateCounter < 3; updateCounter++) {
                    if (hasScored) {
                        break;
                    }
                    
                    var choice = Yams.askReroll(scanner);
                    if (choice > 0 && choice <= 5) {
                        board.reroll(choice);
                        System.out.println(board);
                    } else if (choice == 0) {
                        var combinationChoice = Yams.parseCombination(Yams.askCombination(scanner));
                        scoreSheet.updateScore(combinationChoice, board);
                        System.out.println(scoreSheet);
                        hasScored = true;
                        break;
                    }
                }

                // S'assurer que le joueur a noté un score avant de passer au tour suivant
                if (!hasScored) {
                    var combinationChoice = Yams.parseCombination(Yams.askCombination(scanner));
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
        System.out.println(name + ": " + scoreSheet.scoreTotal());
        System.out.println("Computer: " + scoreSheetIA.scoreTotal());
        
        // Détermination du gagnant
        if (scoreSheet.scoreTotal() > scoreSheetIA.scoreTotal()) {
            System.out.println(name + " has Won !!!");
        } else if (scoreSheet.scoreTotal() < scoreSheetIA.scoreTotal()) {
            System.out.println("The computer has won!");
        } else {
            System.out.println("It's a tie!");
        }
        scanner.close();

	}
}
