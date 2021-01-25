/**
 * 最长子序列
 * */
public class MaxSubArray {
    /**
     * 动态规划
     */
    public static int maxSubArray(int []nums){
        int res = nums[0];
        int pre = 0;
        for (int num : nums) {
            // if pre<0 丢弃
            pre = Math.max(num,pre+num);
            // 记录 当前的和与最大值比较
            res = Math.max(res,pre);
            
        }
        return res;

    }
    public static int maxSubArrayDP(int []nums){
        int len = nums.length;
        int max = Integer.MIN_VALUE;
        for(int i = 1;i<len;i++){
            if(nums[i-1]>0){
                nums[i] +=nums[i-1];
                
            }
            max = Math.max(max,nums[i]);
        }
        return max;
        

    }
    public static void main(String[] args) {
        int []nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray(nums));
    }
    
}
