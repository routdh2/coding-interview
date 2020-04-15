package coding_interview;

public class RemoveDuplicates {
	//Remove duplicates from sorted array using two-pointer approach
	public static int remove(int[] arr) {
		int start=0;
		for(int i=1;i<arr.length;i++) {
			if(arr[i]!=arr[start]) {
				start++;
				arr[start]=arr[i];
			}
		}
		return start+1;
	}

	public static void main(String[] args) {
		int[] arr = new int[] {2,3,3,3,6,9,9};
		System.out.println(remove(arr));

	}

}
