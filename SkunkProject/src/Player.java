import edu.princeton.cs.introcs.StdOut;

public class Player {

	
	public int playerScore; //uninitialized value is zero
	public int turnScore;
	public int roundScore;
	public int lastTurnScore;
	public String name; //uninitialized value is null
	public int chip; //uninitialized value is zero
	
	public Player () {
		
	}
	
	public Player (String name) {
		this.name = name;
		this.turnScore = 0;
		this.chip = 50;
	}
	
	
	public int getChip() {
		return chip;
	}
	
	public void addSubChip(int chipChange) {
		chip += chipChange;
	}

	
	public int getScore() {
		return playerScore;
	}
	
	public void addScore(int points) {
		playerScore += points;
	}
	
	public int getTurnScore() {
		return turnScore;
	}

	public void setTurnScore(int turnScore) {
		this.turnScore = turnScore;
	}
	
	
	public boolean checkHundred () {
		if (getTurnScore() >= 100) {
			return true;
		}
		return false;
	}

	public void setLastTurnScore(int turnScore) {
		this.lastTurnScore = turnScore;;
	}


}
