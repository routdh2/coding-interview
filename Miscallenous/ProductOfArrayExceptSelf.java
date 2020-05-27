class Solution {
    public int[] productExceptSelf(int[] nums) {
        if(nums==null || nums.length==0)
            return new int[]{};
        int[] result = new int[nums.length];
        for(int i=0;i<nums.length;i++) {
            if(i==0)
                result[i]=1;
            else
                result[i]=result[i-1]*nums[i-1];
        }
        int R=1;
        for(int i=nums.length-1;i>=0;i--) {
            
            result[i]=result[i]*R;
            R=R*nums[i];
        }
        return result;
        
    }
}
