/**
 * Jun 5, 2021
 */

/**
 * @author Dheeraj
 *
 */
public class CanSumSolutionRecursion {
	public static void main(String[] args) {
		System.out.println(canSum(17287, new int[]{7,14}));
	}
	static boolean canSum(int targetSum, int[] arr){
		if(targetSum==0){
		return true;
		}
		if(targetSum<0){
		return false;
		}
		boolean canSum = false;
		for(int i=0;i<arr.length;++i){
			canSum = canSum || canSum(targetSum-arr[i],arr);
			if(canSum==true){
			break;
		}
		}
		return canSum;
		}

}
