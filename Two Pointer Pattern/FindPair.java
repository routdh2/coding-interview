package coding_interview;

public class FindPair {
	//array is sorted
	//use two-pointer approach to find the pair in O(n) time
	public static int[] findPair(int[] arr,int target) {
		int start=0,end=arr.length-1;
		while(start<end) {
			int sum = arr[start]+arr[end];
			if(sum==target)
				return new int[] {arr[start],arr[end]};
			else if(sum>target)
				end--;
			else
				start++;
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		int[] result = findPair(new int[] {1,2,3,4,5},7);
		for(int item : result)
			System.out.print(item+" ");

	}

}
