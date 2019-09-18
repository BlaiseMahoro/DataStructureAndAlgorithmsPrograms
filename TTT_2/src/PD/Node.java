package PD;

import java.util.ArrayList;
import java.util.List;

public class Node<T> {
	private List<Node<T>> children = new ArrayList<Node<T>>();
	protected int score;
	protected int lastMove[];
	private Node<T> parent = null;
	private Board board;

	public Node() {
		this.lastMove = new int[2];
		this.board = null;
	}

	public Node(Board board) {
		this();
		this.board = board;
	}

	public Node(Board board, Node<T> parent) {
		this();
		this.board = board;

		this.parent = parent;

	}

	public int score(String mark) {
		
		if(board.isWinner(mark))
			return 1;
		else if(board.isWinner(board.getOppositeMark(mark)))
			return -1;
		else if(board.isFull())
			return 0;
		else{
			if (this.board.getMark().equals(mark)) {
		
			int max = Integer.MIN_VALUE;
			for (Node<T> node : getChildren()) {
				int score = node.score(mark);
				if (score > max) {
					max = score;
				}
			}
			return max;
		} else {
			int min = Integer.MAX_VALUE;
			for (Node<T> node : getChildren()) {
				int score = node.score(mark);
				if (score < min) {
					min = score;
				}
			}
			return min;
		}
		}
		
	}

	public List<Node<T>> getChildren() {
		return children;
	}

	public void setParent(Node<T> parent) {
		this.parent = parent;
	}

	public Node<T> getParent() {
		return this.parent;
	}

	public void addChild(Node<T> child) {
		child.setParent(this);
		this.children.add(child);
	}

	public Board getBoard() {
		return this.board;
	}

	public void setBoard(Board board) {
		this.board = board;
	}

	public boolean isRoot() {
		return (this.parent == null);
	}

	public int size() {
		int total = 1;
		for (Node<T> n : children) {
			total += n.size();
		}
		return total;
	}

	public boolean isLeaf() {
		if (this.children.size() == 0)
			return true;
		else
			return false;
	}

	public void removeParent() {
		this.parent = null;
	}
}