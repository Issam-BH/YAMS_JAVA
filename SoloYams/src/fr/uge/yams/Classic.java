package fr.uge.yams;

import java.util.Scanner;

public class Classic {
	public static void classic(String name) {
		var scoreSheet = new ScoreSheet();
        var board = new Board();
        var scanner = new Scanner(System.in);
        
        // Nombre de tours à adapter selon les règles du jeu
        int totalRounds = 13; // Typiquement 13 dans un Yams complet
        
        for (var roundCounter = 0; roundCounter < totalRounds; roundCounter++) {
            System.out.println("Welcome in round " + (roundCounter + 1));
            
            // Créer un nouveau lancé de dés à chaque tour
            board = new Board();
            System.out.println(board);

            boolean hasScored = false;
            
            // Jusqu'à 3 relances possibles
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
        }
        
        System.out.println("Final score: " + scoreSheet.scoreTotal());
        scanner.close();

		}
}
