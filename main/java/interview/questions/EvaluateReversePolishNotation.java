package interview.questions;

import java.util.Stack;

public class EvaluateReversePolishNotation {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

     public int evalRPN(String[] tokens) {
     
    	 if (tokens == null || tokens.length == 0) return 0;
    	 
    	 Stack<Integer> stack = new Stack<Integer> ();
    	 
    	 for (int i = 0; i < tokens.length; i ++) {
    		 if (tokens[i].equals("+") ||  tokens[i].equals("-") || tokens[i].equals("*") || tokens[i].equals("/")) {
    			 int second = stack.pop();
    			 int first = stack.pop();
    			 
    			 if (tokens[i].equals("+"))
    				 stack.push(first + second);
    			 
    			 if (tokens[i].equals("-"))
    				 stack.push(first - second);
    			 if (tokens[i].equals("*"))
    				 stack.push(first * second);
    			 if (tokens[i].equals("/"))
    				 stack.push(first / second);
    		 } else {
    			 stack.push(Integer.parseInt(tokens[i]));
    			 
    		 }
    		
    	 }
    	 return stack.pop();
     }
     
    	 
    
	
	
}
