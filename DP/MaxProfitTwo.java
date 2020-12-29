/**
 * 买卖股票的最佳时机二
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。

注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。

作者：力扣 (LeetCode)
链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2zsx1/
来源：力扣（LeetCode）
著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class MaxProfitTwo {
    public static int getMaxProfit(int []prices){
        int [][]dp = new int[prices.length][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        
        for(int i = 1;i<prices.length;i++){
            // 有股票分为现在买和之前就没卖
            dp[i][1] = Math.max(dp[i-1][1],dp[i-1][0]-prices[i]);
        
            // 无股票 分为刚卖的和现在不买
            dp[i][0] = Math.max(dp[i-1][0],prices[i]+dp[i-1][1]);

        }

        return dp[prices.length-1][0];

        

    }
    public static int getMaxProfitWithGreedy(int []prices){
        int res = 0;
        for(int i = 1;i<prices.length;i++){
            if(prices[i]>prices[i-1]){
                res += prices[i]-prices[i-1];

            }
        }
        return res;
    }
    public static void main(String[] args) {
        int []prices = {1,3,4,7};
        System.out.println(getMaxProfitWithGreedy(prices));
        
    }

    
}
