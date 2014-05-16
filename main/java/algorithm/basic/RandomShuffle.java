package algorithm.basic;

import java.util.Arrays;
import java.util.Random;

public class RandomShuffle {
  
  public void shuffle(int[] A) {
    Random rnd = new Random();
    for (int i = 1; i < A.length; ++i) {
      int idx = rnd.nextInt(i); // get random number in range [0, i - 1]
      int tmp = A[i];
      A[i] = A[idx];
      A[idx] = tmp;
    }
  }

  
  static public void shuffle(char[] A) {
	    Random rnd = new Random();
	    for (int i = 1; i < A.length; ++i) {
	      int idx = rnd.nextInt(i); // get random number in range [0, i - 1]
	      char tmp = A[i];
	      A[i] = A[idx];
	      A[idx] = tmp;
	    }
	  }
  
	public static void main(String[] args) {
		char[] A = new char[52];
		for (int i = 0; i < 26; i ++){
			A[i]= (char) ('a' + i);
		}
		
		char[]B = new char[26];
		B= Arrays.copyOf(A, 26);
		
		shuffle(B);
		for (char ch : B) {
			System.out.print(ch);
		}
		System.out.println();
		
		for (int i = 26; i < 52; i ++){
			A[i]= (char) ('A' + i-26);
			B[i-26]= A[i];
		}
		
		shuffle(B);
		for (char ch : B) {
			System.out.print(ch);
		}
		System.out.println();
		
		
		for (char ch : A) {
			System.out.print(ch);
		}
		shuffle(A);
		for (char ch : A) {
			System.out.print(ch);
		}
	}
}
