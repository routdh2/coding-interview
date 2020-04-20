package coding_interview;

public class SearchBitonicArray {
	
	public static int searchBitonicArray(int[] arr,int target) {
		//error conditions
		if(arr==null || arr.length==0)
			return -1;
		//first find the maxindex in arr
		int maxIndex = findMaxIndex(arr);
		int targetIndex=binarySearch(arr,0,maxIndex,target);
		if(targetIndex!=-1)
			return targetIndex;
		else
			return binarySearch(arr,maxIndex+1,arr.length-1,target);
	}
	
	public static int findMaxIndex(int[] arr) {
		int start=0,end=arr.length-1;
		while(start<end) {
			int mid=start+(end-start)/2;
			if(arr[mid]<arr[mid+1])
				start=mid+1;
			else
				end=mid;
		}
		return start;
	}
	
	public static int binarySearch(int[] arr, int start,int end, int target) {
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(target==arr[mid])
				return mid;
			else if(arr[start]<arr[end]) {//increasing order
				if(target>arr[mid]) {
					start=mid+1;
				}
				else
					end=mid-1;
			}
			else {//decreasing order
				if(target>arr[mid])
					end=mid-1;
				else
					start=mid+1;
				
			}
		}
		return -1;
			
	}

	public static void main(String[] args) {
		System.out.println(searchBitonicArray(new int[] {1,3,8,4,3}, 4));
		System.out.println(searchBitonicArray(new int[] {3,8,3,1}, 8));
		System.out.println(searchBitonicArray(new int[] {1,3,8,12}, 12));
		System.out.println(searchBitonicArray(new int[] {10,9,8}, 10));

	}

}
