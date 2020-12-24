/**
 * 假设要把长度为 n 厘米的木棒切分为 1 厘米长的小段，但是 1 根木棒只能由 1 人切分，当木棒被切分为 3 段后，可以同时由 3 个人分别切分木棒。
 */
public class CutBar{
    /**
     * 递归
     * @param n
     * @param m
     * @param curLen
     * @return
     */
    public  static int cutBar(int n,int m,int curLen){
        //终止条件  长度为一就终止了
        if(curLen>=n) return 0;
        // 切木棍的时候，人够
        if(m>=curLen)
        {
            return 1+cutBar(n,m,curLen*2);

        }
       
        // 切木棍的时候，人不够
        if(m<curLen){
            return 1+cutBar(n,m,curLen+m);
        }
        return 0;
       

    }

    /**
     * 反向思路
     * @param n
     * @param m
     * @return
     */

    public static int getBar(int n,int m){
        int count = 0;
        int curLen = 1;
        while(n>curLen){
            curLen += curLen<m?curLen:m;
            count++;
        }
        return count;
    }
    public static void main(String[] args) {
        int m = 3;
        int n =8;
        int curLen = 1;
       // System.out.println(cutBar(n, m, curLen));
        System.out.println(getBar(n, m));
        
    }
}