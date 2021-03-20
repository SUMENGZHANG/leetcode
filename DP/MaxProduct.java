/**
 *  leetcode 152
 */
public class MaxProduct {
    public int maxProduct(int[] nums){
        // int [][]dp = new int[nums.length][2];
        // dp[0][0] = nums[0];
        // dp[0][1] = nums[0];
        // int max = nums[0];
        int max = nums[0];
        int minPre = nums[0];
        int maxPre = nums[0];
        for(int i =1;i<nums.length;i++){
               
               int minVal = minPre;
               int maxVal = maxPre;
               maxPre = Math.max(minVal*nums[i],Math.max(maxVal*nums[i],nums[i]));
               minPre= Math.min(maxVal*nums[i],Math.min(nums[i],nums[i]*minVal));
               max = Math.max(max,maxPre);
        }
        return max;


    }
    
}
