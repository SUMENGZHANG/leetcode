import java.util.*;

/**
 * 给你一个未排序的整数数组，请你找出其中没有出现的最小的正整数。
 */
public class FindMissingPostive {
    public static int firstMissingPositive(int[] nums) {
           // 将<=0的数换成不在1-n之内的数
           for(int i = 0;i<nums.length;i++){
               if(nums[i]<=0){
                   nums[i] = nums.length+1;
               }
           }
            
           // 通过乘以-1
           for(int i = 0;i<nums.length;i++){
               int num = Math.abs(nums[i]);
               if(num<=nums.length){
                   nums[num-1] = -1*Math.abs(nums[num-1]);
               }
               

           }

           for(int i = 0;i<nums.length;i++){
               if(nums[i]>0){
                   return i+1;
               }
           }

        
        return nums.length+1; 
    }

    

    public static void main(String[] args) {
        int[] nums = { 0 };
        System.out.println(firstMissingPositive(nums));

    }

}
