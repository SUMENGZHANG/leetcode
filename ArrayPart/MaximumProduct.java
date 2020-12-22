import java.util.Arrays;

/**
 * 给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。给定一个整型数组，在数组中找出由三个数组成的最大乘积，并输出这个乘积。
 */
public class MaximumProduct {
    public static int maximumProduct(int[] nums) {
       // 排序
       Arrays.sort(nums);
       // 有负数且选择复数的情况时 两个最小的复数相乘   两个最大的正数相乘 
       return nums[nums.length-3]*Math.max(nums[0]*nums[1], nums[nums.length-1]*nums[nums.length-2]);

      
        
    }
    public static void main(String[] args) {
        int []nums = {1,-1000,1000,1000};
        System.err.println(maximumProduct(nums));
        
    }

    
}
