package coding_interview;
import java.util.*;
public class MaxNoOfFruits {
	
	public static int findMaxNoOfFruits(char[] arr) {
		Map<Character,Integer> map = new HashMap<>();
		int windowStart=0;
		int max_fruits=0;
		for(int windowEnd=0;windowEnd<arr.length;windowEnd++) {
			char key=arr[windowEnd];
			map.put(key, map.getOrDefault(key,0)+1);
			while(map.size()>2) {
				key=arr[windowStart];
				map.put(key,map.get(key)-1);
				if(map.get(key)==0)
					map.remove(key);
				windowStart++;
			}
			max_fruits=Math.max(max_fruits, windowEnd-windowStart+1);
		}
		return max_fruits;
	}

	public static void main(String[] args) {
		System.out.println(findMaxNoOfFruits(new char[] {'A','B','C','A','C'}));
		System.out.println(findMaxNoOfFruits(new char[] {'A','B','C','B','B','C'}));
	}

}
