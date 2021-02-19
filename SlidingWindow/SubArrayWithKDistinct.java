import java.util.*;

/**
 * leetcode 992
 */
public class SubArrayWithKDistinct {
    public static int subArrayWithKDistinct(int[] A,int k){
        
        // 子数组不同整数的个数恰好为K 可以转化为  最多有K的不同 的整数-最多有k-1不同的整数
        return atMostDistinct(A,k)-atMostDistinct(A,k-1);
    }
    /**
     * 最多有K个不同整数的子数组个数
     * @param A
     * @param k
     * @return
     */
    public static int atMostDistinct(int[]A,int k){
         int len = A.length;
         int[] frequency = new int[len+1];
         int left = 0;
         int right = 0;
         int count = 0;
         int res = 0;
         while(right<len){
             // 如果这个数没有出现过，那么数字个数+1
             if(frequency[A[right]]==0){
                 count++;
             }
             // 该数字数量+1
             frequency[A[right]]++;
             right++;

             // 如果当前的个数超过K  左窗口又移动
             while(count>k){
                 frequency[A[left]]--;
                 if(frequency[A[left]]==0) count--;
                 left++;
             }
             res +=right-left;
         }
         return res;

    }

    public static void main(String[] args) {
        int[] A = {1,2,1,2,3};
        int k = 2;
        System.out.println(subArrayWithKDistinct(A, k));

        
    }
}
