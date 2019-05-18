
public class Dice

{
	private Die die1; 
	private Die die2; 
	
	public Dice()
	{
		this.die1 = new Die();
		this.die2 = new Die();
	}

	public Dice(int[] programmedRolls)
	{
		int[] programmableroll = programmedRolls;
		this.die1 = new Die(programmableroll);
		this.die1 = new Die(programmableroll);
		
	}
	
	public Dice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
	}
	
	public void roll() {
		die1.roll();
		die2.roll();
	}
	
	public int getDie1Value() {
		return die1.getLastRoll();
	}

	
	public int getDie2Value() {
		return die2.getLastRoll();
	}
	
	public int getDiceValue()
	{
		return die1.getLastRoll() + die2.getLastRoll();
	}

	public int getLastRoll() {
		return die1.getLastRoll() + die2.getLastRoll();
	}

}
