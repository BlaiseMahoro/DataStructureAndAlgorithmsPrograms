package DiceRollerTest_2;
import java.awt.Color; 
import DiceRollerPD_2.*;
import DiceRollerTest_2.*;
import DiceRollerUI_2.DiceRollerUIPanel;
@SuppressWarnings("unused")

/**
 * DiceBagTest tries to initialize the dice bag and handles all possible exceptions.
 * 
 * @author Blaise Mahoro
 *
 */
public class DiceBagTest
{

	private static DiceBag bag;
	public static void Test(int numberOfDice, int numberOfFaces)
	{
		try
		{
			
			bag = new DiceBag(numberOfDice, numberOfFaces);
		}
		catch (NumberOfFacesRangeException exception)
		{
			 String errorMessage = exception.getMessage();
			 System.out.println(errorMessage);
			 DiceRollerUIPanel.errorMessageLabel.setText(errorMessage);
			 	
			 DiceRollerUIPanel.totalLabel.setText ("Total : 0");
			 DiceRollerUIPanel.numberList.setText("");
			return;
		}
		catch (NumberOfDiceRangeException exception)
		{
			String errorMessage = exception.getMessage();
			System.out.println(errorMessage);
			DiceRollerUIPanel.errorMessageLabel.setText(errorMessage);
			
			DiceRollerUIPanel.totalLabel.setText ("Total: 0");
			DiceRollerUIPanel.numberList.setText("");
			//System.out.println("Total = Error");
			return;
		}
		DiceRollerUIPanel.totalLabel.setText("Total:"+  bag.roll());
		DiceRollerUIPanel.errorMessageLabel.setText("");
		String r ="";
		for(int i=0; i<bag.getDice().length; i++)
		{
			System.out.println(bag.getDice()[i].toString());
			r+=bag.getDice()[i].toString();
			
		}
		DiceRollerUIPanel.numberList.setText(r);
		


	}
   
}
