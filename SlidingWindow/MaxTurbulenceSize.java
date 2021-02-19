/**
 * leetcode 978
 */
public class MaxTurbulenceSize {
    public static int maxTurbulenceSize(int[] arr){
        int len = arr.length;
        // 滑动窗口
        int left  =0;
        int right = 0;
        int maxLen = 1;
        while(right<len-1){
            // 如果
            if(left==right){
                if(arr[left]==arr[left+1]){
                    left++;
                }
                right++;

            }else{
                if(arr[right-1]<arr[right]&&arr[right]>arr[right+1]){
                    right++;
                }else if(arr[right-1]>arr[right]&&arr[right]<arr[right+1]){
                    right++;
                }else{
                    left = right;
                }
            }
            maxLen = Math.max(maxLen,right-left+1);
        }
        return maxLen;

      

    }
    /**
     * 动态规划解决
     */

    public static int maxTurbulenceSizeWithDp(int[] arr){
        int len = arr.length;
        int [][]dp = new int[len][2];
        dp[0][0] = dp[0][1]=1;
        for(int i = 1;i<len;i++){
            dp[i][0] = dp[i][1] = 1;
            if(arr[i]>arr[i-1]){
                dp[i][1] = dp[i-1][0]+1;

            }else if(arr[i]<arr[i-1]){
                dp[i][0]= dp[i-1][1]+1;

            }
        }
        int max = 1;
        for(int i = 0;i<len;i++){
            max = Math.max(max,dp[i][0]);
            max = Math.max(max,dp[i][1]);
        }
        return max;

    }

    /**
     * 动态规划简约版
     */
    public static int maxTurbulenceSizeWithDpPro(int[] arr){
        int ret = 1;
        int n = arr.length;
        int dp0 = 1, dp1 = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] > arr[i]) {
                dp0 = dp1 + 1;
                dp1 = 1;
            } else if (arr[i - 1] < arr[i]) {
                dp1 = dp0 + 1;
                dp0 = 1;
            } else {
                dp0 = 1;
                dp1 = 1;
            }
            ret = Math.max(ret, dp0);
            ret = Math.max(ret, dp1);
        }
        return ret;

    }
    public static void main(String[] args) {
        int []arr = {9,4,2,10,7,8,8,1,9};
        System.out.println(maxTurbulenceSizeWithDp(arr));

    }
}
