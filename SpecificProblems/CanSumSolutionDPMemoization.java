/**
 * Jun 5, 2021
 */

import java.util.Arrays;

/**
 * @author Dheeraj
 *
 */
public class CanSumSolutionDPMemoization {

	static int lookup[];
	public static void main(String[] args) {
		int targetSum =1002; 
		lookup =new int[targetSum+1];
		Arrays.fill(lookup,-1);

		System.out.println(canSum(targetSum, new int[]{7,3}));
	}
static boolean canSum(int targetSum, int[] arr){
if(targetSum==0){
	lookup[targetSum]=1;
	return true;
	}

	if(targetSum<0){
	return false;
	}

boolean canSum = false;

	if(lookup[targetSum]==-1){

	for(int i=0;i<arr.length;++i){
	canSum = canSum || canSum(targetSum-arr[i],arr);
		if(canSum){
			lookup[targetSum]=1;
			break;
		}
	}
}
if(!canSum){
	lookup[targetSum]=0;
}

return lookup[targetSum]==1;

}
}