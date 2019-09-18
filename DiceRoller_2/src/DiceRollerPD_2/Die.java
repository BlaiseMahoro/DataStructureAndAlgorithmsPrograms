package DiceRollerPD_2;
import java.util.Random;

/**
 * Die is a class that represents one die. 
 * @author Blaise Mahoro
 *
 */
public class Die {
	//Attributes
    private int numberOfFaces;
    private int currentFace;
    private  int randomGen;
    //Constructor
    /**
     * Die is a constructor that initializes the number of faces 
      * by calling setNumberOfFaces.
     * @param numberOfFaces for the number of faces
     * @throws NumberOfFacesRangeException
     * -if the number of faces is less than o.
     */
    public Die(int numberOfFaces) throws NumberOfFacesRangeException 
    {
    	
    	this.setNumberOfFaces(numberOfFaces);
    	
    }
    
    //getters
   /**
    * getNumberOfFaces returns the number of faces
    * @return numberOfFaces
    */
    public int getNumberOfFaces() {
    	return numberOfFaces;
    }
    /**
     * getCurrentFace returns the number of faces
     * @return currentFace
     */
    public int getCurrentFace() {
    	return currentFace;
    }
    
    //Setters
    /**
     * setNumberOfFaces initializes the number of faces
     * @param numberOfFaces
     * @throws NumberOfFacesRangeException- if numberOfFaces is less than 0.
     */
    private void setNumberOfFaces(int numberOfFaces) throws NumberOfFacesRangeException 
    {
    	if(numberOfFaces > 0)
    		this.numberOfFaces = numberOfFaces;
    	else
    		throw new NumberOfFacesRangeException("Error! Enter a number of faces greater than 0.") ;
    }
    /**
     * setCurrentFace initializes the current face
     * @param currentFace
     */
    private void setCurrentFace(int currentFace)
    {
    	this.currentFace= currentFace;
    }
    
    //Operations
    /**
     * getRandom generates a random generator.
     * @return random
     */
    public static Random getRandomGen() {
    	Random random= new Random();
    	
    	return random;
    }
    /**
     * roll uses the random number generator to initialize the current face.
     */
    public void roll() {
    	Random gen = getRandomGen();
    	while(gen == null)
    	{
    		gen = getRandomGen();
    	}
    	
    	this.randomGen = gen.nextInt(numberOfFaces)+1;
    	setCurrentFace(randomGen);
    	
    }
    
    public String toString() {
    	return ""+ getCurrentFace()+" " ;
    }
}

