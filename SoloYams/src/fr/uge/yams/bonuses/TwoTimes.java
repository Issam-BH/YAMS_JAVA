package fr.uge.yams.bonuses;

public record TwoTimes() implements Bonus {

	@Override
	public int score() {
		// TODO Auto-generated method stub
		return 2;
	}

	@Override
	public String name() {
		// TODO Auto-generated method stub
		return "2x Final Score";
	}
	
}
