
public class Dice

{
	private Die die1; //Dice talks to Die
	private Die die2; //Dice talks to Die

	public Dice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

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
	
	public int getDie1() {
		return die1.getLastRoll();
	}

	
	public int getDie2() {
		return die2.getLastRoll();
	}

	
	public int getDiceValue()
	{
		return die1.getLastRoll() + die2.getLastRoll();
	}
	
}
