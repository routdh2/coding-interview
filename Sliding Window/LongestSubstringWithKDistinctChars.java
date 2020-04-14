package coding_interview;
import java.util.*;
public class LongestSubstringWithKDistinctChars {
	/*
	 * This runs in O(n+n) = O(n) time
	 */
	public static int findLongestSubstringWithKDistinctChars(String str, int k) {
		if(str==null || str.length()==0 || str.length()<k)
			throw new IllegalArgumentException();
		
		int windowStart=0;
		int maxLength=0;
		Map<Character,Integer> charFrequencyMap = new HashMap<>();
		for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
			char rightChar=str.charAt(windowEnd);
			charFrequencyMap.put(rightChar,charFrequencyMap.getOrDefault(rightChar, 0)+1);//Keep increasing the window size as long as we meet the condition size(map)<=k
			while(charFrequencyMap.size()>k) { //if the no of distinct chars > K, then reduce the window size
				char leftChar=str.charAt(windowStart);
				charFrequencyMap.put(leftChar,charFrequencyMap.get(leftChar)-1);
				if(charFrequencyMap.get(leftChar)==0)
					charFrequencyMap.remove(leftChar);
				windowStart++;
			}
			maxLength=Math.max(maxLength, windowEnd-windowStart+1);
		}
		return maxLength;
	}
	
	public static void main(String[] args) {
		System.out.println(findLongestSubstringWithKDistinctChars("araaci",2));
		System.out.println(findLongestSubstringWithKDistinctChars("araaci",1));
		System.out.println(findLongestSubstringWithKDistinctChars("cbbebi",3));

	}

}
