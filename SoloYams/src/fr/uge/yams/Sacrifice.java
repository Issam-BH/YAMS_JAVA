package fr.uge.yams;

public record Sacrifice() implements Combination {
	public int score(Board board) {
		board.sacrifice();
		return 0;
	}
	
	@Override
    public String toString() {
        return "Sacrifice";
    }
}

