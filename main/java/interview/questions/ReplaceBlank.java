package interview.questions;

public class ReplaceBlank {
	
	void replaceBlank(String s) {
		if (s == null || s.trim().length() == 0) return;
		
		char[] chars = s.toCharArray();
		int count =0;
 		for (char c : chars){
 			if (c==' ') count ++;
 			
 		}
 		
 		int newLength = s.length() + count *2;
 		
		
	}

}
