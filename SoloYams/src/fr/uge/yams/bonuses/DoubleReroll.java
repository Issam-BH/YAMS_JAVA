package fr.uge.yams.bonuses;

import java.util.Random;

public record DoubleReroll() implements Bonus {
	public int score() {
		return 1;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "+1 Bonus Reroll";
	}
}
   
   
