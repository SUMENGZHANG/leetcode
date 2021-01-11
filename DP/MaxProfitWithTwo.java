/**
 * leetcode 123 买卖股票的最佳时机
 */
public class MaxProfitWithTwo {
    /**
     * 动态规划 1. 每天的状态分为 有无股票在手上 2. 第n次交易是通过第n-1交易得到的
     */
    public static int maxProfit(int[] prices) {
        int len = prices.length;

        int[][][] dp = new int[len][2][3];
        // 第一天 有股票
        for (int i = 0; i <= 2; i++) {
            dp[0][1][i] = -prices[0];
        }

        for (int i = 1; i < len; i++) {
            for (int j = 0; j <= 2; j++) {
                if (j < 2) {
                    // 本来就没有股票或者今天卖了()
                    dp[i][0][j] = Math.max(dp[i - 1][0][j], dp[i - 1][1][j + 1] + prices[i]);

                } else {
                    dp[i][0][j] = dp[i - 1][0][j];
                }
                // 手上有股票 分为 之前没有今天买了 之前就有
                dp[i][1][j] = Math.max(dp[i - 1][0][j] - prices[i], dp[i - 1][1][j]);

            }
        }

        int maxPro = 0;
        for (int i = 0; i <= 2; i++) {
            maxPro = Math.max(maxPro, dp[len - 1][0][i]);
        }
        return maxPro;

    }

    public int maxProfitWithAD(int[] prices) {
        int n = prices.length;
        int buy1 = -prices[0], sell1 = 0;
        int buy2 = -prices[0], sell2 = 0;
        for (int i = 1; i < n; ++i) {
            buy1 = Math.max(buy1, -prices[i]);
            sell1 = Math.max(sell1, buy1 + prices[i]);
            buy2 = Math.max(buy2, sell1 - prices[i]);
            sell2 = Math.max(sell2, buy2 + prices[i]);
        }
        return sell2;

    }

    public static void main(String[] args) {
        int[] prices = { 3, 3, 5, 0, 0, 3, 1, 4 };
        System.out.println(maxProfit(prices));

    }
}
