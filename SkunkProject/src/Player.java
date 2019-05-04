import edu.princeton.cs.introcs.StdOut;

public class Player {

	public int playerScore; //uninitialized value is zero
	public String name; //uninitialized value is null
//	public boolean hundred; //uninitialized value is false
	public int chip; //uninitialized value is zero

	
	public Player () {
		
	}
	
	public Player (String name) {
		this.name = name;
		this.chip = 50;
	}
	
	
	public int getChip() {
		return chip;
	}
	
	public void chipPenalty(int subChip) {
		chip = chip - subChip;
	}
	
	public int getScore() {
		return playerScore;
	}
	
	public void setScore(int score) {
		playerScore += score;
	}

}
