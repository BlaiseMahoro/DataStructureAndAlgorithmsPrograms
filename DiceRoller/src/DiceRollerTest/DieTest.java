package DiceRollerTest;
import DiceRollerPD.Die;
public class DieTest {

	public static void test() {
		// TODO Auto-generated method stub
		Die die;
		die =new Die(6);
		
		
		//Roll dice
		for(int i= 0; i<5;i++)
		{
		   die.roll();
		   if(checkRange(die)) 			  
			  System.out.println(die.toString()+"-OK");
		}	
	     	


	}
	public static boolean checkRange(Die die)
	{
		boolean status = false;
		if(die.getCurrentFace()> 0 && die.getCurrentFace()<die.getNumberOfFaces())
			status = true;
		
		return status;
	}

}
