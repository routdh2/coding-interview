package coding_interview;
import java.util.Arrays;

public class AverageOfSubarrayOfSizeK {
	public static double[] findAverages(int K,int[] arr) {
		double[] result= new double[arr.length-K+1];
		double windowSum=0;
		int windowStart=0;
		for(int windowEnd=0;windowEnd<arr.length;windowEnd++) { //Iterate through array one at a time O(n)
			windowSum+=arr[windowEnd]; //At each iteration, you add current element to windowSum
			if(windowEnd>=K-1) { //If for the first time windows hits the required size
				result[windowStart]=windowSum/K; //process the window object
				windowSum-=arr[windowStart];// reduce the window size by one
				windowStart++;
				
			}
			
		}
		return result;
	}
	
	public static void main(String[] args) {
		double[] result=AverageOfSubarrayOfSizeK.findAverages(5, new int[] {1,3,2,6,-1,4,1,8,2});
		System.out.println("Averages of subarrays of size K:"+Arrays.toString(result));
		
	}

}
