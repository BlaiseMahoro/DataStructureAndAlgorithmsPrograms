package mazePD;




import mazePD.Maze.Content;
import mazePD.Maze.Direction;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Random;
import java.util.Stack;

import javax.swing.SwingUtilities;
public class Droid implements DroidInterface{
	private String name;                             //name of the Droid
	private Maze maze;								//maze I am moving on
	Cell [][][] cells;	
	//cells that I have seen before
	
	Stack<Cell> pathStack;
	ArrayList<Cell> path;
	Random randomNum;
	private  Stack<Direction> lastDirections;
	private ArrayList<ActionListener> actionListeners;
	
	//Droid class methods
	public Droid(String name, Maze maze){
		this.maze=maze;
		this.name = name;
		randomNum= new Random();
	    pathStack=new Stack<Cell>();
	    lastDirections=new Stack<Direction>();
	    cells= new Cell[maze.mazeDepth][maze.mazeDim][maze.mazeDim];	
	    //path=new ArrayList();
	    actionListeners=new ArrayList();
	    
	}
	
	public String getName() {
	return name;
		
	}
	public Coordinates enterMaze() {
		return maze.enterMaze(this);
	}
	public Content[] scanAdjLoc() {
		return maze.scanAdjLoc(this);
	}
	
	public Coordinates getCurrentLoc() {
		return maze.getCurrentCoordinates(this);
		
	}	
	
