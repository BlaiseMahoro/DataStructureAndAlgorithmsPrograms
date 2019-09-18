package DiceRollerPD;

public class DiceBag {
	//Attributes
	private int numberOfFaces;
    private int numberOfDice;
    private int total;
    private Die[] dice;
    
    //Constructors
    public DiceBag(int numberOfDice, int numberOfFaces){
    	this.numberOfDice = numberOfDice;
    	this.numberOfFaces = numberOfFaces;
    	dice = new Die[numberOfDice];
    	for(int i=0; i<numberOfDice; i++)
    		dice[i]= new Die(numberOfFaces);
    	total = 0;
    }
    
    //getters
    public int getNumberOfDice() {
    	return numberOfDice;
    }
    public int getNumberOfFaces() {
    	return numberOfFaces;
    }
    public int getTotal() {
    	return total;
    }
    public Die[] getDice() { 
    	return dice;
    }
    
    //Setters
    public void setNumberOfDice(int numberOfDice) {
    	this.numberOfDice =numberOfDice;
    }
    public void setNumberOfFaces(int numberOfFaces) {
    	this.numberOfFaces= numberOfFaces;
    }
    public void setTotal() {
    	this.total=0;
    	
    	for(Die die:dice) {
    		total+=die.getCurrentFace();
    	}
    	
    }
    //Operations
    public void roll() {
    	
    	for(int i=0; i<numberOfDice; i++) 
    		dice[i].roll();
    			
    }
    public void display() {
    	for(int i=0; i<numberOfDice; i++) {
    		
    	    System.out.print("Die "+(i+1)+": ");
    		System.out.println(dice[i].getCurrentFace());
    	}
    }
   
    
   
}
