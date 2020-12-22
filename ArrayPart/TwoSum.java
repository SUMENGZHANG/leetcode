import java.util.Arrays;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，数组中同一个元素不能使用两遍。

 

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/two-sum
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class TwoSum {
    /**
     *   时间复杂度 O(n**2)
     */
    public static int[] twoSum(int[] nums, int target) {
            int []res = new int[2];
           for(int i = 0;i<nums.length;i++){
               for(int j = i+1;j<nums.length;j++){
                   if(target ==nums[i]+nums[j]){
                       res[0] = i;
                       res[1]= j;
                       return res;
                   }
               }
           }
           return res;


    }
    public static void main(String[] args) {
        int []nums = {2,7,11,15};
        int target = 9;
        System.out.println(twoSum(nums, target)[0]);
        System.out.println(twoSum(nums, target)[1]);

    }
   
    
}
