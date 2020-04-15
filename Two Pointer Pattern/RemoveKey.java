package coding_interview;

public class RemoveKey {
	//array is unsorted and we have to remove all instances of key in-place
	public static int removeAllInstancesOfKey(int[] arr,int key) {
		int start=-1;
		for(int i=0;i<arr.length;i++) {
			if(arr[i]!=key) {
				start++;
				arr[start]=arr[i];
			}
		}
		return start+1;
	}
	
	public static void main(String[] args) {
		int length = removeAllInstancesOfKey(new int[] {3,2,3,6,3,10,9,3}, 3);
		System.out.println(length);
		length = removeAllInstancesOfKey(new int[] {2,11,2,2,1}, 2);
		System.out.println(length);
	}

}
