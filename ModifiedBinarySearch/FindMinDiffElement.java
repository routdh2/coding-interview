package coding_interview;

public class MinDiffElement {
	
	public static int findMinDiffElement(int[] arr,int target) {
		//check error conditions
		if(arr==null || arr.length==0)
			return -1;
		int start=0,end=arr.length-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(target==arr[mid])
				return target;
			else if(target>arr[mid])
				start=mid+1;
			else
				end=mid-1;
		}
		if(start>=arr.length)
			return arr[end];
		else if(end<0)
			return arr[start];
		else if(Math.abs(target-arr[start])<Math.abs(target-arr[end]))
			return arr[start];
		else
			return arr[end];
	}

	public static void main(String[] args) {
		System.out.println(findMinDiffElement(new int[] {4,6,10}, 4));
		System.out.println(findMinDiffElement(new int[] {1,3,8,10,15}, 12));
		System.out.println(findMinDiffElement(new int[] {4,6,10}, 17));

	}

}
