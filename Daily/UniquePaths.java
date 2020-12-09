import java.util.LinkedList;
import java.util.Queue;

/**
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 *机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * 来源：力扣（LeetCode)
 * 链接：https://leetcode-cn.com/problems/unique-paths
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 *  f(x,y) = f(x-1,y)+f(x,y+1) 转换方程
 *   
 *  1->m 的 f(0,m)为 1, 1->n 的 f(m-1,n) 为1；
 */
public class UniquePaths {
    public static int uniquePaths(int m, int n) {
        int [][]arr = new int[n][m];
        for(int i = 0;i<m;i++){
            arr[0][i] = 1;
        }
        for(int j = 0;j<n;j++){
            arr[j][m-1] =1;
        }
        for(int i=1;i<n;i++){
            for(int j=m-2;j>=0;j--){
                arr[i][j] = arr[i-1][j]+arr[i][j+1];
            }
        }
        return arr[n-1][0];

    }
    public static void main(String[] args) {
       int res = uniquePaths(3,7);
       System.out.println(res);

        
    }
    
}
