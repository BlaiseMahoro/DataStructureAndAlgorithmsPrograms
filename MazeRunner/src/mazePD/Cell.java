package mazePD;

import mazePD.Maze.Content;

public class Cell{
	/**
	 * 
	 */
	private Coordinates coordinates;			// coordinates of this cell
	private Content cellContent;				// contents of this cell 
	boolean genVisit;				// has this cell be visited during generation
	private int moveFromX,moveFromY;			// cell moved from during creation
	
	public Cell(Coordinates coordinates, Content cellContents) {
		this.coordinates=coordinates;
		this.cellContent=cellContents;
		//genVisit=false;
		
	}
	
	public void setGenVisit(boolean genVisit) {
		this.genVisit=genVisit;
	}
	public Cell(Droid droid, int x, int y, int z, Content cellContent)
	{
		coordinates = new Coordinates(x,y,z);
		setCellContent(cellContent);
	}

	/**
	* getLocX() get x attribute
	* 
	* @return x  int x coordinate for a this cell location (0..maze dim-1)
	*/
	protected int getLocX() {
		return getCoordinates().getX();
	}

	/**
	* setX() set x attribute
	* 
	* @param  x  int x coordinate for this cell location (0..maze dim-1)
	*/
	protected void setLocX(int locX) {
		getCoordinates().setX(locX);
	}
	
	/**
	* getLocY() get y attribute
	* 
	* @return y  int y coordinate for a this cell location (0..maze dim-1)
	*/
	protected int getLocY() {
		return getCoordinates().getY();
	}

	/**
	* setY() set y attribute
	* 
	* @param  y  int y coordinate for this cell location (0..maze dim-1)
	*/
	protected void setLocY(int locY) {
		getCoordinates().setY(locY);;
	}

	/**
	* getLocZ() get z attribute
	* 
	* @return z  int z coordinate for this cell location (0..maze depth-1)
	*/
	protected int getLocZ() {
		return getCoordinates().getZ();
	}
	
	/**
	* setZ() set z attribute
	* 
	* @param  z  int z coordinate for this cell location (0..maze depth-1)
	*/
	protected void setLocZ(int locZ) {
		this.getCoordinates().setZ(locZ);
	}

	/**
	* getCellContent() get cell contents
	* 	EMPTY,BLOCK,PORTAL_DN,PORTAL_UP,COIN,END
	* 
	* @return Content - contents of this cell
	*/
	public Content getCellContent() {
		return cellContent;
	}
	
	/**
	* setCellContent() set cell contents
	* 	EMPTY,BLOCK,PORTAL_DN,PORTAL_UP,COIN,END
	* 
	* @param  Content - contents to set
	*/
	protected void setCellContent(Content cellContent) {
		this.cellContent = cellContent;
	}
	
	/**
	* canBeOccupied() based on the contents of the cell can a droid move to it
	* 
	* @return Boolean - true if the cell can be occupied and false if it can't
	*/
	protected boolean canBeOccupied() {
		
		if (getCellContent()==Content.EMPTY || getCellContent()==Content.COIN  || 
				getCellContent()==Content.PORTAL_DN ||
				getCellContent()==Content.PORTAL_UP || 
				getCellContent()==Content.END) return true;
		else return false;
	}
	
	/**
	* canBeStart() based on the contents of the cell can this cell be the start
	* cell for the level.  It can if it is EMPTY or COIN.
	* 
	* @return Boolean - true if the cell can be level start and false if it can't
	*/
	protected boolean canBeStart() {
		
		if (getCellContent()==Content.EMPTY || getCellContent()==Content.COIN ) return true;
		else return false;
	}

	/**
	* isGenVisit() has this cell been visit during the maze generation process
	* 
	* @return Boolean - true if the cell has been visit and false if it has not
	*/
	public boolean isGenVisit() {
		return genVisit;
	}

	
	protected int getMoveFromY() {
		return moveFromY;
	}

	protected void setMoveFromY(int moveFromY) {
		this.moveFromY = moveFromY;
	}

	protected int getMoveFromX() {
		return moveFromX;
	}

	protected void setMoveFromX(int moveFromX) {
		this.moveFromX = moveFromX;
	}
	
	protected void setMoveFrom(int x, int y){
		setMoveFromX(x);
		setMoveFromY(y);
	}	

	protected Coordinates getCoordinates() {
		return coordinates;
	}

	protected void setCoordinates(Coordinates coordinates) {
		this.coordinates = coordinates;
	}
	protected String locString()
	{
		return "["+new Integer(getLocX()).toString()+","+new Integer(getLocY()).toString()+","+
				new Integer(getLocZ()).toString()+"]";
	}

	public String toString()
	{
		switch(cellContent)
		{
		case EMPTY:
			return "[ ]";
		case BLOCK:
			return "[*]";
		case PORTAL_DN:
			return "[P]";
		case PORTAL_UP:
			return "[P]";
		case COIN:
			return "[C]";
		case END:
			return "[E]";
		default:
			return "[X]";
		}
	}

}