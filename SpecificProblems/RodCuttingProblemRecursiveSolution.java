/**
 * Jun 8, 2021
 */

import java.security.Timestamp;
import java.sql.Time;
import java.time.Instant;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Dheeraj
 *
 *   length[] = [1, 2, 3, 4, 5, 6, 7, 8]
     price [] = [1, 5, 8, 9, 10, 17, 17, 20]
 *
 *	For recursive time complexity is exponential O(n^n)
 *
 *	DP:
 *		target=[0,1,2,3,4,5,6]
 *		f(n)=max(f(n-i)+price(i)) i=1..n if(arr[i]<n))
 *		f(n)=0 if n==0
 *
 *	Time Complexity: O(n^2) space: O(n)
 *
 */
public class RodCuttingProblemRecursiveSolution {

	static int length[]=new int[]{1, 2, 3, 4, 5, 6, 7, 8};
	static int prices[]=new int[]{1, 5, 8, 9, 10, 17, 17, 20};
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(new Date().toInstant());
		System.out.println(getMaxProfitFor(34));
		System.out.println(new Date().toInstant());
	}
	static int getMaxProfitFor(int rodLength){
		int max = 0;
		if(rodLength==0){
			return 0;
		}
		
		for (int i = 0; i < length.length; i++) {
		int temporaryResult = 0;
		if(length[i]<=rodLength){
			temporaryResult = prices[i]+getMaxProfitFor(rodLength-length[i]);
		}
		if(temporaryResult>max){
			max=temporaryResult;
		}
		
		}
		
		
		
		return max;
		
	}

}
