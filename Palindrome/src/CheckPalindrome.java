
public class CheckPalindrome {
	public static char chars[];
    public static String S;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	  S="racecar";
      if(isPalindrome(S.toCharArray(), 0, S.length()-1))
    	  System.out.println("is Palindrome");
      else
    	  System.out.println("is not Palindrome");
	}
	public static boolean isPalindromeIt(String S) {	
		boolean isPal=true;	
		char ch [];
		ch=S.toCharArray();
		int i=0;
		int j=ch.length-1;
		 while(i<ch.length) {
			 	 if(ch[i]!=ch[j]) 
			 		 return false;
				 j--;
				 i++;
			 }
		 
		 return isPal;
	}
	public static boolean isPalindrome2(char ch [],int low, int high)
	{
		char chReverse[];
		boolean equal =true;
		chReverse=S.toCharArray();
		reverseString(ch,0,ch.length-1);
		for(int i=0;i<ch.length;i++) {
			System.out.println(chReverse[i]);
		}
		for(int i=0;i<ch.length&&equal;i++) {
			if(chReverse[i]!=ch[i]) {
				equal=false;
			}
		}
		return equal;
	}
	//Using recursion
	/*public static boolean isPalindrome(char ch [],int low, int high) {
		if(low>=high) 
			return true;
		else if(!isPalindrome(ch, low+1,high-1)) 
			return false;
		else 
			return(ch[low]==ch[high]);
		}*/
	public static boolean isPalindrome(char ch [],int low, int high) {
		if(low>=high) 
			return(ch[low]==ch[high]);
		else {
		   return (ch[low]==ch[high])&&isPalindrome(ch, low+1,high-1);
		}
	
			
		}
	
	public static void reverseString(char ch [], int low, int high) {
		if(low<high) {
			char temp=ch[low];
			ch[low]=ch[high];
			ch[high]=temp;
			reverseString(ch,low+1,high-1);
			
		}
	}
	
		
}
