/**
 * Jun 8, 2021
 */

import java.time.Instant;
import java.util.Arrays;
import java.util.Date;

/**
 * @author Dheeraj
 *
 */
public class RodCuttingProblemDynamicProgrammingSolution {

	/**
	 * @param args
	 */
		static int length[]=new int[]{1, 2, 3, 4, 5, 6, 7, 8};
		static int prices[]=new int[]{1, 5, 8, 9, 10, 17, 17, 20};
		static int target[];
		public static void main(String[] args) {
			// TODO Auto-generated method stub
			target = new int[101];
			Arrays.fill(target, -1);
			System.out.println(new Date().toInstant());
			System.out.println(getMaxProfitFor(32));
			System.out.println(new Date().toInstant());
		}
		static int getMaxProfitFor(int rodLength){
			int max=0;
			if(rodLength==0){
				return 0;
			}
			if(target[rodLength]!=-1){
				return target[rodLength];
			}
			for(int i=0;i<length.length;i++){
			int temporaryResult = 0;
			if(length[i]<=rodLength){
				temporaryResult = prices[i]+getMaxProfitFor(rodLength-length[i]);
				
			}
			if(temporaryResult>max){
				max=temporaryResult;
			}
			}
			target[rodLength]=max;
			
			return max;
		}
}
