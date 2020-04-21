package coding_interview;

public class FindRotationCount {
	
	public static int findRotationCount(int[] arr) {
		if(arr==null || arr.length==0)
			return 0;
		return findPivotIndex(arr);
	}
	public static int findPivotIndex(int[] arr) {
		int start=0,end=arr.length-1;
		while(start<end) {
			int mid=start+(end-start)/2;
			if(arr[start]<=arr[mid]) {
				if(arr[start]<arr[end])
					return start;
				else
					start=mid+1;
			}
			else
				end=mid;
		}
		return start;
	}

	public static void main(String[] args) {
		System.out.println(findRotationCount(new int[] {10,15,1,3,8}));
		System.out.println(findRotationCount(new int[] {4,5,7,9,10,-1,2}));
		System.out.println(findRotationCount(new int[] {1,3,8,10}));
		//this works for duplicates as well
		System.out.println(findRotationCount(new int[] {3,3,7,3}));

	}

}
