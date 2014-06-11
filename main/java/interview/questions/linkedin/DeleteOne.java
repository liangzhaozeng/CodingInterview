package interview.questions.linkedin;

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

}
