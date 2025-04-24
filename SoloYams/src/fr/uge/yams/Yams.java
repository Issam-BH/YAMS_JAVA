package fr.uge.yams;

import java.util.Scanner;

/**
 * Classe principale du jeu de Yams.
 * 
 * Gère l’interaction avec le joueur, le déroulement des tours, 
 * les relances de dés, le choix de combinaisons et la mise à jour du score.
 */
public class Yams {

    /**
     * Affiche un message de bienvenue et demande le nom du joueur.
     * 
     * @param scanner le scanner utilisé pour lire l'entrée utilisateur
     * @return le nom du joueur
     */
    public static String init(Scanner scanner) {
        System.out.println("Welcome, player, please enter your name.");
        return scanner.nextLine();
    }

    public static int gamemode(Scanner scanner) {
    	System.out.println("Choose your game mode : \n 1 = Classic \n 2 = V.S. COMP");
    	int choice = scanner.nextInt(); // recup int
    	scanner.nextLine(); /* Pour la faire courte la line d'avant recupere QUE un int
    	 * cependant ça nous laisse avec tout l'espace qui suit l'int ce qui 
    	 * cause des probleme avec les scanners qui suivront cette partie permet alrs
    	 * d'enlever l'espace restant - Yanis
    	 */
    	return choice;
    }
    /**
     * Demande au joueur s’il souhaite relancer un dé.
     * 
     * @param scanner le scanner pour lire la réponse
     * @return un entier entre 0 et 5 : 0 pour ne pas relancer, sinon l’index du dé à relancer
     */
    private static int askReroll(Scanner scanner) {
        System.out.println("Do you want to reroll a die? Type 0 for no, 1-5 to reroll this die.");
        var choice = scanner.nextLine();
        return Integer.parseInt(choice);
    }

    /**
     * Demande au joueur de choisir une combinaison.
     * 
     * @param scanner le scanner pour lire l'entrée
     * @return la lettre représentant la combinaison
     */
    private static String askCombination(Scanner scanner) {
        System.out.println("Please choose a combination to score in your score sheet by entering its first letter.");
        System.out.println("T = Three of a Kind | F = Full House | SQ = Carré | SS = Small Straight | LS = Large Straight | C = Chance | Y = Yams | S = Sacrifice");
        var choice = scanner.nextLine();
        return choice;
    }

    /**
     * Convertit une lettre de combinaison en instance réelle de combinaison.
     * 
     * @param combinationName la lettre entrée par le joueur
     * @return une instance de {@link Combination}
     * @throws IllegalArgumentException si la lettre est invalide
     */
    private static Combination parseCombination(String combinationName) {
        return switch (combinationName.toUpperCase()) {
            case "T" -> new ThreeOfAKind(); // IMPORTANT : Ajout des appel des scores "SPECIAUX" merci de faire un appel sur ceux-ci
            case "F" -> new FullHouse(); 
            case "SQ" -> new Carre();
            case "SS" -> new SmallStraight();
            case "LS" -> new LargeStraight();
            case "C" -> new Chance();
            case "Y" -> new YamsCombination();
            case "S" -> new Sacrifice();
            default -> throw new IllegalArgumentException("Unexpected value: " + combinationName);
        };
    }

    /**
     * Méthode principale : point d'entrée du jeu.
     * 
     * @param args les arguments de ligne de commande (non utilisés)
     */
    public static void main(String[] args) {

        var scanner = new Scanner(System.in);
        var name = init(scanner); // Récupère le nom du joueur
        System.out.println("Hello " + name + ", and good luck !\n");
        
        var scanner2 = new Scanner(System.in);
        int gamemode = gamemode(scanner2);
        
        if (gamemode == 1) {

        var scoreSheet = new ScoreSheet(); // Feuille de score du joueur
        var board = new Board(); // Lancer initial des dés
        
        /* Yanis : Prions pour que ça cause pas de bug
         * Mais j'ai déplacé le premier appel de board hors de la boucle pour permettre de sacrifier
         * une case (sinon ça allait se faire reset dès le début d'un nouveau tour) 
         */
        
        // Deux tours maximum
        for (var roundCounter = 0; roundCounter < 2; roundCounter++) {
            System.out.println("Welcome in round " + (roundCounter + 1));
            System.out.println(board);

            // Jusqu’à 3 relances possibles
            for (var updateCounter = 0; updateCounter < 3; updateCounter++) {
                var choice = askReroll(scanner);
                if (choice > 0) {
                    board.reroll(choice);
                    System.out.println(board);
                } else {
                    break;
                }
            }

            // Choix de la combinaison
            var combinationChoice = parseCombination(askCombination(scanner));
            scoreSheet.updateScore(combinationChoice, board); // Met à jour le score
            System.out.println(scoreSheet);
        }
        } else if (gamemode == 2) { // Mode VS IA ou comp
        	
        	var scoreSheetIA = new ScoreSheet(); 
            var boardIA = new Board(); 
            
            var scoreSheet = new ScoreSheet(); // Feuille de score du joueur
            var board = new Board();
            
         // 4 tours maximum
            for (var roundCounter = 0; roundCounter < 4; roundCounter++) { // Tour impair = tour joueur Tour pair = tour IA
                if (roundCounter % 2 == 0) {
            	System.out.println("Welcome in round " + (roundCounter + 1));
                System.out.println(board);

                boolean hasScored = false; // Ajoutez cette variable pour suivre si le joueur a déjà noté son score

                for (var updateCounter = 0; updateCounter < 3; updateCounter++) {
                    if (hasScored) { // Si le joueur a déjà noté son score on sort de la boucle
                        break;
                    }
                    
                    var choice = askReroll(scanner);
                    if (choice > 0) {
                        board.reroll(choice);
                        System.out.println(board);
                    } else if (choice == 0) {
                        var combinationChoice = parseCombination(askCombination(scanner));
                        scoreSheet.updateScore(combinationChoice, board); // Met à jour le score
                        System.out.println(scoreSheet);
                        hasScored = true; // Marquer que le joueur a noté son score
                        break; // Sortir de la boucle des relances
                    }
                }

                // S'assurer que le joueur a noté un score avant de passer au tour suivant
                if (!hasScored) {
                    var combinationChoice = parseCombination(askCombination(scanner));
                    scoreSheet.updateScore(combinationChoice, board);
                    System.out.println(scoreSheet);
                }
            }
             else if (roundCounter % 2 != 0) // Tour IA
            {
            	System.out.println("AI Turn !");
            	System.out.println(boardIA); 
            	/*
            	 *  TODO: Pimenter la difficulté de l'IA (voir comment reroll de façon intelliente
            	 *  ou rigged ses drop à voir)
            	*/
            	var combi = Computer.chooseBestCombination(boardIA);
                scoreSheetIA.updateScore(combi, boardIA); // Met à jour le score
            }
            }
            // On la game est terminée normalement
            if (scoreSheet.scoreTotal() > scoreSheetIA.scoreTotal()) {
            	System.out.println(name + " has Won !!!");
            } else {
            	System.out.println("The computer has won !");
            }
        } else {
        	System.out.println("Choix invalide"); 
        }

        System.out.println("C'est fini !");
    }
}
