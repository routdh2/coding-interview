package coding_interview;
import java.util.*;
public class TripletSumCloseToTarget {
	//This runs in O(n*logn+n*2)=O(n*2)
	public static List<Integer> searchTriplet(int[] arr, int K) {
		Arrays.sort(arr);
		List<Integer> triplet = new ArrayList<>();
		int min_diff=Integer.MAX_VALUE;
		for(int i=0;i<arr.length-2;i++) {
			min_diff=searchPair(arr,K-arr[i],i+1,triplet,K,min_diff);
		}
		return triplet;
		
	}
	private static int searchPair(int[] arr, int target, int left, List<Integer> triplet,int K,int min_diff) {
		int right=arr.length-1;	
		int a=-1,b=-1,c=-1;
		
		while(left<right) {
			int sum=arr[left]+arr[right];
			int diff=target-sum;
			if(Math.abs(diff)<min_diff) {
				min_diff=Math.abs(diff);
				a=K-target;
				b=arr[left];
				c=arr[right];
			}
			left++;
		}
		if(a!=-1 && b!=-1 && c!=-1) {
			triplet.clear();
			triplet.addAll(Arrays.asList(a,b,c));
		}
		return min_diff;
	}

	public static void main(String[] args) {
		List<Integer> triplet = searchTriplet(new int[] {-2,0,1,2},2);
		System.out.println(triplet);
		triplet = searchTriplet(new int[] {-3,-1,1,2},1);
		System.out.println(triplet);
		triplet = searchTriplet(new int[] {1,0,1,1},100);
		System.out.println(triplet);

	}

}
