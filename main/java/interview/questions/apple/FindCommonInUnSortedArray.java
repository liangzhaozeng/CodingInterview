package interview.questions.apple;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindCommonInUnSortedArray {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] a = {1, 2, 3, 4, 5, 6};
		int[] b = {5,6};
		ArrayList<Integer> c = findCommonInUnSortedArrayUsingBitSet(a, b);
		for (int i : c) {
			System.out.println(i);
		}
	}
	private static Set<Integer> findCommonInUnSortedArray(int[] a, int[] b) {
		Set<Integer> commonSet = new HashSet<Integer>();
		int[] array1 = null;
		int[] array2 = null;
		if(a.length > b.length) {
			array1 = a;
			array2 = b;
		} else {
			array1 = a;
			array2 = b;
		}

		int array1length = array1.length;
		int array2length = array2.length;
		for(int i =0; i < array1length; i++) {
			for(int j=0; j<array2length; j++) {
				if(array1[i] == array2[j]) {
					commonSet.add(array1[i]);
				}
			}
		}

		return commonSet;
	}

	private static Set<Integer> findCommonInUnSortedArrayUsingSet(int[] a, int[] b) {
		Set<Integer> commonSet = new HashSet<Integer>();
		int[] array1 = null;
		int[] array2 = null;
		if(a.length > b.length) {
			array1 = a;
			array2 = b;
		} else {
			array1 = a;
			array2 = b;
		}

		int array2length = array2.length;

		Set<Integer> array1Set = new HashSet<Integer>();
		for(int i =0; i < array1.length; i++) {
			array1Set.add(array1[i]);
		}

		for(int j=0; j<array2length; j++) {
			if(array1Set.contains(array2[j])) {
				commonSet.add(array2[j]);
			}
		}

		return commonSet;
	}

	private static Set<Integer> findCommonInUnSortedArrayUsingRetainAll(int[] array1, int[] array2) {
		

		Set<Integer> array1Set = new HashSet<Integer>();
		for(int i =0; i < array1.length; i++) {
			array1Set.add(array1[i]);
		}

		Set<Integer> array2Set = new HashSet<Integer>();
		for(int i =0; i < array2.length; i++) {
			array2Set.add(array2[i]);
		}

		array1Set.retainAll(array2Set);

		return array1Set;
	}

	@SuppressWarnings("unchecked")
	private static <T> T[] intersection(T[] a, T[] b, Class<? extends T> c) {
	    HashSet<T> s = new HashSet<T>(Arrays.asList(a));
	    s.retainAll(Arrays.asList(b));
	    return s.toArray((T[]) Array.newInstance(c, s.size()));
	}

	private static  ArrayList<Integer> findCommonInUnSortedArrayUsingBitSet(int[] a, int[] b) {
		BitSet b1 = new BitSet();
		BitSet b2 = new BitSet();
		for(int aa : a){
			b1.set(aa);
		}
		for(int bb : b){
			b2.set(bb);
		}
		b2.and(b1);
        ArrayList<Integer> arr = new ArrayList<Integer>();
	    for (int i = b2.size(); i >=0; i --) {
	    	if (b2.get(i) == true) 
	    		arr.add(i);
	    }
	   return arr;
	}
	
	 static int[] bits2Ints(BitSet bs) {
		    int[] temp = new int[bs.size()];

		    for (int i = 0; i < temp.length; i++)
		      for (int j = 0; j < 32; j++)
		        if (bs.get(i * 32 + j))
		          temp[i] |= 1 << j;

		    return temp;
		  }

	 private static List<Integer> findCommonInUnSortedArray2(int a[], int b[]) {
		List<Integer> commonList = new ArrayList<Integer>();
	        List<Integer>[] hashtable;
	        int[] array1;
	        int[] array2;
	        if (a.length > b.length) {
	            hashtable = new ArrayList[a.length];
	            array1 = a;
	            array2 = b;
	        } else {
	            hashtable = new ArrayList[b.length];
	            array1 = b;
	            array2 = a;
	        }
	        Arrays.fill(hashtable, new ArrayList<Integer>());
	        for (int i = 0; i < array1.length; i++) {
	            hashtable[array1[i] % hashtable.length].add(array1[i]);
	        }
	        for (int i = 0; i < array2.length; i++) {
	            if (hashtable[array2[i] % hashtable.length].contains(array2[i])) {
	                commonList.add(array2[i]);
	            }
	        }
	        return commonList;
	    }

	 private static List findCommonInUnSortedArray3(int a[], int b[]) {
	        List commonList = new ArrayList();
	        List hashtable;
	        int[] array1;
	        int[] array2;
	        if (a.length > b.length) {
	            hashtable = new ArrayList(a.length);
	            array1 = a;
	            array2 = b;
	        } else {
	            hashtable = new ArrayList(b.length);
	            array1 = b;
	            array2 = a;
	        }
	        for (int i = 0; i < array1.length; i++) {
	            hashtable.add(array1[i]);
	        }
	        for (int i = 0; i < array2.length; i++) {
	            if (hashtable.contains(array2[i])) {

	                commonList.add(array2[i]);
	            }
	        }
	        return commonList;
	    }
}
