package interview.questions.linkedin;

import java.util.ArrayList;
import java.util.List;

public class FindInterSect {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	
	public List<Integer> FindIntersection(int[] A, int[] B)
	{
	         int L = A.length;
	         int K = B.length;

	         List<Integer> intersectionArr = new ArrayList<Integer>();
	         int i = L - 1;
	         int j = K - 1;
	         
	          while ((i >= 0) && (j >=  0))
	          {
	                 if (A[i] > B[j])
	                 {
	                        i--;
	                 }
	                 else if (B[j] > A[i])
	                 {
	                         j--;
	                 }
	                 else
	                 {
	                         intersectionArr.add(A[i]);
	                          i--;
	                          j--;
	                        
	                 }
	          }
	          return intersectionArr;
	}
}
