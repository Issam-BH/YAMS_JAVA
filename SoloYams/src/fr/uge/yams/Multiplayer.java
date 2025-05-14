package fr.uge.yams;

import java.util.Scanner;

public class Multiplayer {
	public static void multi(String name) {
		System.out.println("What is Player 2 name?");
		var scanner = new Scanner(System.in);
        String nameJ2 = scanner.nextLine();
        
        var scoreSheetJ1 = new ScoreSheet();
        var scoreSheetJ2 = new ScoreSheet();
        
        // Nombre de tours total à adapter
        int totalRounds = 8; // 4 tours chacun
        
        for (var roundCounter = 0; roundCounter < totalRounds; roundCounter++) {
            if (roundCounter % 2 == 0) { // Tour du joueur 1
                System.out.println("Round " + ((roundCounter / 2) + 1) + " - " + name + "'s turn");
                
                // Nouvelle main de dés pour le joueur 1
                var boardJ1 = new Board();
                System.out.println(boardJ1);

                boolean hasScored = false;

                for (var updateCounter = 0; updateCounter < 3; updateCounter++) {
                    if (hasScored) {
                        break;
                    }
                    
                    var choice = Yams.askReroll(scanner);
                    if (choice > 0 && choice <= 5) {
                        boardJ1.reroll(choice);
                        System.out.println(boardJ1);
                    } else if (choice == 0) {
                        var combinationChoice = Yams.parseCombination(Yams.askCombination(scanner));
                        scoreSheetJ1.updateScore(combinationChoice, boardJ1);
                        System.out.println(scoreSheetJ1);
                        hasScored = true;
                        break;
                    }
                }

                // S'assurer que le joueur a noté un score avant de passer au tour suivant
                if (!hasScored) {
                    var combinationChoice = Yams.parseCombination(Yams.askCombination(scanner));
                    scoreSheetJ1.updateScore(combinationChoice, boardJ1);
                    System.out.println(scoreSheetJ1);
                }
            } else { // Tour du joueur 2
                System.out.println("Round " + ((roundCounter / 2) + 1) + " - " + nameJ2 + "'s turn");
                
                // Nouvelle main de dés pour le joueur 2
                var boardJ2 = new Board();
                System.out.println(boardJ2);

                boolean hasScored = false;

                for (var updateCounter = 0; updateCounter < 3; updateCounter++) {
                    if (hasScored) {
                        break;
                    }
                    
                    var choice = Yams.askReroll(scanner);
                    if (choice > 0 && choice <= 5) {
                        boardJ2.reroll(choice);
                        System.out.println(boardJ2);
                    } else if (choice == 0) {
                        var combinationChoice = Yams.parseCombination(Yams.askCombination(scanner));
                        scoreSheetJ2.updateScore(combinationChoice, boardJ2);
                        System.out.println(scoreSheetJ2);
                        hasScored = true;
                        break;
                    }
                }

                // S'assurer que le joueur a noté un score avant de passer au tour suivant
                if (!hasScored) {
                    var combinationChoice = Yams.parseCombination(Yams.askCombination(scanner));
                    scoreSheetJ2.updateScore(combinationChoice, boardJ2);
                    System.out.println(scoreSheetJ2);
                }
            }
        }
        
        // Affichage des scores finaux
        System.out.println("\nFinal scores:");
        System.out.println(name + ": " + scoreSheetJ1.scoreTotal());
        System.out.println(nameJ2 + ": " + scoreSheetJ2.scoreTotal());
        
        // Détermination du gagnant
        if (scoreSheetJ1.scoreTotal() > scoreSheetJ2.scoreTotal()) {
            System.out.println(name + " has Won !!!");
        } else if (scoreSheetJ1.scoreTotal() < scoreSheetJ2.scoreTotal()) {
            System.out.println(nameJ2 + " has Won !!!");
        } else {
            System.out.println("It's a tie!");
        }
        scanner.close();

	}
}
