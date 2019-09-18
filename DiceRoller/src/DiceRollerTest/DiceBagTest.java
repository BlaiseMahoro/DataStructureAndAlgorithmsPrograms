package DiceRollerTest;
import DiceRollerPD.*;
public class DiceBagTest {
	
	public static void test(int numberOfDice, int numberOfFaces) {
		DiceBag dice;
		dice = new DiceBag(numberOfDice, numberOfFaces);
		dice.roll();
	   dice.display();
	   
	   dice.setTotal();
	   System.out.println("Total= "+dice.getTotal());
	   System.out.println("----------------------------------------------------------------------------------");
	   displayFrequency(dice);
	}
	public static void displayFrequency(DiceBag dice)
	{
		int[] num;
		num = new int[dice.getNumberOfDice()];
	
		int count;
		for(int i=0; i<dice.getDice().length;i++)
		{
			if(!isContained(num, dice.getDice()[i].getCurrentFace()))
			{
				count =0;
			    for(int j=i; j<dice.getDice().length; j++)
			    {
			    	if(dice.getDice()[i].getCurrentFace() == dice.getDice()[j].getCurrentFace())
			    	{
					   count++;
					   num[i] = dice.getDice()[i].getCurrentFace();
					}
				
			}
			
				System.out.println(dice.getDice()[i].getCurrentFace()+"-"+count);
			}
			
		}
			
	}
	public static boolean isContained(int [] num, int diceNum )
	{
		boolean status = false;
		for(int i=0; i<num.length&&!status;i++)
		{
			if(diceNum== num[i])
				status=true;
		}
		return status;
	}
	

}
