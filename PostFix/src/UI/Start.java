package UI;

import java.util.Scanner;

import PD.LinkedStack;

public class Start {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedStack lStack=new LinkedStack<Integer>();
		Scanner scan =new Scanner(System.in);
		String expression;
		Integer num1, num2, num3;
		System.out.println("Please enter an expression:");
		expression=scan.nextLine();
		//Code Here
		boolean error=false;
		String[] token = expression.split(" ");
		for(int i=0; i<token.length && !error;i++) {
			if(token[i].charAt(0)=='+'||token[i].charAt(0)=='-'||token[i].charAt(0)=='*'||
					token[i].charAt(0)=='/') {
				if(lStack.size()>=2) {
					num1 =(Integer) lStack.pop();
					num2 =(Integer) lStack.pop();
					//look for the correct operation
					if(token[i].charAt(0)=='+') {lStack.push(num1+num2);}
					else if(token[i].charAt(0)=='-') {lStack.push(num2-num1);}
					else if(token[i].charAt(0)=='*') {lStack.push(num2*num1);}
					else {lStack.push(num2/num1);}
				}
					
				else {					
					error=true;
				}
			}
			else {
				num3=Integer.parseInt(token[i]);
				lStack.push(num3);
			}
		}
	    
		if(lStack.size()==1&&!error)
			System.out.println(lStack.pop());
		else 
			System.out.println("Error! Not enough or too much operands on stack.");

	}

}
