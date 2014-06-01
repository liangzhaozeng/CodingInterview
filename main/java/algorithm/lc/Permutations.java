package algorithm.lc;

import java.util.ArrayList;
import java.util.Arrays;
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
	
	
	public static void main(String[] args) {
		System.out.println("ABC".substring(0, 2));
		System.out.println("ABC".substring(1, 1));
		permutation("ABC");
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
		int t = v.get(i);
		v.set(i, v.get(j));
		v.set(j, t);
	}

	public ArrayList<ArrayList<Integer>> permute(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> initiateList = new ArrayList<Integer>();
		for (int i = 0; i < num.length; i++) {
			initiateList.add(num[i]);
		}

		int length = num.length;
		permute(initiateList, length, result);

		return result;
	}

	public void permute(ArrayList<Integer> v, int n, ArrayList<ArrayList<Integer>> result) {
		if (n == 1) {
			result.add(new ArrayList<Integer>(v));
		} else { 
			for (int i = 0; i < n; i++) {
				permute(v, n - 1, result);
				if (n % 2 == 1) {
					swap(v, 0, n - 1);
				} else {
					swap(v, i, n - 1);
				}
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
