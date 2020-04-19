package coding_interview;

public class NextLetter {
	
	public static char nextLetter(char[] arr,char target) {
		if(arr==null || arr.length==0)
			return '1';
		int start=0,end=arr.length-1;
		int index=-1;
		boolean found=false;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) {
				found=true;
				index=mid+1;
				break;
			}
			else if(target>arr[mid]) {
				start=mid+1;
			}
			else
				end=mid-1;
		}
		//if target is found
		if(found) {
			return index>=arr.length?arr[0]:arr[index];
		}
		else {
			return start>=arr.length?arr[0]:arr[start];
		}
	}

	public static void main(String[] args) {
		System.out.println(nextLetter(new char[] {'a','c','f','h'}, 'f'));
		System.out.println(nextLetter(new char[] {'a','c','f','h'}, 'b'));
		System.out.println(nextLetter(new char[] {'a','c','f','h'}, 'm'));
		System.out.println(nextLetter(new char[] {'a','c','f','h'}, 'h'));
		
	}

}
