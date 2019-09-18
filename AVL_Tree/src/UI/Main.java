package UI;

import java.io.*;
import java.util.Scanner;

import PD.AVLTree;

public class Main {

	public static void main(String[] args) throws FileNotFoundException{
		AVLTree avltree = new AVLTree();
		//Scanner file = new Scanner(new File("AVL Tree Data Test Cases_CSV.csv"));
		String fileName="AVL Tree Data Test Cases_CSV.csv";
	    String line;
		 try 
		    {
		        // FileReader reads text files in the default encoding.
		        FileReader fileReader = 
		            new FileReader(fileName);

		        // Always wrap FileReader in BufferedReader.
		        BufferedReader bufferedReader = 
		            new BufferedReader(fileReader);
		        while((line = bufferedReader.readLine()) != null) 
		        {
		        	if(line.equals(" ")||line.isEmpty()) break;
		        	String token[]=line.split(",");
		        	int key=Integer.parseInt(token[0]);
		        	String value= token[1];
		        	avltree.insert(value, key);
		        	
		        }
		        bufferedReader.close();
		}
		
		 
		    catch(FileNotFoundException ex) 
		    {
		      System.out.println( "Unable to open file '" +  fileName + "'");                
		    }
		    catch(IOException ex) 
		    {
		       System.out.println (  "Error reading file '" + fileName + "'");   	
		     }
		   
	
		
		//TEST
		
		System.out.println("Preorder traversal: ");
			avltree.preorder();
		System.out.println("\n\nPostorder traversal: ");
			avltree.postorder();
		System.out.println("\n\nInorder traversal: ");
			avltree.inorder();
	
		
	}
	
	

}
