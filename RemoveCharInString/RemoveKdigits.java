import java.util.*;


/**
 * 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

注意:

num 的长度小于 10002 且 ≥ k。
num 不会包含任何前导零。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/remove-k-digits
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveKdigits {
    /**
     * 1. 关键数据是第一个左边大于右边的数，把左边的数去掉
     * @param num
     * @param k
     * @return
     */
    public static String removeKdigits(String num, int k) {
        // 创建返回值
        String res = "";
        // 特殊情况
        if(num.length()==k) return "0";
        
        //维护一个单调栈
        Deque<Character> deque = new LinkedList<>();
        char []arr = num.toCharArray();
        for(int i = 0;i<num.length();i++){
            if(!deque.isEmpty()){
                char curVal = deque.peekLast();
                while((!deque.isEmpty())&&curVal>arr[i]&&k>0){
                    deque.pollLast();
                    k--;
                    if(!deque.isEmpty()){
                        curVal = deque.peekLast();
                    }
                }

            }

            deque.add(arr[i]);

        }
        // 通过单调栈存储之前的数，并且去除比right大的

        // 如果去除的数字等于K那就完成返回数据，如果不足k就需要从末尾去除对应的数
           for(int i = 0;i<k;i++){
               deque.pollLast();
           }
        
            while(!deque.isEmpty()){
                res = res+deque.pollFirst();
            }
            return removeTopZero(res);
        

    }
    public static String removeTopZero(String res){
        char []arr = res.toCharArray();
        // 没有0
        if(arr[0]!='0') return res;
        // 移除开头所有的0
        int index = 0;
        while(index<arr.length-1){
         if(arr[index]=='0'&&arr[index+1]!='0'){
                return res.substring(index+1, res.length());
            }
            index++;
 
        }
        return "0";
     }
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(removeKdigits(num, k));

    }
}
