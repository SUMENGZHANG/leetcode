/**
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。



来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitFour {
    /**
     * 大佬写
     */
    public static int maxProfitAD(int k, int[] prices) {
        int n = prices.length;
        if(n == 0) return 0;

        // 如果k超过了最大可买卖次数，那就将k置为最大买卖次数
        // 最大买卖次数就是天数的一半，如果当前卖出又买入，是没有意义的
        k = Math.min(k, n / 2);

        // 状态表示数组，三个维度分别代表：第几天，手上是否有股票0没有1有，还剩下多少次买卖机会
        // 数组值表示当前还有多少钱
        int[][][] f = new int[n][2][k + 1];
        
        // 设置初始值，第一天手上有股票的状态，就是买入第一天价格的值
        for(int i = 0; i <= k; i++) {
            f[0][1][i] = -prices[0];
        }
        // 状态转移，遍历天数
        for(int i = 1; i < n; i++) {
            // 枚举当天所有可能买卖次数的状态
            for(int j = 0; j <= k; j++) {
                // 当前不持有股票的状态转移
                if(j < k) {
                    // 当前不持有股票，要么前一天也没有股票，要么前一天有股票但是今天卖出了
                    // 如果今天卖出的话，买卖次数就会比前一天少一次，当天是j，那么前一天就是j+1
                    f[i][0][j] = Math.max(f[i - 1][0][j], f[i - 1][1][j + 1] + prices[i]);
                } else {
                    // 剩余买卖次数j等于初始值剩余交易次数k的时候，那么说明从来没有产生过交易，所以需要从前一天的不持有状态转移过来
                    f[i][0][j] = f[i - 1][0][j];
                }

                // 当前持有股票的状态转移，要么前一天也有股票，要么前一天不持有股票但是当天买入了股票
                f[i][1][j] = Math.max(f[i - 1][1][j], f[i - 1][0][j] - prices[i]);
            }
        }

        int res = 0;
        // 获取最大值，最大值肯定出现在当前手上不持有股票的状态
        for(int i = 0; i <= k; i ++) {
            res = Math.max(res, f[n - 1][0][i]);
        }

        return res;


    }
    
    /**
     * 菜鸡学习
     */
    public static int maxProfit(int k, int[] prices) {
        if(prices.length==0) return 0;
        // 买卖不会超过总长度的一半， 买和卖要占两次
        k  = Math.min(k,prices.length/2);
        // k+1 是因为 0-k次 
        // 天数   有无股票  交易剩余次数
        int [][][]dp = new int[prices.length][2][k+1];
        
        //
        for(int i = 0;i<=k;i++){
            dp[0][1][i] = -prices[0];
        }
        
        for(int i = 1;i<prices.length;i++){
            for(int j = 0;j<=k;j++){
                // 目前手上没有股票，说明没买或者买了但是现在卖了(形成一次交易)
                if(j<k){
                    // 上一次交易结束后没有买，现在卖了是上次买入后的状态加钱；
                    dp[i][0][j] = Math.max(dp[i-1][0][j],prices[i]+dp[i-1][1][j+1]);

                }else{
                    // 交易次数到达上线，就维持这个值
                    dp[i][0][j] = dp[i-1][0][j];

                }
           
            // 目前手上有股票，现在刚买，之前就有
            dp[i][1][j] = Math.max(dp[i-1][1][j],dp[i-1][0][j]-prices[i]);

            }
            

        }
        int res = 0;
        for(int i = 0;i<=k;i++){
            res = Math.max(res,dp[prices.length-1][0][i]);
        }
        return res;


    }
    public static void main(String[] args) {
        int []prices = {1,2,4,2,5,7,2,4,9,0};
        int k = 4;
        System.out.println(maxProfit(k, prices));

    }
}
