import edu.princeton.cs.introcs.*;

public class Die
{
	private int lastRoll;

	// -------------------------TP 1.1 changes--------------------------------------------------//
	private int[] programmedRoll; // stores user input of preProgrammedDieRolls
	private boolean isItARandomRoll; // controls alternative execution of the roll method
	private int arrayIndex;
	
	// -------------------------TP 1.1 changes--------------------------------------------------//
	public Die()
	{
		this.isItARandomRoll = true;
		// this.roll(); // executes the roll method
	}

	// -------------------------TP 1.1 changes--------------------------------------------------//
	// TP 1.1
	// Step8: modifying Die to allow it to be initialized with a sequence of
	// "pre-programmed"
	// die values returned by repeatedly rolling such a "loaded" die.

	public Die(int[] runTimeArgForProgrammedRollArray)
	{

		if (runTimeArgForProgrammedRollArray == null)
		{
			// creating an instance and throwing it instead calling a method.
			throw new NullPointerException("Empty Array Initialized");
		} else // if runTimeArgForProgrammedRollArray == null
		{
			this.isItARandomRoll = false;
			this.programmedRoll = runTimeArgForProgrammedRollArray;
			this.arrayIndex = 0;
			// this.roll();
		}
	}
	// -------------------------TP 1.1 changes--------------------------------------------------//

	public int getLastRoll() // getter or accessor method
	{
		return this.lastRoll;
	}

	public void roll() // note how this changes Die's state, but doesn't return anything
	{
		if (isItARandomRoll == true)
		{
			this.lastRoll = (int) (Math.random() * 40 + 1);
		}
		// -------------------------TP 1.1
		// changes--------------------------------------------------//
		else // if isItARandomRoll == false
		{

			this.lastRoll = this.programmedRoll[arrayIndex];
			// System.out.println("Programmed roll's value: " + lastRoll);

			arrayIndex++;

			if (arrayIndex >= this.programmedRoll.length)
			{
				arrayIndex = 0; // reset the array index variable
			}
		}

		// -------------------------TP 1.1
		// changes--------------------------------------------------//
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
