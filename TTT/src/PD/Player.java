package PD;

import java.util.Scanner;


public class Player {
	//X: AI
	//O:Player
	public enum Type{Player, AI}
	private String name;
	private Type type;
	private String mark;
	private int playerNum;
		
	
	public Player(Type playerType){
		type =playerType;
		
		
	}
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Type getType() {
		return type;
	}


	public void setType(Type type) {
		this.type = type;
	}


	public int getPlayerNum() {
		return playerNum;
	}


	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

		
	

}
