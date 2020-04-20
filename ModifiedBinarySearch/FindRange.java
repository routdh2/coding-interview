package coding_interview;

public class NumberRange {
	
	public static int[] findRange(int[] arr,int target) {
		//error conditions
		int[] result=new int[] {-1,-1};
		if(arr==null || arr.length==0)
			return result;
		result[0]=findIndex(arr,target,false);
		if(result[0]!=-1)
			result[1]=findIndex(arr,target,true);
		return result;
	}
	
	public static int findIndex(int[] arr,int target, boolean startFound) {
		int start=0,end=arr.length-1;
		int index=-1;
		while(start<=end) {
			int mid=start+(end-start)/2;
			if(arr[mid]==target) {
				index=mid;
				if(startFound) {
					start=mid+1;
				}
				else
					end=mid-1;
			}
			else if(target>arr[mid])
				start=mid+1;
			else
				end=mid-1;
		}
		return index;
	}

	public static void main(String[] args) {
		int[] result = findRange(new int[] {4,6,6,6,9},6);
		System.out.println(result[0]+" "+result[1]);
		
		result = findRange(new int[] {1,3,8,10,15},10);
		System.out.println(result[0]+" "+result[1]);
		
		result = findRange(new int[] {1,3,8,10,15},12);
		System.out.println(result[0]+" "+result[1]);
	}

}
