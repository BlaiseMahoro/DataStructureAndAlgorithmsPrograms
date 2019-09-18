package UI;

import java.util.Scanner;

import PD.*;
import PD.Player.Type;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scan=new Scanner(System.in);
		int x,y;
		
		Board board=new Board("O");
		while(!board.gameOver()) {
			//board.displayBoard();
			if(board.getMark()=="O") {
				 System.out.println("Enter a position(0-3):");
				 System.out.print("x: ");
				 x=scan.nextInt();
				 System.out.print("y: ");
				 y=scan.nextInt();
				board.play(x, y, "O");
				
			}
			else 
			{
				Position move=board.evaluate();
				
				board.play(move.x, move.y, "X");
				
				//System.out.println(""+move[0]+" " +move[1]);
				
			}
			board.displayBoard();
			
		}
		board.showTheWinner();
	}

}