	public Content getCurrentCellContent() {
		return maze.scanCurLoc(this);
	}
	public Coordinates usePortal(Direction direction) {
		return maze.usePortal(this,direction);
	}
	public int getMazeDepth() {
		return maze.getMazeDepth();
	}
	public int getMazeDim() {
		return maze.getMazeDim();
	}
	public boolean isOnPath(Cell cell) {
		return pathStack.contains(cell);
		
		
	}
	public void run() {
		Coordinates currentCoord=this.enterMaze();
		Cell nextLoc,removedLoc;
		Direction lastDirection;
		//Coordinates  realCurLoc;
		Cell currentLoc=new Cell(currentCoord,this.getCurrentCellContent());
		pathStack.push(currentLoc);
		System.out.println(pathStack.peek().locString());
		//int count=0;
		while(!pathStack.isEmpty()&&pathStack.peek().getCellContent()!=Content.END) {
			//realCurLoc=this.getCurrentLoc();
			this.notifyListeners();
			currentLoc=pathStack.peek();
			currentLoc.setGenVisit(true);
			cells[currentLoc.getLocZ()][currentLoc.getLocX()][currentLoc.getLocY()]=currentLoc;
			nextLoc=move();
			if(nextLoc==null) {
				removedLoc=pathStack.pop();
				//removedLoc.setGenVisit(false);
				lastDirection=lastDirections.pop();
				if(lastDirection==Direction.DN) {
					maze.move(this, Direction.UP);
				}
				else if(lastDirection==Direction.D00) {
					maze.move(this, Direction.D180);
				}
				else if(lastDirection==Direction.D180) {
					maze.move(this, Direction.D00);
				}
				else if(lastDirection==Direction.D90) {
					maze.move(this, Direction.D270);
				}
				else if(lastDirection==Direction.D270) {
					maze.move(this, Direction.D90);
				}
			
				//cells[removedLoc.getLocz()][removedLoc.getLocx()][removedLoc.getLocy()].setGenVisit(false);
				/*if(removedLoc.getLocY()==currentLoc.getLocY())
				{
					if(removedLoc.getLocX()>currentLoc.getLocX())
						currentCoord=maze.move(this,Direction.D270);
					else
						currentCoord=maze.move(this,Direction.D90);
					
				}
				if(removedLoc.getLocX()==currentLoc.getLocX()){
					if(removedLoc.getLocY()>currentLoc.getLocY())
						currentCoord=maze.move(this, Direction.D00);
					else
						currentCoord=maze.move(this, Direction.D180);
						
				}*/
			}
			else {
				pathStack.push(nextLoc);
			}
			System.out.println(pathStack.peek().locString());
			try {
				Thread.sleep(300);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
		/*while(!path.isEmpty())
		{
			path.add(pathStack.pop());
		}
		
		for (int z = getMazeDepth()-1; z >= 0;z--) 
		{
			System.out.println("");
			System.out.println("");
			for (int x = 0; x <getMazeDim(); x++) {
				System.out.println("");
				for (int y = 0;y<getMazeDim(); y++) {
					if(cells[z][x][y]==null) {
						System.out.print("[X]");
					}
					/*else if(pathStack.search(cells[z][x][y])!=-1) {					
				
						System.out.print("[0]");
					
					}
					else
						System.out.print(cells[z][x][y].toString());
				}
			}
		}*/
		
		
			
		
  }
	
	public void updateMem(Content[] adjContent) {
		if(this.getCurrentLoc().y>0) 
		if(cells[this.getCurrentLoc().z][this.getCurrentLoc().x][this.getCurrentLoc().y-1]==null)  
		//D00 or front
			cells[this.getCurrentLoc().z][this.getCurrentLoc().x][this.getCurrentLoc().y-1]=new Cell(new Coordinates(getCurrentLoc().x,(getCurrentLoc().y-1),getCurrentLoc().z), adjContent[0]);
		
		//D90 or right
		if(this.getCurrentLoc().x+1<maze.mazeDim)
			if(cells[this.getCurrentLoc().z][this.getCurrentLoc().x+1][this.getCurrentLoc().y]==null)
				cells[this.getCurrentLoc().z][this.getCurrentLoc().x+1][this.getCurrentLoc().y]=new Cell(new Coordinates(getCurrentLoc().x+1,(getCurrentLoc().y),getCurrentLoc().z), adjContent[1]);
		//D180 or behind
		if(this.getCurrentLoc().y+1<maze.mazeDim)
			if(cells[this.getCurrentLoc().z][this.getCurrentLoc().x][this.getCurrentLoc().y+1]==null)
				cells[this.getCurrentLoc().z][this.getCurrentLoc().x][this.getCurrentLoc().y+1]=new Cell(new Coordinates(getCurrentLoc().x,(getCurrentLoc().y+1),getCurrentLoc().z), adjContent[2]);
		//D270 or left
		if(this.getCurrentLoc().x>0)
			if(cells[this.getCurrentLoc().z][this.getCurrentLoc().x-1][this.getCurrentLoc().y]==null) 
				cells[this.getCurrentLoc().z][this.getCurrentLoc().x-1][this.getCurrentLoc().y]=new Cell(new Coordinates(getCurrentLoc().x-1,(getCurrentLoc().y),getCurrentLoc().z), adjContent[3]);
		
	}
	public Cell move() {
		//Content c1=maze.scanCurLoc(this);
		if(maze.scanCurLoc(this)==Content.PORTAL_DN ) {
			lastDirections.push(Direction.DN);
			return new Cell(maze.usePortal(this,Direction.DN),Content.PORTAL_DN);
		}
		else {
		Content  adjContent [];
		adjContent=this.scanAdjLoc();
		updateMem(adjContent);
				
		if(this.getCurrentLoc().y>0) {				
				if(!cells[this.getCurrentLoc().z][this.getCurrentLoc().x][this.getCurrentLoc().y-1].genVisit&&
						adjContent[0]!=Content.BLOCK) {
					lastDirections.push(Direction.D00);
					
						return new Cell(maze.move(this, Direction.D00),adjContent[0]);
				}
			}
		     if(this.getCurrentLoc().x+1<maze.mazeDim) {
				if(adjContent[1]!=Content.BLOCK&&!cells[this.getCurrentLoc().z][this.getCurrentLoc().x+1][this.getCurrentLoc().y].genVisit) {
					    lastDirections.push(Direction.D90);
						return new Cell(maze.move(this, Direction.D90), adjContent[1]);
				}
		    }
		    if(this.getCurrentLoc().y+1<maze.mazeDim){
				 if(adjContent[2]!=Content.BLOCK&&!cells[this.getCurrentLoc().z][this.getCurrentLoc().x][this.getCurrentLoc().y+1].genVisit) {
					 lastDirections.push(Direction.D180);
						return new Cell(maze.move(this, Direction.D180),adjContent[2]);
				}
		    }
		    if(this.getCurrentLoc().x>0) {
						if(adjContent[3]!=Content.BLOCK&&
						!cells[this.getCurrentLoc().z][this.getCurrentLoc().x-1][this.getCurrentLoc().y].genVisit) {
							lastDirections.push(Direction.D270);
						return new Cell(maze.move(this, Direction.D270), adjContent[3]);
				}
		    }
			}
		
		
		return null;
	
		
	}
	public void addActionListener(ActionListener actionListener)
	{
		actionListeners.add(actionListener);
	}
	public void notifyListeners()
	{
	  for (ActionListener actionListener : actionListeners)
	  {	
		  SwingUtilities.invokeLater(new Runnable() {
	  
		   public void run() {
		      actionListener.actionPerformed(new ActionEvent(this,0,""));
	      }
	});
	}
	
	}

	public Cell[][][] getCells() {
		// TODO Auto-generated method stub
		return cells;
	}
}



