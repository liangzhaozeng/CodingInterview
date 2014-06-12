package interview.questions.linkedin;

import java.util.Stack;

public class DeleteOne {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	String removal(String value) {
		if (value.length() < 2) {
			return value;
		}

		String vt;

		int pos = 0;

		for (; pos < value.length() - 1; ++pos) {
			if (value.charAt(pos) > value.charAt(pos + 1)) {
				break;
			}
		}

		if (pos < value.length() - 1) {
			vt = value.substring(0, pos) + value.substring(pos + 1);
		} else {
			vt = value.substring(0, pos);
		}

		return vt;
	}

	public int getSmallest(String input, int k) {
		if (input == null || k > input.length())
			return 0;
		Stack<Character> s = new Stack<Character>();
		for (int i = 0; i < input.length(); i++) {
			while (!s.isEmpty() && s.peek() > input.charAt(i) && k-- > 0)
				s.pop();
			s.push(input.charAt(i));
		}
		while (k-- > 0)
			s.pop();
		String rl = "";
		while (!s.isEmpty())
			rl = s.pop() + rl;
		return Integer.parseInt(rl.length() == 0 ? "0" : rl);
	}

}
