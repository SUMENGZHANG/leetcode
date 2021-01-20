import java.util.HashMap;

/**
 *      leetcode 990
 * 给定一个由表示变量之间关系的字符串方程组成的数组，每个字符串方程 equations[i] 的长度为 4，并采用两种不同的形式之一："a==b" 或 "a!=b"。在这里，a 和 b 是小写字母（不一定不同），表示单字母变量名。

只有当可以将整数分配给变量名，以便满足所有给定的方程时才返回 true，否则返回 false。 

 

示例 1：

输入：["a==b","b!=a"]
输出：false
解释：如果我们指定，a = 1 且 b = 1，那么可以满足第一个方程，但无法满足第二个方程。没有办法分配变量同时满足这两个方程。
示例 2：

输入：["b==a","a==b"]
输出：true
解释：我们可以指定 a = 1 且 b = 1 以满足满足这两个方程。
示例 3：

输入：["a==b","b==c","a==c"]
输出：true
示例 4：

输入：["a==b","b!=c","c==a"]
输出：false
示例 5：

输入：["c==c","b==d","x!=z"]
输出：true

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/satisfiability-of-equality-equations
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
import java.util.*;

public class EquationsPossiable {
    int []parent = new int[26];for(
    int i = 0;i<26;i++)
    {
        parent[i] = i;
    }

    public boolean equationsPossible(String[] equations){
        // 如果是等== 就并入同一个集合
        for (String equation : equations) {
            char left = equation.charAt(0)-'a';
            char right = equation.charAt(3)-'a';
            // ! 和 = 的区别
            char sign = equation.charAt(1);
            if(sign=='='){
                // 如果相同，就放到一个集合里面去
                union(parent, left, right);
            }
            
        }

        // 
        for (String equation : equations) {
            char left = equation.charAt(0)-'a';
            char right = equation.charAt(3)-'a';
            // ! 和 = 的区别
            char sigh = equation.charAt(1);
            if(sign=='!'){
                if(find(parent, left)==find(parent, right)){
                    return false;
                }
            }
            
        }
        return true;

    }

    // 开始合并
    public void union(int []parent,int left,int right){
        parent[find(parent,left)] = find(parent,right);
    }

    // 追溯源头
    public int find(int []parent,int index){
       // 递归找到这个点的代表集合
        while(index!=parent[index])
        {
            parent[index] = parent[find(parent,index)];
            index = parent[index];
        }
        return index;
    }

}
