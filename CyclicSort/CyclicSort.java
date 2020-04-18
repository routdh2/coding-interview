package coding_interview;

public class CyclicSort {
	
	public static void sort(int[] nums) {
		for(int current_index=0;current_index<nums.length;) {
			int correct_index=nums[current_index]-1;
			if(current_index==correct_index) {
				current_index++;
			}
			else {
				swap(nums,current_index,correct_index);
			}
		}
		for(int item:nums) {
			System.out.print(item+" ");
		}
		System.out.println();
	}
	public static void swap(int[] nums,int i, int j) {
		int temp=nums[i];
		nums[i]=nums[j];
		nums[j]=temp;
	}

	public static void main(String[] args) {
		
		sort(new int[] {2,6,4,3,1,5});
		sort(new int[] {3,1,5,4,2});
		sort(new int[] {1,5,6,4,3,2});
	}

}
