import edu.princeton.cs.introcs.*;

public class Die
{
	private int lastRoll;
	private int[] programmedRoll; 
	public boolean isItARandomRoll; 
	private int arrayIndex;
	
	public Die()
	{
		this.isItARandomRoll = true;
	}

	public Die(int[] runTimeArgForProgrammedRollArray)
	{

		if (runTimeArgForProgrammedRollArray == null)
		{
			throw new NullPointerException("Empty Array Initialized");
		} 
		else 
		{
			this.isItARandomRoll = false;
			this.programmedRoll = runTimeArgForProgrammedRollArray;
			this.arrayIndex = 0;
		}
	}

	public int getLastRoll()
	{
		return this.lastRoll;
	}

	public void roll() 
	{
		if (isItARandomRoll == true)
		{
			this.lastRoll = (int) (Math.random() * 6 + 1);
		}
		
		else 
		{
			this.lastRoll = this.programmedRoll[arrayIndex];

			arrayIndex++;

			if (arrayIndex >= this.programmedRoll.length)
			{
				arrayIndex = 0; 
			}
		}
	}

	@Override
	public String toString() // this OVERRIDES the default Object.toString()
	{
		return "Die: " + this.getLastRoll();
	}

}
