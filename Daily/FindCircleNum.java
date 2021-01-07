
/**
 *  leetcode 574
 */
import java.util.*;

public class FindCircleNum {
    public static int findCircleNum(int[][] isConnected) {
        int len = isConnected.length;
        int count = 0;
        // 我们可以知道总共有多少个城市 isConnected[i][i] = 1 就是自己
        // 关于对角线对称的1 相连接
        // 考虑将相连接的点放入一个set 然后加入 深度遍历吧
        Stack<int[]> stack = new Stack<>();
        Stack<Integer> stackIndex = new Stack<>();
        // 只需要一个数组保存
        Set<Integer> set = new HashSet<>();
        for (int j = 0; j < len; j++) {
            if (!set.contains(j)) {
                stack.push(isConnected[j]);
                stackIndex.push(j);
                count++;
            }
            while (!stack.isEmpty()) {
                    int[] cur = stack.pop();
                    int curIndex = stackIndex.pop();
                    for (int i = 0; i < cur.length; i++) {
                        if (cur[i] == 1 && i != curIndex&&isConnected[i][curIndex]==1) {
                            isConnected[i][curIndex] = 0;
                            stack.push(isConnected[i]);
                            stackIndex.push(i);
                            set.add(i);
                        }
                    }
                }

        }
        return count;

    }
    /**
     * 思路一样的BFS但是人家的代码效率更快
     * 
     */
    public int findCircleNumWithBFS(int[][] isConnected) {
        // int[][] isConnected 是无向图的邻接矩阵，n 为无向图的顶点数量
        int n = isConnected.length;
        // 定义 boolean 数组标识顶点是否被访问
        boolean[] visited = new boolean[n];
        
        // 定义 cnt 来累计遍历过的连通域的数量
        int cnt = 0;  
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            // 若当前顶点 i 未被访问，说明又是一个新的连通域，则bfs新的连通域且cnt+=1.
            if (!visited[i]) {
                cnt++;
                queue.offer(i);
                visited[i] = true;
                while (!queue.isEmpty()) {
                    int v = queue.poll();
                    for (int w = 0; w < n; w++) {
                        if (isConnected[v][w] == 1 && !visited[w]) {
                            visited[w] = true;
                            queue.offer(w);
                        }
                    }
                }
            }
        }
        return cnt;
    }


    /**
     *大佬的DFS
     */
    public static int findCircleNumDFS(int[][] isConnected) {
        int provinces = isConnected.length;
        boolean[] visited = new boolean[provinces];
        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (!visited[i]) {
                dfs(isConnected, visited, provinces, i);
                circles++;
            }
        }
        return circles;
    }


    public static void dfs(int[][] isConnected, boolean[] visited, int provinces, int i) {
        for (int j = 0; j < provinces; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, visited, provinces, j);
            }
        }
    }




    /**
     * 并查集思想
     * @param args
     */
    public static int findCircleNumUnion(int[][] isConnected) {
        int provinces = isConnected.length;
        int[] parent = new int[provinces];
        // 给顶点赋值
        for (int i = 0; i < provinces; i++) {
            parent[i] = i;
        }
        
        // 
        for (int i = 0; i < provinces; i++) {
            // 为什么从i+1开始   数组其实按照对角线对称，如果和前面的数据有关系那么已经被记录了
            for (int j = i + 1; j < provinces; j++) {
                if (isConnected[i][j] == 1) {
                    union(parent, i, j);
                }
            }
        }

        int circles = 0;
        for (int i = 0; i < provinces; i++) {
            if (parent[i] == i) {
                circles++;
            }
        }
        return circles;
    }

    /**
     *  
     */
    public static  void union(int[] parent, int index1, int index2) {
        parent[find(parent, index1)] = find(parent, index2);
    }
    /**
     *  递归
     */
    public static  int find(int[] parent, int index) {
        if (parent[index] != index) {
            parent[index] = find(parent, parent[index]);
        }
        return parent[index];
    }


    public static void main(String[] args) {
        int[][] isConnect = { { 1, 1, 0 }, { 1, 1, 0 }, { 0,0, 1 } };
        System.out.println(findCircleNumUnion(isConnect));

    }
}
