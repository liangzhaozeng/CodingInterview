package interview.questions.linkedin;

import java.util.HashMap;

public class Ismorphic {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	
	public static boolean check(String s,String t){
		if(s.length()!=t.length()) return false;
		HashMap<Character,Character> map1=new HashMap<Character, Character>();
		HashMap<Character,Character> map2=new HashMap<Character, Character>();
		
		for(int i=0;i<s.length();i++){
			char c1=s.charAt(i);
			char c2=t.charAt(i);
			if(map1.containsKey(c1)){
				if(map1.get(c1)!=c2) return false;
			}
			if(map2.containsKey(c2)){
				if(map2.get(c2)!=c1) return false;
			}
			
			map1.put(c1, c2);
			map2.put(c2, c1);
		}
		return true;
	}
	public static boolean checkIsmorphic(String s1, String s2){
		int len = s1.length();
		if(s2.length()!=len)
			return false;
		
		int[] firstS = new int[26];
		int[] secondS = new int[26];
		
		for(int i=0; i<len; i++){
			int c1 = (int)s1.charAt(i)-96;
			int c2 = (int)s2.charAt(i)-96;
			int index1 = c1-1;
			int index2 = c2-1;
			if(firstS[index1]==0){
				firstS[index1] = c2;
				secondS[index2] = c1;
			} else if(firstS[index1]!=c2||secondS[index2]!=c1){
				return false;
			}
		}
		return true;
	}
}
