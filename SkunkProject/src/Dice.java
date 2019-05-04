/**
 * Dice represents a single pair of rollable Die objects, randomly generating
 * sums of their two values
 * 
 * This is a Javadoc comment: add more to your finished class below
 * 
 * @author eric
 *
 */

public class Dice
{
	// Instance fields (variables) may be declared anywhere in class body
	// Convention: put at top

	private int lastRoll;
	private Die die1; //Dice talks to Die
	private Die die2; //Dice talks to Die

	// Constructors (object initializers) also can be declared anywhere
	// Convention: after instance fields/variables

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

	// Instance methods can also be declared anywhere
	// Convention: after constructors

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public int getDie1()
	{
		return die1.getDie1();
	}

	public int getDie2()
	{
		return die2.getDie2();
	}

	public void roll()
	{
		// roll each of die1, die2, sum their last rolls,
		// then set Dice.lastRoll to this value
		die1.roll();
		die2.roll();
		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
	}
	
//	public void roll(int[] programmableroll)
//	{
//		// roll each of die1, die2, sum their last rolls,
//		// then set Dice.lastRoll to this value
//		die1.roll(programmableroll);
//		die2.roll(programmableroll);
//		this.lastRoll = die1.getLastRoll() + die2.getLastRoll();
//	}
	
	

	// the following method converts the internals of
	// this Dice object, and returns a descriptive String:
	//
	// Roll of 7 => 4 + 3
	//

	public String toString()
	{
		return "Dice with last roll: " + getLastRoll() + " => " + die1.getLastRoll() + " + " + die2.getLastRoll();
	}

	// static methods can go anywhere - but at end is standard
}
