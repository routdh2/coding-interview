package coding_interview;

public class SquaringSortedArray {
	//array is sorted and can contain negative nos
	public static int[] squareSortedArray(int[] arr) {
		int[] square = new int[arr.length];
		int index=arr.length-1;
		for(int left=0,right=arr.length-1;left<=right;) {
			int squareLeft =arr[left]*arr[left];
			int squareRight=arr[right]*arr[right];
			if(squareLeft>squareRight) {
				square[index]=squareLeft;
				left++;
			}
			else {
				square[index]=squareRight;
				right--;
			}
			index--;
		}
		return square;
	}

	public static void main(String[] args) {
		int[] result=squareSortedArray(new int[] {-2,-1,0,2,3});
		for(int item:result)
			System.out.print(item+" ");

	}

}
