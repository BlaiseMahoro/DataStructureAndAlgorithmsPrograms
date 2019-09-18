package HI;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Random;

import PD.Algorithms;
/**
 * saves the number of inputs n and run times for each algorithm
 * @author Blaise Mahoro
 *
 */
public class Start {
	//this helps to access these variables easily
    public static long startTime, stopTime;
    
	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		
		Random gen = new Random();
		int n=100000;
		int arr[] = new int[n];
		for(int i=0; i<n; i++) {
			arr[i]=gen.nextInt(n) +1;
		}
		
		//Algorithm 1
		String fileName1= "Analys.csv";
		PrintWriter outputStream1= new PrintWriter(fileName1);		
		outputStream1.println("n, Time(ns)");		
		for(int i=0;i<100000; i+=100) {
		start();
		Algorithms.example1(arr,i);
		stop();
		outputStream1.println(i+", "+runTime());
		}
		outputStream1.close();
		
		//Algorithms 2
		String fileName2= "Analys1.csv";
		PrintWriter outputStream2= new PrintWriter(fileName2);
		outputStream2.println("n, Time(ns)");			
		for(int i=0;i<100000; i+=100) {
		start();
		Algorithms.example2(arr,i);
		stop();
		outputStream2.println(i+", "+runTime());
		}
		outputStream2.close();
		//Algorithm 3
		String fileName3= "Analys2.csv";
		PrintWriter outputStream3= new PrintWriter(fileName3);		
		outputStream3.println("n, Time(ns)");			
		for(int i=0;i<100000; i+=100) {
		start();
		Algorithms.example3(arr,i);
		stop();
		outputStream3.println(i+", "+runTime());
		}
		outputStream3.close();
		
		//Algorithm 4
		String fileName4= "Analys3.csv";
		PrintWriter outputStream4= new PrintWriter(fileName4);		
		outputStream4.println("n, Time(ns)");			
		for(int i=0;i<100000; i+=100) {
		start();
		Algorithms.example4(arr,i);
		stop();
		outputStream4.println(i+", "+runTime());
		}
		outputStream4.close();
		
		//Algorithm 5
		String fileName5= "Analys4.csv";
		PrintWriter outputStream5= new PrintWriter(fileName5);		
		outputStream5.println("n, Time(ns)");			
		for(int i=0;i<1000; i+=10) {
		start();
		Algorithms.example5(arr,arr,i);
		stop();
		outputStream5.println(i+", "+runTime());
		}
		outputStream5.close();
		System.out.println("Done");
	}
	/**
	 * starts the stop watch
	 */
	public static void start() {
		 startTime = System.nanoTime();
		
	}
	/**
	 * stops the stop watch
	 */
    public static void stop() {
    	 stopTime = System.nanoTime() ;
	}
    /**
     * 
     * @return run time
     */
    public static long runTime() {
    	return stopTime-startTime;
    	
    }
   
}
