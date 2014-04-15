package algorithm.lc;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

import java.util.Set;
import java.util.HashSet;
import java.util.Hashtable;
/**
 * Given two words (start and end), and a dictionary, find the length of
 * shortest transformation sequence from start to end, such that:
 * 
 * Only one letter can be changed at a time Each intermediate word must exist in
 * the dictionary For example,
 * 
 * Given: start = "hit" end = "cog" dict = ["hot","dot","dog","lot","log"]
 * 
 * As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
 * return its length 5.
 * 
 * Note:
 * 
 * Return 0 if there is no such transformation sequence. All words have the same
 * length. All words contain only lowercase alphabetic characters.
 * 
 */
// O(n) space, O(n) time
public class WordLadder {
  // BFS, enqueue all unvisited neighbors of current string
 
	      public int ladderLength(String start, String end, HashSet<String> dict) {
	          // Start typing your Java solution below
	          // DO NOT write main() function
	          Hashtable<String,String> path = new Hashtable<String,String>();//current, prev
	          Set<String> visit = new HashSet<String>();
	          Queue<String> queue = new LinkedList<String>();//bfs queue
	          queue.add(start);
	          visit.add(start);
	          while(queue.size()>0){
	              String prev = queue.poll();
	              for(String curr: adjacent(prev, dict)){//adjacent words
	                  if(curr.equals(end)){
	                      int count = 1;
	                      while(prev!=null){
	                          prev = path.get(prev);
	                          count++;
	                      }
	                      return count;
	                  }
	                  if(!visit.contains(curr)){
	                      path.put(curr, prev);
	                      visit.add(curr);
	                      queue.add(curr);
	                  }
	              }
	          }
	          return 0;
	      }
	      public Set<String> adjacent(String str, Set<String> dict){
	          Set<String> res = new HashSet<String>();
	          for(int i=0;i<str.length();i++){
	              for(char j='a';j<='z';j++){
	                  char[] chs = str.toCharArray();
	                  if(chs[i]!=j){
	                      chs[i]=j;
	                      String nstr = new String(chs);
	                      if(dict.contains(nstr))
	                          res.add(nstr);
	                  }
	              }
	          }
	          return res;
	      }
	  
	  
	  
	  
    public int ladderLength2(String start, String end, HashSet<String> dict) {
          // Start typing your Java solution below
          // DO NOT write main() function
      Queue<Pair> queue = new LinkedList<Pair>();
      Set<String> visited = new HashSet<String>();
      queue.offer(new Pair(start, 1));
      visited.add(start);
      
      while (!queue.isEmpty()) {
        Pair pair = queue.poll();
        char[] curChars = pair.word.toCharArray();
        int dist = pair.dist;
        for (int i = 0; i < curChars.length; ++i) { // substitute each char
          char tmp = curChars[i];
          for (char c = 'a'; c <= 'z'; ++c) {
            if (c == tmp) {
              continue;
            }
            curChars[i] = c;  
            String newStr = new String(curChars);
            if (newStr.equals(end)) {
              return dist + 1;
            }
            if (dict.contains(newStr) && !visited.contains(newStr)) {
              queue.offer(new Pair(newStr, dist + 1));
              visited.add(newStr);
            }
            curChars[i] = tmp;
          }
        }
      }
      return 0;
    }
    
    public class Pair {
      String word;
      int dist;
      public Pair(String word, int dist) {
        this.word = word;
        this.dist = dist;
      }
    }
  }


