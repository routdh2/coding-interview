package coding_interview;
import java.util.*;
public class TwoSumUsingHashTable {
	
	public static int[] twoSumUsingHashTable(int[] arr,int target) {
		Map<Integer,Integer> map = new HashMap<>();
		for(int i=0;i<arr.length;i++) {
			int key=target-arr[i];
			if(map.containsKey(key)) {
				return new int[] {map.get(key),i};
			}
			else
				map.put(arr[i],i);
		}
		return new int[] {-1,-1};
	}

	public static void main(String[] args) {
		int[] result=twoSumUsingHashTable(new int[] {1,2,3,4,5},7);
		for(int item:result)
			System.out.print(item+" ");

	}

}
