/**
 * 给你一个字符串 s，以及该字符串中的一些「索引对」数组 pairs，其中 pairs[i] = [a, b] 表示字符串中的两个索引（编号从 0 开始）。

你可以 任意多次交换 在 pairs 中任意一对索引处的字符。

返回在经过若干次交换后，s 可以变成的按字典序最小的字符串。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/smallest-string-with-swaps
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


并查集
 */
import java.util.*;
public class SmallestStringWithSwaps {
    public String smallestStringWithSwaps(String s, List<List<Integer>> pairs) {
        // 总体思路根据下标的 集合对，将数组的下标分组   组内的下标可以自由排序

        // 遍历下标对，建立并查集
<<<<<<< HEAD
       return "";

        
=======
        int len = s.length();
        UnionFind unionFind = new UnionFind();
        for (List<Integer> pair : pairs) {
            int indexOne = pair.get(0);
            int indexTwo = pair.get(1);
            unionFind.union(indexOne,indexTwo);
        }
        // 构建映射关系
        char []charArr = s.toCharArray();
        Map<Integer,PriorityQueue<Character>> hashMap = new HashMap<>(len);
        for(int i = 0;i<len;i++){
            int root = unionFind.find(i);
            hashMap.computeIfAbsent(root, key->new PriorityQueue<>()).offer(charArr[i]);
        }
        StringBuilder stringBuilder = new StringBuilder();
        for(int i = 0;i<len;i++){
            int root = unionFind.find(i);
            stringBuilder.append(hashMap.get(root).poll());
        }
        return stringBuilder.toString();
>>>>>>> 4441175c08cc92ff11f2d92dc2d0359f306f042c

    
    }
}
