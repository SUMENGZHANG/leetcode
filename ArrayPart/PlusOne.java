/**
 * 给定一个由 整数 组成的 非空 数组所表示的非负整数，在该数的基础上加一。

最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。

你可以假设除了整数 0 之外，这个整数不会以零开头。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/plus-one
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class PlusOne {
    public static int[] plusOne(int[] digits) {
        int len = digits.length;
        int index = len-1;
            if(digits[index]==9){
               
                int count = 0;
                while(index>=0&&digits[index]==9){
                    digits[index] = 0;
                    index--;
                    count++;
                }
                // 全是9
                if(count==len){
                    int []res = new int[len+1];
                    res[0] = 1;
                    return res;
                }
                //到不是9的停

            }
            digits[index] = digits[index]+1;
            return digits;

           
        

    }

    public static void main(String[] args) {
        int []digits = {4,3,2,1};
        int []res = plusOne(digits);
        for (int i : res) {
            System.out.println(i);
            
        }
        
    }
    
}
