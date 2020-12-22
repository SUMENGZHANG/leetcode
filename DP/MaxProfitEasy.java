/**
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。

如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。

注意：你不能在买入股票前卖出股票。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxProfitEasy {
    /**
     * 贪心算法
     * @param prices
     * @return
     */
    public static int maxProfit(int[] prices) {
        int maxProfit = 0;
        int buy = prices[0];

        for(int i = 1;i<prices.length;i++){
            if(prices[i]<buy){
                buy = prices[i];
            }else if(prices[i]>buy){
                maxProfit = Math.max(prices[i]-buy, maxProfit);
            }
        }
        return maxProfit;

    }
    /**
     * 动态规划怎么实现
     * 
     * @param args
     */
    public static int maxProfitWithDP(int[] prices) {
        int []dp = new int[prices.length];
        dp[0] = 0;
        int min = prices[0];
        for(int i = 1;i<prices.length;i++){
             min = Math.min(prices[i],min);
            dp[i] = Math.max(dp[i-1],prices[i]-min);
        }
        return dp[prices.length-1];
        
         
    }
    public static void main(String[] args) {
        int []prices = {7,1,5,3,6,4};
        System.out.println(maxProfitWithDP(prices));
    }
    
}
