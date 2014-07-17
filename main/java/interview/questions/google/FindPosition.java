package interview.questions.google;

import java.util.Arrays;
import java.util.Map.Entry;
import java.util.TreeMap;

public class FindPosition {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int solve(int[] array) {
		TreeMap<Integer,Integer> map = new TreeMap<Integer,Integer>();
		for (int i : array) {
			int count = map.containsKey(i) ? map.get(i) : 0;
			map.put(i, count + 1);
		}
		int n = 0;
		for (Entry ent : map.descendingMap().entrySet()) {
			n += (Integer)ent.getValue(); 
			if (((Integer)ent.getKey()).compareTo(Integer.valueOf(n)) < 0) {
				return (Integer)ent.getKey();
			}
		}
		return 0;
	}
	
	public static int nGn(int[] arr){
		return nGn(arr, 0, arr.length-1, -1);
	}
	private static int nGn(int[] arr, int start, int end, int bestAns){
		if(end< start)
			return bestAns;
		if(start == end){
			if(arr.length - start >= arr[start])
				bestAns = arr[start];
			return bestAns;
		}
		int ind = partition(arr, start, end);
		if(arr.length - ind >= arr[ind]){
			bestAns = arr[ind];
			return nGn(arr,ind+1,end,bestAns);
		}
		else
			return nGn(arr,start,ind-1,bestAns);
	}
	
	private static int partition(int[] arr, int start, int end){
		int pivot = arr[start];
		int i = start, j= start+1;
		while(j<=end){
			if(arr[j]<pivot){
				int temp = arr[i+1];
				arr[i+1] = arr[j];
				arr[j] = temp;
				i++;
			}
			j++;
			int temp = arr[i];
			arr[i] = pivot;
			arr[start] = temp;
			
		}
		return i;
	}
	
	public static int solve2(int[] a) { 
	    Arrays.sort(a); 
	    for (int i = a.length; i > 0 ; i--) { 
	        if (a[a.length - i] >= i) 
	            return i; 
	    } 
	    return 0; 
	}
}
