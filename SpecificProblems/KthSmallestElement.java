/**
 * Jun 7, 2021
 */

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @author Dheeraj
 *
 *	The idea is to create a maxHeap
 *	add first k elements in the max heap
 *	add the elements which follow only when the element is less than the root of max heap
 *
 *the solution takes O(nlog(k)) time
 *
 */
public class KthSmallestElement{



static int getKthSmallestElementFor(int[] arr, int k){
if(k>arr.length){
return -1;
}

PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
for(int i=0;i<k;++i){
maxHeap.offer(arr[i]);
}
for(int i=k;i<arr.length;i++){
if(arr[i]<maxHeap.peek()){
maxHeap.poll();
maxHeap.offer(arr[i]);
}
}
return maxHeap.peek();
}

public static void main(String args[]){

int arr[] =new int[]{4,8,9,2,100,76,22,88};
System.out.println(getKthSmallestElementFor(arr, 3));
}
}

