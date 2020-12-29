/**  leetcode 598
 * 给定一个初始元素全部为 0，大小为 m*n 的矩阵 M 以及在 M 上的一系列更新操作。

操作用二维数组表示，其中的每个操作用一个含有两个正整数 a 和 b 的数组表示，含义是将所有符合 0 <= i < a 以及 0 <= j < b 的元素 M[i][j] 的值都增加 1。

在执行给定的一系列操作后，你需要返回矩阵中含有最大整数的元素个数。

示例 1:

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/range-addition-ii
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MaxCount {
    public static int maxCount(int m, int n, int[][] ops) {
       /* if(ops.length==0) return m*n;
        int minX = Integer.MAX_VALUE;
        int minY = Integer.MAX_VALUE;
       for(int i = 0;i<ops.length;i++){
           minX = Math.min(minX,ops[i][0]);
           minY = Math.min(minY,ops[i][1]);
       }
       return minX*minY ;*/
       int[][] arr = new int[m][n];
       for (int[] op: ops) {
           for (int i = 0; i < op[0]; i++) {
               for (int j = 0; j < op[1]; j++) {
                   arr[i][j] += 1;
               }
           }
       }
       int count = 0;
       for (int i = 0; i < m; i++) {
           for (int j = 0; j < n; j++) {
               if (arr[i][j] == arr[0][0])
                   count++;
           }
       }
       return count;


    }
    
    public static void main(String[] args) {
        int m =3;
        int n = 3;
        int [][]ops = {};
        System.out.println(maxCount(m, n, ops)); 

    }

    
}
