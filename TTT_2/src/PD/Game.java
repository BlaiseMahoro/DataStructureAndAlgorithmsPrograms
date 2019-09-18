package PD;

import java.util.Scanner;

import PD.Player.Type;

public class Game {

	Player player1;
	Player player2;
	Board  currentBoard;	
	  
	public Game() {
		this.player1=new Player(Type.AI);
		this.player2=new Player(Type.Player);
	}
	
	public Game(Player player1, Player player2, Board currentBoard) {
		//super();
		this.player1 = player1;
		this.player2 = player2;
		this.currentBoard = currentBoard;
	}
	public Player getPlayer1() {
		return player1;
	}
	public void setPlayer1(Player player1) {
		this.player1 = player1;
	}
	public Player getPlayer2() {
		return player2;
	}
	public void setPlayer2(Player player2) {
		this.player2 = player2;
	}
	public Board getCurrentBoard() {
		return currentBoard;
	}
	public void setCurrentBoard(Board currentBoard) {
		this.currentBoard = currentBoard;
	}
	public boolean isComplete() {		
		
		return true;
	}
	

}
