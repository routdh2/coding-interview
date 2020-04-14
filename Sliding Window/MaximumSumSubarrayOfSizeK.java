package coding_interview;

public class MaximumSumSubarrayOfSizeK {
	/*
	 * This is O(n*k) solution -- Bruteforce
	 */
	public static int findMaxSumSubarrayOfSizeK(int[] arr,int K) {
		int max_sum=Integer.MIN_VALUE;
		int sum=0;
		for(int i=0;i<arr.length-K+1;i++) {
			sum=0;
			for(int j=0;j<K;j++) {
				sum+=arr[i+j];
			}
			max_sum=Math.max(max_sum, sum);
		}
		return max_sum;
	}
	/*
	 * This is O(n) solution -- Using sliding window
	 */
	public static int findMaxSumSubarrayOfSizeKUsingSlidingWindow(int[] arr,int K) {
		int max_sum=Integer.MIN_VALUE;
		int windowSum=0;
		int windowStart=0;
		for(int windowEnd=0;windowEnd<arr.length;windowEnd++) { //This iterates through whole arr O(n)
			windowSum+=arr[windowEnd]; //each time we add to windowSum
			if(windowEnd>=K-1) {//If it hits the window size
				max_sum=Math.max(max_sum, windowSum);//Process the result
				windowSum-=arr[windowStart];//decrease the window size by 1
				windowStart++;
			}
		}
		return max_sum;
	}

	public static void main(String[] args) {
		int result=findMaxSumSubarrayOfSizeKUsingSlidingWindow(new int[] {2,1,5,1,3,2}, 3);
		System.out.println(result);

	}

}
