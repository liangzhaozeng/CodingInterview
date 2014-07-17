package interview.questions.linkedin;

public class StringTree {

	public static int findDepth(String s) {
		int countLeft = 0;
		int countLeftTotal = 0;
		int countZero = 0;
		int depth = -1; // countLeft - 1
		for (int i = 0; i < s.length(); i++) {
			char a = s.charAt(i);
			switch (a) {
			case '0':
				countZero++;
				break;
			case '(': {
				countLeft++;
				countLeftTotal++;
			}
				;
				break;
			case ')': {
				if (depth < countLeft - 1)
					depth = countLeft - 1;
				countLeft = 1;
			}
				;
				break;
			default:
				return -1;
			}
			/*
			 * if( a == '(' ) countLeft++; else if( a == ')' && depth < (
			 * countLeft - 1 ) ) { depth = countLeft - 1; countLeft = 1; } else
			 * if( a != '0' ) return -1;
			 */
		}
		if (countZero == countLeftTotal + 1)
			return depth;
		else
			return -1;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String s1 = "(00)"; // 0
		String s2 = "((00)0)"; // 1
		String s3 = "((00)(00))"; // 1
		String s4 = "((00)(0(00)))"; // -> 2
		String s5 = "((00)(0(0(00))))"; // -> 3
		String s6 = "x"; // -> -1
		String s7 = "0"; // -> -1
		String s8 = "()"; // -> -1
		String s9 = "(0)"; // -> -1
		String s10 = "(00)x"; // -> -1
		String s11 = "(0p)"; // -> -1*/

		System.out.println(findDepth(s1));
		System.out.println(findDepth(s2));
		System.out.println(findDepth(s3));
		System.out.println(findDepth(s4));
		System.out.println(findDepth(s5));
		System.out.println(findDepth(s6));
		System.out.println(findDepth(s7));
		System.out.println(findDepth(s8));
		System.out.println(findDepth(s9));
		System.out.println(findDepth(s10));
		System.out.println(findDepth(s11));
	}
}
