package fr.uge.yams;

import java.util.Scanner;

/**
 * Classe principale du jeu de Yams.
 * 
 * Gère l'interaction avec le joueur, le déroulement des tours, 
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

    /**
     * Demande au joueur de choisir un mode de jeu.
     * 
     * @param scanner le scanner utilisé pour lire l'entrée utilisateur
     * @return le mode de jeu choisi (1=Classic, 2=VS COMP, 3=1V1)
     */
    public static int gamemode(Scanner scanner) {
        System.out.println("Choose your game mode : \n 1 = Classic \n 2 = V.S. COMP \n 3 = 1 V 1");
        int choice = scanner.nextInt();
        scanner.nextLine(); // Pour vider le buffer
        return choice;
    }

    /**
     * Demande au joueur s'il souhaite relancer un dé.
     * 
     * @param scanner le scanner pour lire la réponse
     * @return un entier entre 0 et 5 : 0 pour ne pas relancer, sinon l'index du dé à relancer
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
        System.out.println("Note : You can't use the combination you've already choose.");
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
            case "T" -> new ThreeOfAKind();
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
        // Un seul scanner pour toute l'application
        var scanner = new Scanner(System.in);
        var name = init(scanner); // Récupère le nom du joueur
        System.out.println("Hello " + name + ", and good luck !\n");
        
        int gamemode = gamemode(scanner);
        
        if (gamemode == 1) { // Mode classique
            var scoreSheet = new ScoreSheet();
            var board = new Board();
            
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
                    
                    var choice = askReroll(scanner);
                    if (choice > 0 && choice <= 5) {
                        board.reroll(choice);
                        System.out.println(board);
                    } else if (choice == 0) {
                        var combinationChoice = parseCombination(askCombination(scanner));
                        scoreSheet.updateScore(combinationChoice, board);
                        System.out.println(scoreSheet);
                        hasScored = true;
                        break;
                    }
                }

                // S'assurer que le joueur a noté un score avant de passer au tour suivant
                if (!hasScored) {
                    var combinationChoice = parseCombination(askCombination(scanner));
                    scoreSheet.updateScore(combinationChoice, board);
                    System.out.println(scoreSheet);
                }
            }
            
            System.out.println("Final score: " + scoreSheet.scoreTotal());
            
        } else if (gamemode == 2) { // Mode VS IA
            var scoreSheetIA = new ScoreSheet(); 
            var scoreSheet = new ScoreSheet();
            
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
                        
                        var choice = askReroll(scanner);
                        if (choice > 0 && choice <= 5) {
                            board.reroll(choice);
                            System.out.println(board);
                        } else if (choice == 0) {
                            var combinationChoice = parseCombination(askCombination(scanner));
                            scoreSheet.updateScore(combinationChoice, board);
                            System.out.println(scoreSheet);
                            hasScored = true;
                            break;
                        }
                    }

                    // S'assurer que le joueur a noté un score avant de passer au tour suivant
                    if (!hasScored) {
                        var combinationChoice = parseCombination(askCombination(scanner));
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
            
        } else if (gamemode == 3) { // Mode 1 contre 1
            System.out.println("What is Player 2 name?");
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
                        
                        var choice = askReroll(scanner);
                        if (choice > 0 && choice <= 5) {
                            boardJ1.reroll(choice);
                            System.out.println(boardJ1);
                        } else if (choice == 0) {
                            var combinationChoice = parseCombination(askCombination(scanner));
                            scoreSheetJ1.updateScore(combinationChoice, boardJ1);
                            System.out.println(scoreSheetJ1);
                            hasScored = true;
                            break;
                        }
                    }

                    // S'assurer que le joueur a noté un score avant de passer au tour suivant
                    if (!hasScored) {
                        var combinationChoice = parseCombination(askCombination(scanner));
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
                        
                        var choice = askReroll(scanner);
                        if (choice > 0 && choice <= 5) {
                            boardJ2.reroll(choice);
                            System.out.println(boardJ2);
                        } else if (choice == 0) {
                            var combinationChoice = parseCombination(askCombination(scanner));
                            scoreSheetJ2.updateScore(combinationChoice, boardJ2);
                            System.out.println(scoreSheetJ2);
                            hasScored = true;
                            break;
                        }
                    }

                    // S'assurer que le joueur a noté un score avant de passer au tour suivant
                    if (!hasScored) {
                        var combinationChoice = parseCombination(askCombination(scanner));
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
        } else {
            System.out.println("Choix invalide");
        }

        System.out.println("Game Over!");
        scanner.close();
    }
}