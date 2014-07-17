package interview.questions.linkedin;

public class ReverStr {


		public static void main(String []args) {
			System.out.println(revString("This is a test"));
		}
		
		static String revString(String str) {
			System.out.println(str);

			int length = str.length()-1; 

			if ( length ==0 )	
				return String.valueOf(str.charAt(0));

			if ( length == 1 )
				return String.valueOf(str.charAt(1)) + String.valueOf(str.charAt(0));

			return String.valueOf(str.charAt(length)) + revString(str.substring(1, length)) + String.valueOf(str.charAt(0));
			

		}
	}

