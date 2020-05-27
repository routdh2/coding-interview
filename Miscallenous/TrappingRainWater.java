//Problem Statement: https://leetcode.com/problems/trapping-rain-water/
class Solution {
    public int trap(int[] height) {
        if(height==null || height.length==0)
            return 0;
        //take two arrays to store leftMax and rightMax for each height
        int[] leftMax=new int[height.length];
        int[] rightMax=new int[height.length];
        for(int i=0;i<height.length;i++) {
            if(i==0)
                leftMax[i]=height[i];
            else
                leftMax[i]=Math.max(leftMax[i-1],height[i]);
        }
        for(int i=height.length-1;i>=0;i--) {
            if(i==height.length-1)
                rightMax[i]=height[i];
            else
                rightMax[i]=Math.max(rightMax[i+1],height[i]);
        }
        int ans=0;
        for(int i=0;i<height.length;i++) {
            ans+=Math.min(leftMax[i],rightMax[i])-height[i];
        }
        return ans;
        
    }
    
    public int trap2(int[] height) {
        if(height==null || height.length==0)
            return 0;
        int leftMax=0,rightMax=0;
        int left=0,right=height.length-1;
        int ans=0;
        while(left<right) {
            if(height[left]<height[right]) {
                if(height[left]>leftMax)
                    leftMax=height[left];
                else
                    ans+=leftMax-height[left];
                left++;
            }
            else {
                if(height[right]>rightMax)
                    rightMax=height[right];
                else
                    ans+=rightMax-height[right];
                right--;
            }
        }
        return ans;
    }
}
