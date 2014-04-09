package test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Random;

public class MyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		ListNode n3 = new ListNode(3);
		ListNode n5 = new ListNode(5);
		n3.next = n5;
		ListNode node = reverseBetween(n3, 1, 2);
		int[] height = { 1, 1 };

		System.out.println(subsetsWithDup(height));

	}

	public static int[] RandomizeArray(int[] array){
		Random rgen = new Random();  // Random number generator			
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		return array;
	}
	
	public static int[] RandomizeArray(int a, int b){
		Random rgen = new Random();  // Random number generator		
		int size = b-a+1;
		int[] array = new int[size];
 
		for(int i=0; i< size; i++){
			array[i] = a+i;
		}
 
		for (int i=0; i<array.length; i++) {
		    int randomPosition = rgen.nextInt(array.length);
		    int temp = array[i];
		    array[i] = array[randomPosition];
		    array[randomPosition] = temp;
		}
 
		for(int s: array)
			System.out.println(s);
 
		return array;
	}
	
	public void reservoirSampling() throws FileNotFoundException, IOException {
		File f = new File("data.txt");
		BufferedReader br = new BufferedReader(new FileReader(f)); // creating
																	// buffered
																	// reader
																	// object to
																	// read the
																	// file
																	// contains
																	// our data
		String currentLine;
		int reservoirSize = 10;
		List<String> reservoirList = new ArrayList<String>(reservoirSize); // reservoirList
																			// is
																			// where
																			// our
																			// selected
																			// lines
																			// stored
		int count = 0; // we will use this counter to count the current line
						// numebr while iterating
		Random ra = new Random();

		int randomNumber;
		while ((currentLine = br.readLine()) != null) // here we will iterate
														// through the file till
														// it ends
		{
			count++; // increase the line number
			if (count <= 10) {
				reservoirList.add(currentLine);
			} else {
				randomNumber = (int) ra.nextInt(count);
				if (randomNumber < reservoirSize) {
					reservoirList.set(randomNumber, currentLine);
				}
			}
		}
	}

	public static ListNode reverseBetween(ListNode head, int m, int n) {
		ListNode fakeHead = new ListNode(0);
		fakeHead.next = head;
		ListNode curNode = head;
		int cur = 0;
		while (cur < m - 1) {
			curNode = curNode.next;
			cur++;

		}
		ListNode preCur = curNode;
		curNode = curNode.next;

		while (cur < n - 1) {
			ListNode nextCur = curNode.next;
			curNode = nextCur.next;
			preCur.next = nextCur;
			nextCur.next = curNode;
			cur++;
		}

		return fakeHead.next;

	}

	public static ArrayList<ArrayList<Integer>> subsetsWithDup(int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (num.length == 0) {
			ArrayList<Integer> empty = new ArrayList<Integer>();
			result.add(empty);
		} else {
			Arrays.sort(num);
			result = DFS(num.length, num);
		}
		return result;
	}

	public static ArrayList<ArrayList<Integer>> DFS(int length, int[] num) {
		ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
		if (length == 1) {
			result.add(new ArrayList<Integer>());
			ArrayList<Integer> oneElement = new ArrayList<Integer>();
			oneElement.add(num[0]);
			result.add(oneElement);

		} else {
			ArrayList<ArrayList<Integer>> preRes = DFS(length - 1, num);
			HashSet<ArrayList<Integer>> set = new HashSet<ArrayList<Integer>>();
			for (ArrayList<Integer> temp : preRes) {
				result.add(temp);
				set.add(temp);
				ArrayList<Integer> newTemp = new ArrayList<Integer>(temp);
				newTemp.add(num[length - 1]);

				if (set.add(newTemp))
					result.add(newTemp);
			}

		}
		return result;
	}

	public static int largestRectangleArea(int[] height) {
		int area = 0;
		for (int i = 0; i < height.length; i++) {
			for (int k = i + 1; k < height.length; k++) {
				if (height[k] < height[k - 1]) {
					i = k - 1;
					break;
				} else {
					i = k;
				}
			}
			int lowest = height[i];
			for (int j = i; j >= 0; j--) {
				if (height[j] < lowest) {
					lowest = height[j];
				}
				int currArea = (i - j + 1) * lowest;
				if (currArea > area) {
					area = currArea;
				}
			}
		}
		return area;
	}

}
