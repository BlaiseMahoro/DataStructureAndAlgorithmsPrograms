package HI;

import java.util.Random;

import PD.Largest;

public class start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Random gen = new Random();
		int n=19;
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=gen.nextInt(n) +1;
		}
		long startTime = System.nanoTime(); 
		Largest.largest10(arr);
		long stopTime = System.nanoTime(); 
		long diff=stopTime - startTime ;
		System.out.println("Running time = " + diff+ " ms");

    
	}

}
