package UI;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int result;
		result=multiply(1000,9);
		System.out.println(result+"");
	}
	public static int multiply(int n, int m) {
		if(n==0||m==0)
			return 0;
		else 
			return m+multiply(n-1,m);			
		
	}

}
