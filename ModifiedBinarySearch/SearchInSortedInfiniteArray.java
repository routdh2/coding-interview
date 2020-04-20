package coding_interview;

class ArrayReader {
	int[] arr;
	
	public ArrayReader(int[] arr) {
		this.arr=arr;
	}
	
	public int get(int index) {
		if(index>=arr.length)
			return Integer.MAX_VALUE;
		else
			return arr[index]; 
	}
	
}

public class SearchInSortedInfiniteArray {
	
	public static int findIndex(ArrayReader reader, int target) {
		
		//first find out the bounds
		int start=0,end=1;
		while(target>reader.get(end)) {
			int prev_end=end;
			end+=(end-start+1)*2;
			start=prev_end+1;
		}
		return binarySearch(reader,target,start,end);
	}
	
	public static int binarySearch(ArrayReader reader, int target, int start, int end) {
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(target==reader.get(mid))
				return mid;
			else if(target>reader.get(mid))
				start=mid+1;
			else
				end=mid-1;
		}
		return -1;
	}

	public static void main(String[] args) {
		ArrayReader reader = new ArrayReader(new int[] {4,6,8,10,12,14,16});
		System.out.println(findIndex(reader,16 ));

	}

}
