/**
 * May 31, 2021
 */

/**
 * @author Dheeraj
 *
 */
public class MergeSort {
	static int[] a=new int[]{4,1,2,8,0,3};
	
	public static void mergeSort(int[] arr,int left, int right){
		if(left<right){
			int mid=(left+right)/2;
			mergeSort(arr, left, mid);
			mergeSort(arr, mid+1, right);
			merge(arr,left,right);
			}
	}
	
	public static void main(String[] args) {
	mergeSort(a , 0, 5);
	for(int i:a)
	System.out.print(i);
	
	}
	
	
	public static void merge(int[] arr,int left,int right){
		int mid=(left+right)/2;
		int[] temp=new int[right-left+1];
		int i=left;int j=mid+1;
		int index=0;
		while(i<=mid && j<=right){
			if(arr[i]<arr[j]){
				temp[index++]=arr[i++];
			}else{
				temp[index++]=arr[j++];
			}
		}
		if(i>mid){
			while(j<=right){
				temp[index++]=arr[j++];
			}
		}
		else{
			while(i<=mid){
				temp[index++]=arr[i++];
			}
		}
		for(int k=left;k<=right;k++){
			arr[k]=temp[k-left];
		}
	}
}
