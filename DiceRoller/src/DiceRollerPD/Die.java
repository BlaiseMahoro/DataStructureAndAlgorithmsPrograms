package DiceRollerPD;
import java.util.Random;
public class Die {
	//Attributes
    private int numberOfFaces;
    private int currentFace;
    private int randomGen;
    //Constructor
    public Die(int numberOfFaces) {
    	this.numberOfFaces= numberOfFaces;
    
    }
    
    //getters
   
    public int getNumberOfFaces() {
    	return numberOfFaces;
    }
    public int getCurrentFace() {
    	return currentFace;
    }
    
    //Setters
    public void setNumberOfFaces(int numberOfFaces) {
    	this.numberOfFaces = numberOfFaces;
    }
    
    private void setCurrentFace(int currentFace){
    	this.currentFace= currentFace;
    }
    
    //Operations
    private Random getRandomGen() {
    	Random random= new Random();
    	
    	return random;
    }
    public void roll() {
    	Random gen = getRandomGen();
    	
    	this.randomGen = gen.nextInt(numberOfFaces)+1;
    	setCurrentFace(randomGen);
    }
    public String toString() {
    	return""+getCurrentFace() ;
    }
}
