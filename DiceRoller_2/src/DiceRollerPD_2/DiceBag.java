package DiceRollerPD_2;

/**
* DiceBag is a Class that represents a collection of Die 
* that have the same number of faces.
* 
* 
* @author Blaise Mahoro 
*/

public class DiceBag 
{
	//Attributes
	private int numberOfFaces;
    private int numberOfDice;
    private int total;
    private Die[] dice;
    
    //Constructors
    /**
    * DiceBag constructor calls setNumberOfDice to initializes the number of dice.
    * and calls Die constructor to initialize each die
    * @param numberOfDice for the number of dice in the bag.
    * @param numberOfFaces for the number of faces on each die.
    * @throws  NumberOfFacesRangeException
    * -if the number of faces is less than 0
    * @throws  NumberOfDiceRangeException
    * -if the number of Dice is less than 0.
    *
    * @author(Blaise Mahoro) 
    */
    public DiceBag(int numberOfDice, int numberOfFaces) throws NumberOfFacesRangeException,
    NumberOfDiceRangeException   
    {
    	setNumberOfDice(numberOfDice);
    	
    	dice = new Die[this.numberOfDice];
    	for(int i=0; i<this.numberOfDice; i++)
    		dice[i]= new Die(numberOfFaces);
    	total = 0;
    }
    
    //getters
    /**
     * getNumberOfDice returns the number of Dice.
     * 
     * @return numberOfDice
     */
    public int getNumberOfDice() 
    {
    	return numberOfDice;
    }
    /**
     * getNumberOfFaces returns the number of faces
     * @return numberOfFaces
     */
    public int getNumberOfFaces() 
    {
    	return numberOfFaces;
    }
    /**
     * getTotal returns the total of all faces rolled.
     * @return total
     */
    public int getTotal()
    {
    	return total;
    }
    /**
     * getDice returns all dice in form of an array
     * @return dice
     */
    public Die[] getDice()
    { 
    	return dice;
    }
    
    //Setters
    /**
     * setNumberOfDice sets the number of Dice.
     * @param numberOfDice for the number of Dice
     * @throws NumberOfDiceRangeException
     * -if the number of Dice is less than 0.
     */
    public void setNumberOfDice(int numberOfDice) throws NumberOfDiceRangeException
    {
    	if(numberOfDice > 0)
    		this.numberOfDice =numberOfDice;
    	else
    		throw new NumberOfDiceRangeException("Error! Enter a number of Dice greater than 0.");
    }
    /**
     * setTotal goes through the array of dice, calculates and sets the total.
     */
    public void setTotal()
    {
    	this.total=0;
    	for(int i=0; i<numberOfDice; i++) {
    		 this.total+=dice[i].getCurrentFace();
    	}
    	
    }
    //Operations
    /**
     * roll: goes through the array of Dice and rolls each die . It also calculates the 
     * total.
     * @return total
     */
    public int roll() 
    {
    	
    	for(int i=0; i<numberOfDice; i++) 
    		dice[i].roll();
    		
    	setTotal();
    	return getTotal();
    }
    
   
    
   
}
