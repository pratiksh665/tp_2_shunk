
public class Dice

{
	private boolean isSkunk;
	private boolean isDoubleSkunk;
	private Die die1; //Dice talks to Die
	private Die die2; //Dice talks to Die

	public Dice()
	{
		// initialize instance variables die1 and die2 by
		// creating a new instance of each

		this.die1 = new Die();
		this.die2 = new Die();
	}

//	public Dice(int[] programmableroll)
//	{
//		//int[] programmableroll= programmableroll;
//		this.die1 = new Die(programmableroll);
//		this.die1 = new Die(programmableroll);
//		
//	}
	
	public Dice(Die die1, Die die2) // overloaded constructor
	{
		this.die1 = die1;
		this.die2 = die2;
	}
	
	public int getDie1() {
		return die1.getLastRoll();
	}

	
	public int getDie2() {
		return die2.getLastRoll();
	}
	// Instance methods can also be declared anywhere
	// Convention: after constructors

	public void roll(Player player)
	{
		// roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value
		die1.roll();
		die2.roll();
		
		
		if (die1.getLastRoll() == 1 || die2.getLastRoll() == 1 && getDiceValue() != 2)
		{
			player.turnScore = 0;
			isSkunk = true;
		}

		else if (getDiceValue() == 2)
		{
			player.turnScore = 0;
			isDoubleSkunk = true;
		}

		else
		{
			player.turnScore += getDiceValue();
			isSkunk = false;
		}
	}
	

	public boolean isSkunk()
	{
		return isSkunk;
	}

	public boolean isDoubleSkunk() {
		return isDoubleSkunk;
	}
	
	public int getDiceValue()
	{
		return die1.getLastRoll() + die2.getLastRoll();
	}
	
//	public void roll(int[] programmableroll)
//	{
//		// roll each of die1, die2, sum their last rolls,
//		// then set Dice.lastRoll to this value
//		die1.roll(programmableroll);
//		die2.roll(programmableroll);
//		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
//	}
	

}
