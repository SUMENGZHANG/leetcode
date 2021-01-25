import java.util.Collections;



/** leetcode 1584
 * 给你一个points 数组，表示 2D 平面上的一些点，其中 points[i] = [xi, yi] 。

连接点 [xi, yi] 和点 [xj, yj] 的费用为它们之间的 曼哈顿距离 ：|xi - xj| + |yi - yj| ，其中 |val| 表示 val 的绝对值。

请你返回将所有点连接的最小总费用。只有任意两点之间 有且仅有 一条简单路径时，才认为所有点都已连接。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/min-cost-to-connect-all-points
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class minCostConnectPoints {
    int []parent;
    public int find(int x){
        return parent[x]==x?x:find(parent[x]);
    }
    public int minCostConnectPoints(int[][] points) {
        int length = points.length;
        parent = new int[length+1];
        
        //求边长,存入容器
        ArrayList<Edge> edges = new ArrayList<>();
        for(int i = 0;i<h;i++){
            for(int j = i+1;j<h;j++){
                int len = Math.abs(points[i][0]-points[j][0])+Math.abs(points[i][1]-points[j][1]);
                if(len!=0) edges.add(new Edges(i,j,len));
            }
           
        }
        // 给边长排序
        Collections.sort(edges);
        int res = 0;
        for (Edge edge : edges) {
            int x = edge.getX();
            int y = edge.getY();
            int len = edge.getLen();
            // 如果节点都在集合里就不连接避免成环
            if(find(x)==find(y)){
                continue;
            }
            res +=len;
            parent[find(x)] = find(y);
            
        }
        return res;
    }
}
