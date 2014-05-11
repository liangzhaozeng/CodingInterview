package interview.questions;

import java.util.Stack;

public class IsPopOrder {

	private static void valid(int[] input, int[] out) {
		Stack<Integer> stack = new Stack<Integer>();
		int i = 0, o = 0;
		while (true) {
			/*
			if (i >= input.length && o >= out.length && stack.isEmpty()) {
				System.out.println("Yes");
				break;
			}
          */
			if (i < input.length) {
				stack.push(input[i]);
				i++;
				while (!stack.isEmpty() && stack.peek() == out[o]) { // 不停地检查看是否有机会弹栈
					stack.pop();
					o++;
				}
			} else {
				if (o < out.length) {
					if (stack.peek() != out[o]) {
						System.out.println("No");
						break;
					}
					if (stack.isEmpty()) {
						System.out.println("No");
						break;
					}
					if (stack.peek() == out[o]) {
						stack.pop();
						o++;
					}
				}
			}
			
			if ( stack.isEmpty()) {
				System.out.println("Yes");
				break;
			}
			
		}
		
		
	}

	static int IsRight(int[] push, int[] pop, int n) {
		int i = 0;
		int j = 0;
		int top = 0;
		int[] stack = new int[1000];
		stack[0] = push[0];
		while (i < n) {
			while (i < n && stack[top] != pop[j]) {
				++i;
				++top;
				stack[top] = push[i];
			}
			while (stack[top] == pop[j]) {
				--top;
				++j;
			}
		}
		while (top >= 0 && j < n) {
			if (stack[top] == pop[j]) {
				--top;
				++j;
			} else
				return 0;
		}
		return 1;
	}

	static boolean IsRightOrder(int[] push, int[] pop) {
		int n = push.length;
		int i = 0;
		int j = 0;

		Stack<Integer> stack = new Stack<Integer>();

		stack.push(push[0]);
		while (i < n) {
			while (i < n && stack.peek() != pop[j]) {
				++i;
				stack.push(push[i]);
			}
			while (!stack.isEmpty() && stack.peek() == pop[j]) {
				stack.pop();
				++j;
			}
		}
		while (!stack.isEmpty() && j < n) {
			if (stack.peek() == pop[j]) {
				stack.pop();
				++j;
			} else
				return false;
		}
		return true;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int[] push = { 1, 2, 3, 4, 5 };
		int[] pop = { 4, 5, 3, 2, 1 };
		valid(push, pop);
       int[] pop2={4,3,5,1,2};
       valid(push, pop2);
	}
}
