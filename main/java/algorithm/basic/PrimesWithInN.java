package algorithm.basic;

import java.util.ArrayList;
import java.util.List;

/**
 * Find out all the primes in range [0, n].
 * 
 */
public class PrimesWithInN {

	public List<Integer> primes(int n) {
		List<Integer> res = new ArrayList<Integer>();
		if (n < 2) {
			return res;
		}

		res.add(2);

		for (int i = 3; i <= n; ++i) {
			int squareRoot = (int) Math.sqrt(i);
			boolean valid = true;
			for (int j = 2; j <= squareRoot; ++j) {
				if (i % j == 0) {
					valid = false;
					break;
				}
			}
			if (valid) {
				res.add(i);
			}
		}

		return res;
	}
	
	public void calcPrime(int inp) {
	    ArrayList<Integer> arr = new ArrayList<Integer>();
	    arr.add(2);
	    arr.add(3);

	    int counter = 4;

	    while(arr.size() < inp) {
	        if(counter % 2 != 0 && counter%3 != 0) {
	            int temp = 4;
	            while(temp*temp <= counter) {
	                if(counter % temp == 0)
	                    break;
	                temp ++;
	            }
	            if(temp*temp > counter) {
	                arr.add(counter);
	            }
	        }
	        counter++;
	    }

	    System.out.println("finish" +arr.get(inp-1));
	    }
	

}
