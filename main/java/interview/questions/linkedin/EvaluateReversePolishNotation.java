package interview.questions.linkedin;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 * 
 * Valid operators are +, -, *, /. Each operand may be an integer or another
 * expression.
 * 
 * Some examples: ["2", "1", "+", "3", "*"] -> ((2 + 1) * 3) -> 9 ["4",
 * "13","5", "/", "+"] -> (4 + (13 / 5)) -> 6
 * 
 */
public class EvaluateReversePolishNotation {

	public String infixToPos(String infix) {
		Stack<Character> stack = new Stack<Character>();
		StringBuffer pos = new StringBuffer();

		for (int i = 0; i < infix.length(); i++) {
			char c = infix.charAt(i);
			if (c != '+' && c != '-' && c != '*' && c != '/') {
				pos.append(c);
			} else if (stack.empty()) {
				stack.push(c);
			} else {
				if (c == '*' || c == '/') {
					System.out.println("Peek" + stack.peek());
					while (stack.peek() == '*' || stack.peek() == '/') {
						if (!stack.isEmpty()) {
							pos.append(stack.pop());
						}
					}
					stack.push(c);
				} else {
					while (!stack.isEmpty()) {
						pos.append(stack.pop());
					}
					stack.push(c);
				}
			}
		}

		while (!stack.empty()) {
			pos.append(stack.pop());
		}

		return pos.toString();
	}

	// O(n) space, O(n) time
	public class Solution {
		public int evalRPN(String[] tokens) {
			// IMPORTANT: Please reset any member data you declared, as
			// the same Solution instance will be reused for each test case.
			Stack<Integer> stack = new Stack<Integer>();
			for (String token : tokens) {
				if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
					int second = stack.pop();
					int first = stack.pop();
					int res = 0;
					if (token.equals("+")) {
						res = first + second;
					} else if (token.equals("-")) {
						res = first - second;
					} else if (token.equals("*")) {
						res = first * second;
					} else {
						res = first / second;
					}
					stack.push(res);
				} else {
					stack.push(Integer.parseInt(token));
				}
			}

			return stack.pop();
		}
	}
}
