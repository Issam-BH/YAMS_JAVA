package fr.uge.yams.bonuses;

public record PerfectReroll() implements Bonus{

	@Override
	public int score() {
		// TODO Auto-generated method stub
		return 3;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "Perfect Reroll";
	}

}
