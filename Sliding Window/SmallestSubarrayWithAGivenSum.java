package coding_interview;

public class SmallestSubarrayWIthAGivenSum {
	
	public static int findLenOfSmallestSubarrayWithaGivenSum(int[] arr,int s) {
		int min_len=Integer.MAX_VALUE;
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum=arr[i];
			if(sum>=s) {
				return 1;
			}
			for(int j=i+1;j<arr.length;j++) {
				sum+=arr[j];
				if(sum>=s) {
					min_len=Math.min(min_len, j-i+1);
					break;
				}
			}
		}
		return min_len!=Integer.MAX_VALUE? min_len : 0;
	}
	
	public static int findLenOfSmallestSubarrayWithaGivenSumUsingSlidingWindow(int[] arr,int s) {
		int windowStart=0;
		int windowSum=0;
		int min_len=Integer.MAX_VALUE;
		for(int windowEnd=0;windowEnd<arr.length;windowEnd++) {//Iterates through each element in arr once O(n)
			windowSum+=arr[windowEnd];
			while(windowSum>=s) {//Continue to reduce the window size by one till sum>=s
				min_len=Math.min(min_len, windowEnd-windowStart+1);
				windowSum-=arr[windowStart];//reduce the window size by one
				windowStart++;
			}
		}
		return min_len!=Integer.MAX_VALUE?min_len:0;
	}

	public static void main(String[] args) {
		int result=findLenOfSmallestSubarrayWithaGivenSumUsingSlidingWindow(new int[] {2,1,5,2,3,2}, 7);
		System.out.println(result);
		result=findLenOfSmallestSubarrayWithaGivenSumUsingSlidingWindow(new int[] {2,1,5,2,8}, 7);
		System.out.println(result);
		result=findLenOfSmallestSubarrayWithaGivenSumUsingSlidingWindow(new int[] {3,4,1,1,6}, 8);
		System.out.println(result);
	}

}
