// -------------------------TP 1.2 changes--------------------------------------------------//
public class Turn
{

	private int turnScore;
	private Dice dice; // Turn talks to Dice
	private boolean isSkunk;
	private boolean isDoubleSkunk;

	public Turn()
	{
		dice = new Dice();
	}
	
	// -------TP 1.2 Junit hanges(added another constructor to turn class to add the preprogrammed dice-----------//
	public Turn(Dice dice) {
		this.dice = dice;
	}
	//--------------------------------------------------------------------------------------------------------------
	
	public void turnRoll()
	{
		dice.roll();

		if (dice.getDie1() == 1 || dice.getDie2() == 1 && dice.getLastRoll() != 2)
		{
			turnScore = 0;
			isSkunk = true;
		}

		else if (dice.getLastRoll() == 2)
		{
			turnScore = 0;
			isDoubleSkunk = true;
			// totalScore = 0;
		}

		else
		{
			turnScore += getDiceValue();
			isSkunk = false;
		}
	}
	
	
	public void programmedTurnRoll()
	{
		dice.roll();

		if (dice.getDie1() == 1 || dice.getDie2() == 1 && dice.getLastRoll() != 2)
		{
			turnScore = 0;
			isSkunk = true;
		}

		else if (dice.getLastRoll() == 2)
		{
			turnScore = 0;
			isSkunk = true;
			// totalScore = 0;
		}

		else
		{
			turnScore += dice.getLastRoll();
			isSkunk = false;
		}
	}
	
	
	public int getTurnScore()
	{
		return this.turnScore;
	}

	public boolean isSkunk()
	{
		return isSkunk;
	}

	public boolean isDoubleSkunk() {
		return isDoubleSkunk;
	}
	
	public int getDie1Value()
	{
		return dice.getDie1();
	}

	public int getDie2Value()
	{
		return dice.getDie2();
	}

	public int getDiceValue()
	{
		return getDie1Value() + getDie2Value();
	}

}
