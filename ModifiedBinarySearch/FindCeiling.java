package coding_interview;

public class FindCeiling {
	
	public static int findCeiling(int[] arr, int target) {
		//error conditions
		if(arr==null || arr.length==0)
			return -1;
		int start=0,end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target)
				return mid;
			else if(target>arr[mid])
				start=mid+1;
			else
				end=mid-1;
		}
		return start>=arr.length ? -1 : start;
	}

	public static void main(String[] args) {
		System.out.println(findCeiling(new int[]{4,6,10},6));
		System.out.println(findCeiling(new int[]{1,3,8,10,15},12));
		System.out.println(findCeiling(new int[]{4,6,10},17));
		System.out.println(findCeiling(new int[]{4,6,10},-1));

	}

}
