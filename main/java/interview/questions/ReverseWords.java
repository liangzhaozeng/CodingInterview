package interview.questions;

public class ReverseWords {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public String reverseWords(String s) {
        if (s==null || s.length()==0) return s;
         StringBuilder sb = new StringBuilder();
         
         String[] words =  s.split(" ");
         for (int i = words.length-1; i >=0; i --) {
        	 sb.append(words[i].trim() + " ");
         }
        return sb.toString().trim();
        
    }
	
	
}
