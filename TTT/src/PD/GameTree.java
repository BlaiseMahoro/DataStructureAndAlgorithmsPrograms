package PD;

public class GameTree {

	Node<Board> root=null;

	
	
	public GameTree(Board board) {
		root=new Node<Board>(board.clone());
	
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node<Board> root) {
		this.root = root;
	}
	public Position getBestMoves()
	{
		Position move;
		move= new Position();
		int max=Integer.MIN_VALUE;
		Node<Board> node=root;
		for(Node<Board> nodeItem:node.getChildren()){
			int score=nodeItem.score(nodeItem.getBoard().getOppositeMark(nodeItem.getBoard().getMark()));
			if(score>max) {
				max=score;
				move.x=nodeItem.lastMove[0];
				move.y=nodeItem.lastMove[1];
				
			}
			
		}
		return move;
	}
	
	public void generate() {
	
		generateTree(root);
	}
	public void generateTree(Node<Board> node) {
		if(node.getBoard().gameOver())
			return;
		else {
			Board board; 
			
			for(int i=0; i<3;i++) {
				for(int j=0; j<3; j++) {
					if(node.getBoard().getBoard()[i][j]=="") {
						board=node.getBoard().clone();
						board.play(i, j, board.getMark());
						//board.displayBoard();
						Node newNode=new Node<Board>(board, node);
						newNode.lastMove[0]=i;
						newNode.lastMove[1]=j;
						node.addChild(newNode);
						generateTree(newNode);
					}
					
				}
					
			}
		}
		
	}
}
