package fr.uge.yams.controller;

import java.util.Scanner;
import fr.uge.yams.model.Board;
import fr.uge.yams.model.BonusCombination;
import fr.uge.yams.model.CombinationChoice;
import fr.uge.yams.model.ScoreSheet;
import fr.uge.yams.vue.Vue;

import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class Multiplayer {

    // Clip audio partagé pour pouvoir arrêter le son
    private static Clip clip;

    public static void jouerSon(String cheminFichier) {
        try {
            arreterSon(); // Arrêter un son déjà en cours, s’il y en a un

            File fichierAudio = new File(cheminFichier);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(fichierAudio);

            clip = AudioSystem.getClip();
            clip.open(audioStream);
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            System.out.println("Format audio non supporté : " + e.getMessage());
        } catch (LineUnavailableException e) {
            System.out.println("Ligne audio indisponible : " + e.getMessage());
        } catch (IOException e) {
            System.out.println("Erreur lors de la lecture du fichier : " + e.getMessage());
        }
    }

    public static void arreterSon() {
        if (clip != null && clip.isRunning()) {
            clip.stop();
            clip.close();
        }
    }

    public static void multi(String name) {
        System.out.println("What is Player 2 name?");
        var scanner = new Scanner(System.in);
        String nameJ2 = scanner.nextLine();

        var scoreSheetJ1 = new ScoreSheet();
        var scoreSheetJ2 = new ScoreSheet();

        var bonus1 = BonusCombination.parseCombination();
        var bonus2 = BonusCombination.parseCombination();

        int maxchoice1 = 3;
        int finalScore1 = 0;

        int maxchoice2 = 3;
        int finalScore2 = 0;

        System.out.println("Bonus received J1 : " + bonus1.name());
        System.out.println("Bonus received COMP : " + bonus2.name());

        int totalRounds = 8; // 4 tours chacun

        for (var roundCounter = 0; roundCounter < totalRounds; roundCounter++) {
            if (roundCounter % 2 == 0) { // Joueur 1
                arreterSon(); // arrêter son joueur 2 s'il tournait encore
                System.out.println("Round " + ((roundCounter / 2) + 1) + " - " + name + "'s turn");
                jouerSon("Player_1_OST.wav");


                if (bonus1.score() == 1) {
                    maxchoice1 += 1;
                } else if (bonus1.score() == 3) {
                    maxchoice1 += 99;
                }

                var boardJ1 = new Board();
                System.out.println(boardJ1);

                boolean hasScored = false;
                for (var updateCounter = 0; updateCounter < maxchoice1; updateCounter++) {
                    if (hasScored) break;

                    var choice = Vue.askReroll(scanner);
                    if (choice > 0 && choice <= 5) {
                        boardJ1.reroll(choice);
                        System.out.println(boardJ1);
                    } else if (choice == 0) {
                        var combinationChoice = CombinationChoice.parseCombination(Vue.askCombination(scanner));
                        scoreSheetJ1.updateScore(combinationChoice, boardJ1);
                        System.out.println(scoreSheetJ1);
                        hasScored = true;
                        break;
                    }
                }
                if (!hasScored) {
                    var combinationChoice = CombinationChoice.parseCombination(Vue.askCombination(scanner));
                    scoreSheetJ1.updateScore(combinationChoice, boardJ1);
                    System.out.println(scoreSheetJ1);
                }

            } else { // Joueur 2
                arreterSon(); // arrêter son joueur 1
                System.out.println("Round " + ((roundCounter / 2) + 1) + " - " + nameJ2 + "'s turn");
                jouerSon("Player_1_OST.wav");

                if (bonus2.score() == 1) {
                    maxchoice2 += 1;
                } else if (bonus2.score() == 3) {
                    maxchoice2 += 99;
                }

                var boardJ2 = new Board();
                System.out.println(boardJ2);

                boolean hasScored = false;
                for (var updateCounter = 0; updateCounter < maxchoice2; updateCounter++) {
                    if (hasScored) break;

                    var choice = Vue.askReroll(scanner);
                    if (choice > 0 && choice <= 5) {
                        boardJ2.reroll(choice);
                        System.out.println(boardJ2);
                    } else if (choice == 0) {
                        var combinationChoice = CombinationChoice.parseCombination(Vue.askCombination(scanner));
                        scoreSheetJ2.updateScore(combinationChoice, boardJ2);
                        System.out.println(scoreSheetJ2);
                        hasScored = true;
                        break;
                    }
                }
                if (!hasScored) {
                    var combinationChoice = CombinationChoice.parseCombination(Vue.askCombination(scanner));
                    scoreSheetJ2.updateScore(combinationChoice, boardJ2);
                    System.out.println(scoreSheetJ2);
                }
            }
        }

        // Scores finaux
        System.out.println("\nFinal scores:");
        finalScore1 = (bonus1.score() == 2) ? scoreSheetJ1.scoreTotal() * 2 : scoreSheetJ1.scoreTotal();
        finalScore2 = (bonus2.score() == 2) ? scoreSheetJ2.scoreTotal() * 2 : scoreSheetJ2.scoreTotal();

        System.out.println(name + ": " + finalScore1);
        System.out.println(nameJ2 + ": " + finalScore2);

        // Gagnant
        if (finalScore1 > finalScore2) {
            System.out.println(name + " has Won !!!");
        } else if (finalScore1 < finalScore2) {
            System.out.println(nameJ2 + " has Won !!!");
        } else {
            System.out.println("It's a tie!");
        }
        scanner.close();
        arreterSon(); // Stop final
    }
}
