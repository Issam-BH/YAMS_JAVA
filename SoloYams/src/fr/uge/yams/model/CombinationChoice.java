package fr.uge.yams.model;

import fr.uge.yams.combination.Carre;
import fr.uge.yams.combination.Chance;
import fr.uge.yams.combination.Combination;
import fr.uge.yams.combination.FullHouse;
import fr.uge.yams.combination.LargeStraight;
import fr.uge.yams.combination.Sacrifice;
import fr.uge.yams.combination.SmallStraight;
import fr.uge.yams.combination.ThreeOfAKind;
import fr.uge.yams.combination.YamsCombination;

public class CombinationChoice {
    public static Combination parseCombination(String combinationName) {
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

}
