import java.util.*;

/**
 * 给定一个已排序的正整数数组 nums，和一个正整数 n 。从 [1, n] 区间内选取任意个数字补充到 nums 中，使得 [1, n] 区间内的任何数字都可以用 nums 中某几个数字的和来表示。请输出满足上述要求的最少需要补充的数字个数。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/patching-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MinPatches {
    /***
     *  不会，直接看大佬操作
     */
    public static int minPatches(int[] nums, int n) {
        long max = 0;
        int index = 0;
        int count = 0;
        while(max<n){
            // 直接满足范围扩充
             if(index<nums.length&& nums[index]<=max+1){
                 max += nums[index++];
             }else{
                 //添加的值大于原来的max就会出现断层，需要额外加数据 max+1就是需要添加的数
                 max = max +(max+1);
                 count++;
             }
        }
        return count;
        }
   

    public static void main(String[] args) {
        int []nums = {1,5,10};
        int n = 20;
        System.out.println(minPatches(nums, n));
      

    }
}
