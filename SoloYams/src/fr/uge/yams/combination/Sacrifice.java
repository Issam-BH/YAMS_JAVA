package fr.uge.yams.combination;

import fr.uge.yams.model.Board;

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

