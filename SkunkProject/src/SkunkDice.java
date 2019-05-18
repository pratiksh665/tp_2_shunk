
public class SkunkDice extends Dice{

	public SkunkDice() {
		
	}
	

	public boolean isSkunk()
	{
		return (getDie1Value() == 1 || getDie2Value() == 1 && getDiceValue() != 2);
	}

	public boolean isDoubleSkunk() {
		return (getDiceValue() == 2);
	}
	
}
