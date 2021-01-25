/**
 *  leetcode 188
 * 给定一个整数数组 prices ，它的第 i 个元素 prices[i] 是一支给定的股票在第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-iv
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitAd {
    /**
     * 
     * 当前手上有股票：
     * 1. 卖
     * 2. 不卖
     * 当前受伤无股票
     * 1. 买
     * 2. 不买
     * @param k
     * @param prices
     * @return
     */
    public static int maxProfit(int k, int[] prices) {
         int len = prices.length;
         // 长度为0
         if(len==0) return 0;
         // 最多的执行次叔是价格长度的一半，为买和卖连续发生
         k = Math.min(k,len/2);
         // 存储当前天的最优解（一个局部最优方案） 当前有无股票的状态  剩余的买卖次叔
         int [][][]dp = new int [len][2][k+1];
         // 第一天无论是第几次交易，都是减去第一天你的股票钱
         for(int i = 0;i<=k;i++){
             dp[0][1][i] = -prices[0];
         }

         for(int i = 1;i<len;i++){
             for(int j = 0;j<=k;j++){
                 // 当前手上没有股票分为  有股票但是现在卖掉（完成一次交易，如果交易次叔达到上线，就不能交易，那么最优解维持上一次交易的最优解） 和 没有买
                 if(j<k){
                     dp[i][0][j] = Math.max(dp[i-1][1][j+1]+prices[i],dp[i-1][0][j]);

                 }else{
                     dp[i][0][j] = dp[i-1][0][j];

                 }
                 // 当前有股票分为  刚买和之前的没卖
                 dp[i][1][j] = Math.max(dp[i-1][1][j], dp[i-1][0][j]-prices[i]);
             }
         }

         // 卖了肯定比没卖的赚的多
         int res = 0;
         for(int i = 0;i<=k;i++){
             res = Math.max(dp[len-1][0][i],res);
         }

         return res;

    }
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        int k = 1;
        System.out.println(maxProfit(k, prices));
        
    }
}
