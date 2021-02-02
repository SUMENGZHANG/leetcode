import java.util.*;

/**
 *  leetcode 888
 */
public class FairCandySwap {
    public int[] fairCandySwap(int[] A, int[] B) {
        // 求到目前A和B的数量
         int sumA = Arrays.stream(A).sum();
         int sumB = Arrays.stream(B).sum();
        //  sumA-x+y = sumB-y+x   =>     x = y+(sumA-sumB)/2
         int count = (sumA-sumB)/2;
         // 通过hash来判断
         HashSet<Integer> set = new HashSet<Integer>();
         for (int i : A) {
             set.add(i);
             
         }
         int []ans = new int[2];
         for(int y:B){
             int x = y+count;
             if(set.contains(x)){
                 ans[0] = x;
                 ans[1] = y;
                 break;
             }
         }
         return ans;

    }}
