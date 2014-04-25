package interview.questions;

public class MinLengthOfSeq {

	public static int solution(int[] A, int sum) {
		
		int length = A.length;
		
		int[][] dp = new int [length+1][length+1];
		for (int i = 0; i < length; i ++) {
		dp[i][i] =A[i];
		if (dp[i][i]> sum) {
			return 1;
		}
		}
		for (int l = 2; l<=length; l++) {
			for (int start = 0; start+l-1 < length; start ++){
				
				dp[start][start+l-1] = dp[start][start+l-2] + A[start+l-1];
				if (dp[start][start+l-1] > sum)
					return l;
			}
		}
		return -1;
		
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] A = {2,1,1,4,3,6};
		System.out.println(solution(A,8));
		

	}

}
