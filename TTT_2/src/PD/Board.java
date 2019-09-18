package PD;

public class Board {
	private String board[][];
	private String mark; // 2:player1; 2:AI; X or O
	
	
	
	

	public Board() {
		board=new String [3][3];
	}
	
	public Board( String mark) {
	    this();
		
		this.mark = mark;
		for(int i=0; i<3;i++) {
			for(int j=0;j<3;j++) {
				board[i][j]="";
			}
		}
	}
	public Position evaluate() {
		GameTree gameTree=new GameTree(this);
		gameTree.generate();
		Position move=gameTree.getBestMoves();
		this.setMark("O");
		return move;
	}
	public Board clone() {
		Board copyBoard =new Board(this.mark);
		
		for(int i=0; i<3;i++) {
			for(int j=0; j<3;j++) {
				copyBoard.board[i][j]=this.board[i][j];
			}
		}
		return copyBoard;
	}
    public String getOppositeMark(String mark) {
    	if(mark=="X")
    		return "O";
    	else
    		return "X";
    }
    
	public String[][] getBoard() {
		return board;
	}
	public void setBoard(String[][] board) {
		this.board = board;
	}
	public void showTheWinner() {
		if(this.isWinner("O"))
				System.out.println("Player 1 won!");
		else if(this.isWinner("X"))
				System.out.println("Computer won!");
		else
			System.out.println("It's a draw!");
		}
	
	public String getMark() {
		return mark;
	}
	public void setMark(String player) {
		this.mark = player;
	}
	public boolean isFull() {
		for(int i=0; i<3; i++) {
			for(int j=0;j<3;j++) {
				if(board[i][j]=="") {
					return false;
				}
			}
		}
		return true;
	}
	public boolean isWinner(String playerMark) {

        if ((board[0][0] == board[1][1] && board[0][0] == board[2][2] && board[0][0] == playerMark) || (board[0][2] == board[1][1] && board[0][2] == board[2][0] && board[0][2] == playerMark)) {
            // System.out.println("O Diagonal Win");
            return true;
        }
        for (int i = 0; i < 3; ++i) 
        {
            if ((board[i][0] == board[i][1] && board[i][0] == board[i][2] && board[i][0] == playerMark)
                    || (board[0][i] == board[1][i] && board[0][i] == board[2][i] && board[0][i] == playerMark)) {
                //  System.out.println("O Row or Column win");
                return true;
            }
		
	}
        return false;
        }
	
	public boolean gameOver() { 
		return(this.isFull()||this.isWinner("X")||this.isWinner("O"));
	}
	
	public void play(int i, int j,String mark) {
		if(board[i][j]!="")
			System.out.println("location taken");
		else {
			board[i][j]=mark;
			if(mark=="X") {
				this.mark="O";
			}
			else
			this.mark="X";
			}
	}
		
	public void displayBoard() {
		 System.out.println();
		 System.out.println(toString());
		
	}
	public String toString() {
		StringBuilder sb= new StringBuilder();
		for (int i = 0; i < 3; ++i) 
		 {
		     for (int j = 0; j < 3; ++j) {
		    	 switch(board[i][j]) {
		    	 case "X":  sb.append("X");break;
		    	 case "O": sb.append("O");break;
		    	 case "":  sb.append(" ");break;
		    	 }
		    	 if(j<2)sb.append("|");
		     }
		     if(i<2) sb.append("\n-----\n");
		 }
		return sb.toString();
	}
	
	
	
}
