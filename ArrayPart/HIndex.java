import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 给定一位研究者论文被引用次数的数组（被引用次数是非负整数）。编写一个方法，计算出研究者的 h 指数。

h 指数的定义：h 代表“高引用次数”（high citations），一名科研人员的 h 指数是指他（她）的 （N 篇论文中）总共有 h 篇论文分别被引用了至少 h 次。且其余的 N - h 篇论文每篇被引用次数 不超过 h 次。

例如：某人的 h 指数是 20，这表示他已发表的论文中，每篇被引用了至少 20 次的论文总共有 20 篇。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/h-index
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class HIndex {
    /**
     * 暴力法  o(n**2)
     */
    public static int hIndex(int[] citations) {
        int maxH = Integer.MIN_VALUE;
        int h = 0;
        while(h<=citations.length){
            int count = 0;
            for (int i : citations) {
                if(i>=h){
                    count++;
                }
            }
            if(count>=h){
                maxH = Math.max(maxH,h);
            }
            h++;

        }
        return maxH;
    }
    
    public static int hIndexWithSquare(int[] citations){
        Arrays.sort(citations);
        int squareWidth = 0;
        while(squareWidth<citations.length&&citations[citations.length-1-squareWidth]>squareWidth){
            squareWidth++;

        }
        return squareWidth;

    }
    /**
     * 力扣大佬
     */
    public static int hIndexCounting(int[] citations){
        int n = citations.length;
        int[] papers = new int[n + 1];
        // 计数
        for (int c: citations)
            papers[Math.min(n, c)]++;
        // 找出最大的 k
        int k = n;
        // 
        for (int s = papers[n]; k > s; s += papers[k])
            k--;
        return k;

    }

    public static void main(String[] args) {
        int []citations = {3,0,6,1,5};
        System.out.println(hIndexCounting(citations));
    }
}
