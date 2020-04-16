package coding_interview;

import java.util.Arrays;
import java.util.*;

public class CountAllTriplets {
	//Just counting triplets: TC - O(n*logn+n*2)=O(n*2)
	//List all such triplets: TC - O(n*logn+n*3)=O(n*3)
	public static int countTriplets(int[] arr, int K) {
		if(arr==null || arr.length<3)
			throw new IllegalArgumentException();
		Arrays.sort(arr);
		List<List<Integer>> triplets = new ArrayList<>();
		int count=0;
		for(int i=0;i<arr.length-2;i++) {
			count=searchPair(arr,K-arr[i],i+1,count,triplets,K);
		}
		System.out.println(triplets);
		return count;
	}
	
	private static int searchPair(int[] arr, int target, int left, int count, List<List<Integer>> triplets,int K) {
		int right=arr.length-1;
		while(left<right) {
			int sum=arr[left]+arr[right];
			if(sum<target) {
				int t_left=left,t_right=right;
				while(t_left<t_right) {
					triplets.add(Arrays.asList(K-target, arr[t_left],arr[t_right]));
					t_right--;
				}
				count+=(right-left);
				left++;
			}
			else
				right--;
		}
		return count;
	}

	public static void main(String[] args) {
		int count=countTriplets(new int[] {-1,0,2,3}, 3);
		System.out.println(count);
		
		count=countTriplets(new int[] {-1,4,2,1,3}, 5);
		System.out.println(count);

	}

}
