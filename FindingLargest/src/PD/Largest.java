package PD;

public class Largest{
	
	public static int  [] largest10(int [] arr) {
		
		if(arr.length<=10)
			return arr;
		else {
			int A[], B[];
			A = new int[arr.length];
			B=new int[10];
			//displayAll(arr);
			A= sort(arr);
			//displayAll(A);
			int j=0;
			for(int i=A.length-1; i >= A.length-10; i--) {
					B[j]=A[i];
					j++;
			}
			//displayAll(B);
			return B;
		}
		
			
	}
	public static int[] sort(int [] A) {
		//Using the insertion sort
		for(int k=1; k<A.length;k++) {
		      int cur =A[k];
				 int j=k;
				while(j >0 && A[j-1] > cur) {
				     A[j]=A[j-1];
				     j--;
				}
				A[j]=cur;
		}
		return A;

	}
	public static void displayAll(int [] arr)
	{
		for(int j=0; j<arr.length; j++)
			System.out.print(arr[j]+",");
		System.out.println(" ");
	}
	 

}
