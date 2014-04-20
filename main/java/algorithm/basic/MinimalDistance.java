package algorithm.basic;

public class MinimalDistance {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	double MinimalDistance(double[] A, double[] B, double[] C)
	{
	    int i=0,j=0,k = 0;
	    double min_value = Integer.MAX_VALUE;
	    double current_val;
	    int[] opt_indexes = {0, 0, 0};

	    while(i < A.length || j < B.length || k < C.length)
	    {
	         current_val = calculate_distance(A[i],B[j],C[k]);
	         if(current_val < min_value)
	         {
	               min_value = current_val;
	               opt_indexes[1] = i;
	               opt_indexes[2] = j;
	               opt_indexes[3] = k;
	         }    

	         if(A[i] < B[j] && A[i] < C[k] && i < A.length)
	             i++;
	         else if (B[j] < C[k] && j < B.length)
	             j++;
	         else
	             k++; 
	    }

	    return min_value;
	}
	
	private double calculate_distance(double d, double e, double f) {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
