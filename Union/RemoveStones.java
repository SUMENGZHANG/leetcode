import java.util.Map;

/**
 *  leetcode 947 
 * 947. 移除最多的同行或同列石头
难度
中等

158

n 块石头放置在二维平面中的一些整数坐标点上。每个坐标点上最多只能有一块石头。

如果一块石头的 同行或者同列 上有其他石头存在，那么就可以移除这块石头。

给你一个长度为 n 的数组 stones ，其中 stones[i] = [xi, yi] 表示第 i 块石头的位置，返回 可以移除的石子 的最大数量。

输入：stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
输出：5
解释：一种移除 5 块石头的方法如下所示：
1. 移除石头 [2,2] ，因为它和 [2,1] 同行。
2. 移除石头 [2,1] ，因为它和 [0,1] 同列。
3. 移除石头 [1,2] ，因为它和 [1,0] 同行。
4. 移除石头 [1,0] ，因为它和 [0,0] 同列。
5. 移除石头 [0,1] ，因为它和 [0,0] 同行。
石头 [0,0] 不能移除，因为它没有与另一块石头同行/列。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/most-stones-removed-with-same-row-or-column
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

 */
import java.util.*;
public class RemoveStones {
    /** 1. 同行同列的放在一个并查集
     *  2. 总共个数-并茶集数就是要删除的数
     * 
     * @return
     */
    public static int removeStones( int [][]stones){
          Union union = new Union();
          for(int []stone : stones){
              union.union(stone[0]+10001, stone[1]);
          }
          return stones.length-union.getCount();

    }
  

    public static void main(String[] args) {
        int [][]stones = {{0,0},{0,1},{1,0},{1,2},{2,1},{2,2}};
        System.out.println(removeStones(stones));
        
    }
}
