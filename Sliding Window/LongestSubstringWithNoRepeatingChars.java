package coding_interview;
import java.util.*;
public class LongestSubstringWithNoRepeatingChars {
	
	public static int longestSubstringWithNoRepeatingChars(String str) {
		Map<Character,Integer> map = new HashMap<>();
		int windowStart=0;
		int max_len=0;
		for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
			char key = str.charAt(windowEnd);
			map.put(key,map.getOrDefault(key,0)+1);//map storing the char and the count
			while(map.get(key)>1) {//when we have the key already
				char startChar=str.charAt(windowStart);
				map.put(startChar,map.get(startChar)-1);
				if(map.get(startChar)==0)
					map.remove(startChar);
				windowStart++;
			}
			max_len=Math.max(max_len, windowEnd-windowStart+1);
			
		}
		return max_len;
		
	}
	
	public static int findLength(String str) {
		int windowStart=0,maxLength=0;
		Map<Character,Integer> charIndexMap = new HashMap<>();
		for(int windowEnd=0;windowEnd<str.length();windowEnd++) {
			char rightChar = str.charAt(windowEnd);
			if(charIndexMap.containsKey(rightChar)) {
				windowStart=Math.max(windowStart, charIndexMap.get(rightChar)+1);
				
			}
			charIndexMap.put(rightChar,windowEnd); //Map storing the char and index
			maxLength=Math.max(maxLength, windowEnd-windowStart+1);
		}
		return maxLength;
	}

	public static void main(String[] args) {
		System.out.println(longestSubstringWithNoRepeatingChars("abccde"));

	}

}
