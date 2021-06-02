/**
 * Jun 2, 2021
 */
package com.interview;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Dheeraj
 *
 * consider array as: 
 * 		
 * 	target =28 
 * 
 * 		5, 4, 8, 6, 7, 3, 2, 15
 *      
 *      init map with sum-a[k],k for k=0...n-1;
 *      26,0
 *      25,1
 *      24,2
 *      23,3
 *      22,4
 *      21,5
 *      20,6
 *      13,7
 *      
 *      i=0...len-1
 *      j=0..len-1
 *      if(map.containsKey(a[i]+a[j])) return i,j,map.get(a[i]+a[j]) k!=i &&k!=j
 *       
 *      
 *
 */
public class ThreeSumInArray {
public static void main(String[] args) {
	int[] arr = new int[]{5,4,8,6,7,3,2,15};
	Map<Integer, Integer> remainingSum = new HashMap<>();
	int target = 28;
	for(int k=0;k<arr.length;++k){
		remainingSum.put(target-arr[k], k);
	}
	for(int i=0;i<arr.length;i++){
		for(int j=i+1;j<arr.length;j++){
			int temp = arr[i]+arr[j];
			if(remainingSum.containsKey(temp)){
				if(remainingSum.get(temp)!=i && remainingSum.get(temp)!=j){
					System.out.println(i+" "+j+" "+remainingSum.get(temp));
					System.exit(1);
				}
			}
		}
	}
	
}
}
