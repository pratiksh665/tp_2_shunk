import edu.princeton.cs.introcs.StdOut;

public class Player {

	
	public int turnScore;
	public int roundScore;
	public int lastTurnScore;
	public String name; //uninitialized value is null
	public int chipPile; //uninitialized value is zero
	
	public Player () {
		
	}
	
	public Player (String name) {
		this.name = name;
		this.turnScore = 0;
		this.chipPile = 50;
	}
	
	
	public int getChip() {
		return chipPile;
	}
	
	public void addChip(int chips) {
		chipPile += chips;
	}

	
	public int getRoundScore() {
		return roundScore;
	}
	
	public void addRoundScore(int points) {
		roundScore += points;
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
}
