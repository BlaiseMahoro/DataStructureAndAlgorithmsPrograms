
public class Vowels {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str="Abana";
		str=str.toLowerCase();
		if(hasMoreVowels(str,0,0,0))
			System.out.println("Has more vowels.");
		else
			System.out.println("Does not have more vowels.");
		

	}
	public static boolean hasMoreVowels(String S, int index, int numV, int numC) {
		if(index==S.length()) {
			if(numV>numC)
				return true;
			else 
				return false;
		}
		else {
			if(S.charAt(index)=='a'||S.charAt(index)=='e'||S.charAt(index)=='i'||S.charAt(index)=='o'||
					S.charAt(index)=='u') {
				numV++;
			}
			else
				numC++;
			
			return hasMoreVowels(S,index+1,numV, numC);
		}
				
	}

}
