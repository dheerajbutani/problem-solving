/**
 * June 01, 2021
 */


/**
 * @author Dheeraj
 *
 */
public class QuickSort {
	static int[] a=new int[]{4,1,2,8,0,3};
	public static void main(String[] args) {
	quicksort(a , 0, 5);
	for(int i:a)
	System.out.print(i);
	}
	static void quicksort(int[] arr, int beg, int end){
		if(beg<end){
			int loc = partition(arr, beg, end);
			quicksort(arr, beg, loc-1);
			quicksort(arr, loc+1, end);
		}

	}
	static int partition(int[] arr, int beg, int end){
		int pivot = beg;
		int flag=0;
		while (flag!=1) {
			
		
		while(arr[pivot]<arr[end]){
			end--;
		}
		if(end==pivot){
		flag=1;	
		}
		if(arr[pivot]>arr[end]){
			int tmp=arr[end];
			arr[end]=arr[pivot];
			arr[pivot]=tmp;
			pivot=end;
		}
		if(flag==0){
			while (arr[pivot]>arr[beg]) {
				beg++;
			}
			if(pivot==beg){
				flag=1;
			}
			if(arr[pivot]<arr[beg]){
				int tmp=arr[beg];
				arr[beg]=arr[pivot];
				arr[pivot]=tmp;
				pivot=beg;	
			}
		}
		}
	System.out.println(pivot);
		return pivot;
}
}