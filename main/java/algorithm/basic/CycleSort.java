package algorithm.basic;

public class CycleSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	/***************************************************************************
	 * Author: Isai Damier
	 * Title: Cyclesort
	 * Project: geekviewpoint
	 * Package: algorithms
	 *
	 * Statement:
	 *   Given a disordered list of integers (or any other items),
	 *   rearrange the integers in natural order.
	 *
	 * Sample Input: {8,5,3,1,9,6,0,7,4,2,5}
	 * Sample Output: {0,1,2,3,4,5,5,6,7,8,9}
	 *
	 * Time Complexity of Solution:
	 *   Average Case O(n^2); Worst Case O(n^2).
	 *
	 * Approach:
	 *   Given a sequence of objects, such as an array of integers; if the
	 *   elements are not arranged in order that is because some of them have
	 *   switched places among themselves. For example, [4,1,2,3,5,0] is not in
	 *   order because 4,5,0 have traded places (1 bad group). [4,2,3,7,5,0,1]
	 *   is not in order because 4,5,0 have traded places and 2,3,7,1 have
	 *   traded places (two bad groups). In discrete mathematics, each group,
	 *   bad or good, is known as a cycle or an orbit.
	 *
	 *   The basis for cyclesort is that if the elements of each bad group were
	 *   to return to their correct positions, then the entire sequence would be
	 *   sorted.
	 *
	 *   cyclesort has great merit because it improves the life expectancy of
	 *   computer memories. During cyclesort, each element is moved once at
	 *   maximum. Recall that each time the data in a block of memory is
	 *   changed, the memory degrades.
	 **************************************************************************/
	 public int cyclesort(int[] input) {
	  int writes = 0;
	 
	  for (int cs = 0, seeker, pos; cs < input.length - 1; cs++) {
	    //assume the element at input[cs] is out of place
	    seeker = input[cs];
	    pos = cs;
	    //find the correct position (pos) of seeker
	    for (int i = cs + 1; i < input.length; i++) {
	      if (input[i] < seeker) {
	        pos++;
	      }
	    }
	    //if seeker is already in correct position, move on
	    if (pos == cs) {
	      continue;
	    }
	    //move index pos after duplicates if any
	    while (seeker == input[pos]) {
	      pos++;
	    }
	    /**
	     * Make a switch: seeker gets index pos, its rightful
	     * home; whatever element was at pos is now the seeker
	     * in search of a rightful home.
	     **/
	    seeker = set(input, seeker, pos);
	    //track the number of writes
	    writes++;
	 
	    /**
	     * complete the current cycle before moving to the next
	     * cycle. At the end of the current cycle, pos will
	     * equal cs; which should make sense since a cycle
	     * always ends where it began.
	     **/
	    while (pos != cs) {
	      //same as block of code above
	      pos = cs;
	      for (int i = cs + 1; i < input.length; i++) {
	        if (input[i] < seeker) {
	          pos++;
	        }
	      }
	      while (seeker == input[pos]) {
	        pos++;
	      }
	      seeker = set(input, seeker, pos);
	      writes++;
	    }
	  }
	  return writes;
	}
	 
	private int set(int[] array, int data, int ndx) {
	  try {
	    return array[ndx];
	  } finally {
	    array[ndx] = data;
	  }
	}

}
