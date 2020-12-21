

/**数组的每个索引作为一个阶梯，第 i个阶梯对应着一个非负数的体力花费值 cost[i](索引从0开始)。

每当你爬上一个阶梯你都要花费对应的体力花费值，然后你可以选择继续爬一个阶梯或者爬两个阶梯。

您需要找到达到楼层顶部的最低花费。在开始时，你可以选择从索引为 0 或 1 的元素作为初始阶梯。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-cost-climbing-stairs
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class MinCostClimbing{
     
    /**
     *  离开某个点的消耗等于到达这个点的消耗+点本身的消耗
     * 
     */
    public static int minCostClimbingStairs(int[] cost) {
        int len = cost.length;
        int []dp = new int[len];
        dp[0] = cost[0];
        dp[1] = cost[1];
        for(int i = 2;i<len;i++){
            dp[i] = cost[i]+Math.min(dp[i-1], dp[i-2]);
        }
        // 获取最后的最优解等于离开倒数第二个点或者离开最后一个点
        return Math.min(dp[len-1], dp[len-2]);

    }

    /**
     *  1. 力扣的另一种思考思路
     *     到达某一个点的消耗： n-2走两步  n-1走一步
     *     只考虑过去经历了什么以获得如今的成就，不考虑现在和将来
     *     f(n) = Math.min(cost[n-1]+f(n-1),cost[n-2]+f(n-2))
     *     
     *  
     * 
     */
    public static int minCostClimbingStairsAD(int []cost){
        int len = cost.length;
        int []dp = new int[len+1];
        dp[0] = 0;
        dp[1] = 0;
        for(int i = 2;i<=len;i++){
            dp[i] = Math.min(cost[i-2]+dp[i-2],cost[i-1]+dp[i-1]);
        }
        return dp[len];
    }
    public static void main(String[] args) {
        int []arr = {1,100,1,1,1,100,1,1,100,1};
        System.out.println(minCostClimbingStairsAD(arr));

        
    }
}