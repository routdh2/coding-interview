package coding_interview;
import java.util.*;
public class AllUniqueTriplets {
	//Total time complexity: O(nlogn+n*2)=O(n*2)
	public static List<List<Integer>> searchTriplets(int[] arr) {
		List<List<Integer>> triplets = new ArrayList<>();
		Arrays.sort(arr);
		for(int i=0;i<arr.length-2;i++) {
			if(i>0 && arr[i]==arr[i-1])
				continue;
			searchPair(arr, -arr[i], i+1, triplets);
		}
		return triplets;
	}
	
	private static void searchPair(int[] arr, int target, int left, List<List<Integer>> triplets) {
		int right = arr.length-1;
		while(left<right) {
			int sum=arr[left]+arr[right];
			if(sum==target) {
				triplets.add(Arrays.asList(-target,arr[left],arr[right]));
				left++;
				right--;
				while(left<right && arr[left]==arr[left-1])
					left++;
				while(left<right && arr[right]==arr[right+1])
					right--;
			}
			else if(sum>target) {
				right--;
			}
			else
				left++;
		}
	}

	public static void main(String[] args) {
		List<List<Integer>> triplets = searchTriplets(new int[] {-3,0,1,2,-1,1,-2});
		System.out.println(triplets);

	}

}
