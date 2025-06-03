package fr.uge.yams.bonuses;

import java.util.Random;

public record DoubleReroll() implements Bonus {
	public int score() {
		return 1;
	}
}
   
   
