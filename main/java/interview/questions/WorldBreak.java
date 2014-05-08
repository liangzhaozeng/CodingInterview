package interview.questions;

import java.util.HashMap;
import java.util.Set;

public class WorldBreak {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	HashMap<String, Boolean> cache = new HashMap<String, Boolean>();
	 public boolean wordBreak(String s, Set<String> dict) {
		  if (s==null ||s.length()==0) return true;
	        
	        if (dict.contains(s)) return true;
	        else {
	            for (int i = 0; i < s.length() ; i ++) {
	                if (dict.contains(s.substring(0, i))  && getCache(s.substring(i, s.length()), dict))
	                	return true;
	            }
	        }
	        return false;
	    }
	 
     boolean getCache(String s, Set<String> dict) {
    	 if (cache.containsKey(s)) return cache.get(s); 
    	 else {
    		 boolean result = wordBreak(s, dict);
    		 cache.put(s, result);
    		 return result;
    	 }
    		 
     }
	
}
