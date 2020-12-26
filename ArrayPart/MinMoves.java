/**
 * 给定一个长度为 n 的 非空 整数数组，每次操作将会使 n - 1 个元素增加 1。找出让数组所有元素相等的最小操作次数。

 
 */
public class MinMoves {
    public static int minMoves(int []nums){
        int res = 0;
        // 找到一个最小值，
        int min = Integer.MAX_VALUE;
        for(int i = 0;i<nums.length;i++){
            min = Math.min(min,nums[i]);
        }
        //
        for(int i = 0;i<nums.length;i++){
            res = res+(nums[i]-min);
        }
        return res;
    }
    public static void main(String[] args) {
         int []nums = {1,2,3};
         System.out.println(minMoves(nums));
        
    }
    
}
