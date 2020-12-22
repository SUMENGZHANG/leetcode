/**
 * 给定一个整数数组 prices，其中第 i 个元素代表了第 i 天的股票价格 ；非负整数 fee 代表了交易股票的手续费用。

你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。

返回获得利润的最大值。

注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。

示例 1:

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/best-time-to-buy-and-sell-stock-with-transaction-fee
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 1 3 2 8 4 9 
 */
public class MaxProfit {
    
    /**  动态规划，找到状态转移方程
     * 1. 每一个点分为四种状态
     *  * 有股票
     *     * 本来就有
     *     * 现在买
     *  * 无股票
     *     * 本来就没有
     *     * 本来有的，今天卖了
     * 
     * 2. 基础逻辑就是最后肯定卖了比不卖好
     * 
     */
    public static  int maxProfit(int[] prices, int fee) {
        // 创建一个二位数组存储值和状态
        int [][] valueAndStatus = new int[prices.length][2];
        // 没有股票说明没买，
        valueAndStatus[0][0] = 0;
        // 有股票，买了就要扣钱
        valueAndStatus[0][1] = -prices[0];
        for(int i = 1;i<prices.length;i++){
            // 本来就没  和   有但是今天卖了（记得扣手续费）  核心就是找到转移方程
            valueAndStatus[i][0] = Math.max(valueAndStatus[i-1][0], valueAndStatus[i-1][1]+prices[i]-fee);
            // 本来就有  和 本来没有今天买了
            valueAndStatus[i][1] =  Math.max(valueAndStatus[i-1][1],valueAndStatus[i][0]-prices[i]);
        }
        
        return valueAndStatus[prices.length-1][0];
        
    }
    /**
     * 贪心算法解决问题  
     * 1. 在0的时候，我们买入的价格是 prices[0]+fee
     * 2. 如果此时的价格比买入高就可以卖了，但是这只能保证局部最优,于是我们维持观望状态： prices[i+1]-prices[i]+(prices[i]-buy)  buy = prices[i];
     */
    public static int maxProfitWithGreedy(int []prices,int fee){
        int profit = 0;
        int buy = prices[0]+fee;
        for(int i = 1;i<prices.length;i++){
            // 如果价钱和手续费用小于买入价格，则换成当前点去买
            if(prices[i]+fee<buy){
                buy = prices[i]+fee;
            
            }else if(prices[i]>buy){
                // 如果高于buy，就卖出获得利润且当前价格成为购入价格
                profit += prices[i]-buy;
                // 不需要加fee并不是真正的卖出
                buy = prices[i];
                
            }
        }


        return profit;

    }

    public static void main(String[] args) {
        int []prices = {7,1,5,3,6,4};
        int fee = 2;
        System.out.println(maxProfitWithGreedy(prices, fee));
    }
    
}
