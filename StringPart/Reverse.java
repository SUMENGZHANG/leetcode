/**
 * leetcode 7
 */
public class Reverse {
    public static int reverse(int x) {
        int res = 0;
        while(x!=0){
            int cur = x%10;
            x = x/10;
            if(res>Integer.MAX_VALUE/10||(res==Integer.MAX_VALUE/10&&cur>7)) return 0;
            if(res<Integer.MIN_VALUE/10||(res==Integer.MIN_VALUE/10&&cur<-8)) return 0;
            res = res*10+cur;
        }

        return res;


    }

    public static void main(String[] args) {
        int res  =-123;
        System.out.println(reverse(res));
        
        
    }
}
