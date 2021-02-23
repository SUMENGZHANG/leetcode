/**
 *  leetcode 300 最长递增子序列
 */
public class LengthOfLis {
    /**
     * 动态规划
     * @param nums
     * @return
     */
    public int lengthOfLIS(int[] nums) {
        if(nums.length==0) return 0;
        int maxLen = 0;
        int []dp = new int[nums.length];
        dp[0] = 1;
        for(int i = 1;i<nums.length;i++){
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxLen = Math.max(maxLen,dp[i]);

        }
        return maxLen;

       

    }
}
