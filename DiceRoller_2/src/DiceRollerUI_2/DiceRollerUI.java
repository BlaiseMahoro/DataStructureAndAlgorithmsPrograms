package DiceRollerUI_2;
import java.awt.Color;

import javax.swing.JFrame;
/**
 * DiceRollerUI starts the program and is where the frame is initialized.
 * @author Blaise Mahoro
 *
 */
public class DiceRollerUI 
{

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		/*int numberOfDice, numberOfFaces;
		Scanner scan;
		scan = new Scanner(System.in);
		
		System.out.print("Enter the number of Dice: ");
		numberOfDice = scan.nextInt();
		System.out.print("Enter the number of Faces: ");
		numberOfFaces= scan.nextInt(); */
		//DiceRollerTest_2.DiceBagTest.Test(numberOfDice, numberOfFaces);
		
		JFrame frame = new JFrame("Dice Roller");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		DiceRollerUIPanel panel = new DiceRollerUIPanel();
		panel.setBackground(Color.CYAN);
		frame.getContentPane().add(panel);
		
		frame.pack();
		frame.setVisible(true);


	}

}
