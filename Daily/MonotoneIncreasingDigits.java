import java.util.Arrays;

/*给定一个非负整数 N，找出小于或等于 N 的最大的整数，同时这个整数需要满足其各个位数上的数字是单调递增。

（当且仅当每个相邻位数上的数字 x 和 y 满足 x <= y 时，我们称这个整数是单调递增的。）

示例 1:

输入: N = 10
输出: 9
示例 2:

输入: N = 1234
输出: 1234
示例 3:

输入: N = 332
输出: 299

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/monotone-increasing-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。*/
public class MonotoneIncreasingDigits {
    /**
     * 炸裂 我就知道会超时
     */
    public static int monotoneIncreasingDigitsV1(int N) {
         // 从N开始
        for(int i = N;i>=0;i--){
            // 取一个值
          if(isValid(i)){
              return i;
          }
        }
        return -1;
    }
    // 还是超时
    public static boolean isValid(int N){
        // // 获取数的最后一位
        // int last = n%10;
        // while(n>0){
           
        //     if(n%10>last){
        //         return false;
        //     }
        //     last =n%10;
        //     n = n/10;
        // }

        // return true;
        String n = String.valueOf(N);
        char []arr = n.toCharArray();
        Arrays.sort(arr);
        String nowStr = String.valueOf(arr);
        if(n.equals(nowStr)){
            return true;
        }
        return false;
         
     }
        
    
    /**
     * 贪心算法
     * 
     */
     public static int monotoneIncreasingDigits(int N){
         if(N<10) return N;
         char [] n = Integer.toString(N).toCharArray();
         int length =n.length;
         for(int i = length-1;i>0;i--){
             while(n[i]<n[i-1]){
                 n[i-1] -=1;
                 for(int j = i;j<length;j++){
                     n[j] = '9';
                 }

             }

         }

         return Integer.parseInt(String.valueOf(n));

     }

 
     
        
    public static void main(String[] args) {
        System.out.println(monotoneIncreasingDigits(10));
    }
    
}
