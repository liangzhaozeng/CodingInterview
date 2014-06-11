package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * Given a collection of numbers, return all possible permutations.
 * 
 * For example, [1,2,3] have the following permutations: [1,2,3], [1,3,2],
 * [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * 
 */
// O(n!) space, O(n!) time, where n is the length of array
public class Permutations {
	
	
	
   public static ArrayList<String> permulation(String str){
	   ArrayList<String> result = new ArrayList<String>();
	   if (str == null || str.length() == 0) return result;
	   int n = str.length();
	   char[] chars = str.toCharArray();
	   permutation(chars, n, result);
	   return result;
   }
   private static void permutation(char[] initiateStr, int length, ArrayList<String> result) {
	   if (length == 1) {
		   result.add(new String(initiateStr));
		   System.out.println("================================");
		   System.out.println("Adding "+ new String(initiateStr));
		   System.out.println("================================");
	   } else {
		   int i = 0;
		   boolean isSame = false;
		   while(i < length){
			  if (isSame == false)
			   permutation(initiateStr, length -1, result);
			   System.out.println("Before  " +  new String(initiateStr));
			  
			   if (length % 2 == 1) {
				   
				isSame = swapStr(initiateStr, 0, length-1);
			   } else {
	            isSame = swapStr(initiateStr, i, length-1);
			   }
			   i ++;
			//   if (isSame) 
			   System.out.println("After  " + new String(initiateStr));
		   }
	   }
   }
  private static boolean swapStr(char[] str, int i, int j){
	 
	  if (str[i]==str[j]) return true;
	  char temp = str[i];
	  str[i]= str[j];
	  str[j] = temp;
	  return false;
	 
  }
	public static void main(String[] args) {
		System.out.println("ABC".substring(0, 2));
		System.out.println("ABC".substring(1, 1));
	//	permulation("ABC");
	//	System.out.println ();
	int[]A = {1,1,2};
		permute(A);
		//permutation("ABC");
	}
	public static void permutation(String str) { 
	    permutation("", str); 
	}

	private static void permutation(String prefix, String str) {
	    int n = str.length();
	    if (n == 0) System.out.println(prefix);
	    else {
	        for (int i = 0; i < n; i++) {
	        	System.out.println(" i = " + i + "  " +str.substring(0, i) + "   " + str.substring(i+1, n) );
	            permutation(prefix + str.charAt(i), str.substring(0, i) + str.substring(i+1, n));
	        }
	    }
	}


    public ArrayList<ArrayList<Integer>> permute2(int[] num) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        if (num == null || num.length == 0) return result;
        result= generate(num.length, num);
        return result;
    }
    
    private ArrayList<ArrayList<Integer>>  generate (int length, int[] num) {
         ArrayList<ArrayList<Integer>> result = new  ArrayList<ArrayList<Integer>>();
        
        if (length == 1) {
            ArrayList<Integer> cur = new ArrayList<Integer>();
            cur.add(num[0]);
            result.add(cur);
            return result;
        } else {
            ArrayList<ArrayList<Integer>> prevRes = generate(length-1, num);
            for (ArrayList<Integer> cur : prevRes) {
             
                for (int i = 0; i <= cur.size(); i ++) {
                       ArrayList<Integer> newCur = new ArrayList<Integer>(cur);
                       newCur.add(i,num[length-1]);
                       result.add(newCur);
                }
                
            }
            return result;
        }
    }
	
    // http://en.wikipedia.org/wiki/Heap's_algorithm
	private static void swap(ArrayList<Integer> v, int i, int j) {
		//System.out.println(i + " " + j);
		
		int t = v.get(i);
		v.set(i, v.get(j));
		v.set(j, t);
	}

	public static ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> initiateList = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			initiateList.add(num[i]);
		}

		int length = num.length;
		HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
		permute(initiateList, length, set);
        result = new ArrayList<ArrayList<Integer>>(set);
        for ( ArrayList<Integer> a: result){
        	System.out.println(a);
        }
		return result;
	}

	public static void permute(ArrayList<Integer> v, int n, HashSet<ArrayList<Integer>> result) {
		if (n == 1) {
			if (result.add(new ArrayList<Integer>(v)))
			System.out.println("Adding " + new ArrayList<Integer>(v));
		} else { 
			for (int i = 0; i < n; i++) {
				permute(v, n - 1, result);
			//	System.out.print("Before " + v);
				if (n % 2 == 1) {
					swap(v, 0, n - 1);
				} else {
					swap(v, i, n - 1);
				}
			//	System.out.println("After " + v);
			}
		}
	}

	public class Solution {
		public ArrayList<ArrayList<Integer>> permute(int[] num) {
			// Start typing your Java solution below
			// DO NOT write main() function
			Arrays.sort(num);
			ArrayList<Integer> cur = new ArrayList<Integer>();
			for (int i : num) {
				cur.add(i);
			}
			ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
			res.add(new ArrayList<Integer>(cur));
			if (cur.size() <= 1) {
				return res;
			}
			while (next(cur)) {
				res.add(new ArrayList<Integer>(cur));
			}
			return res;
		}

		private boolean next(ArrayList<Integer> cur) {
			int lastSmaller = cur.size() - 2;
			while (cur.get(lastSmaller) >= cur.get(lastSmaller + 1)) {
				--lastSmaller;
				if (lastSmaller < 0) {
					return false;
				}
			}

			int firstBigger = cur.size() - 1;
			while (cur.get(firstBigger) <= cur.get(lastSmaller)) {
				--firstBigger;
			}
			swap(cur, lastSmaller, firstBigger);
			++lastSmaller;
			int last = cur.size() - 1;
			while (lastSmaller < last) {
				swap(cur, lastSmaller, last);
				++lastSmaller;
				--last;
			}
			return true;
		}

		private void swap(List<Integer> list, int first, int second) {
			int tmp = list.get(first);
			list.set(first, list.get(second));
			list.set(second, tmp);
		}
	}

}
