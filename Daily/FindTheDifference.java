
import java.util.Arrays;

/**
 * 给定两个字符串 s 和 t，它们只包含小写字母。

字符串 t 由字符串 s 随机重排，然后在随机位置添加一个字母。

请找出在 t 中被添加的字母。

 */

public class FindTheDifference {
    /**
     *   暴力法
     */
    public static  char findTheDifference(String s, String t) {

        char [] sArr = s.toCharArray();
        char [] tArr = t.toCharArray();
        // 排序
        Arrays.sort(sArr);
        Arrays.sort(tArr);
        for(int i = 0;i<sArr.length;i++){
            if(sArr[i]!=tArr[i]){
                return  tArr[i];
                
            }
        }
        return tArr[t.length()-1];
    

    }
    
    /**
     * 位运算 - 异或运算
     *  a^a = 0;
     *  a^0 = a;
     *  a^b^a = a^a^b
     */
    public static char findTheDifferenceAD(String s,String t){
        char [] arr = s.concat(t).toCharArray();
        char res = 0;
        for (char c : arr) {
            res ^= c;
            
        }
        return res;

    }
    public static void main(String[] args) {
        String s = "aaacd";
        String t = "aabcd";
        System.out.println(findTheDifferenceAD(s, t));
    }
   

    
}
