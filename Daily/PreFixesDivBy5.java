/**
 *  leetcode 1018
 *   
 *  单纯的用 int  long去求数据会溢出，我们只需要数字能否被整除
 */
import java.util.*;
public class PreFixesDivBy5 {
    public static List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> list = new ArrayList<Boolean>();
        int prefix = 0;
        int length = A.length;
        for (int i = 0; i < length; i++) {
            prefix = ((prefix << 1) + A[i]) % 5;
            list.add(prefix == 0);
        }
        return list;

    }
    public static void main(String[] args) {
        int []A = {1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1};
        List<Boolean> res = prefixesDivBy5(A);
        for (Boolean i : res) {
            System.out.println(i);
        }
       
    }
    
}
