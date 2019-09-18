package DiceRollerUI;
import java.util.Scanner;
import DiceRollerTest.DiceBagTest;
import DiceRollerTest.DieTest;
public class DiceRollerUI {

	@SuppressWarnings("resource")
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		int numberOfDice, numberOfFaces;
		Scanner scan;
		scan = new Scanner(System.in);
		
		System.out.print("Enter the number of Dice: ");
		numberOfDice = scan.nextInt();
		System.out.print("Enter the number of Faces: ");
		numberOfFaces= scan.nextInt(); 
		
		DieTest.test();
		
		DiceBagTest.test(numberOfDice, numberOfFaces);

	}

}
