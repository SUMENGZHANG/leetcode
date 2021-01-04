/**
 * 给你一个长度为 n 的整数数组，请你判断在 最多 改变 1 个元素的情况下，该数组能否变成一个非递减数列。

我们是这样定义一个非递减数列的： 对于数组中所有的 i (0 <= i <= n-2)，总满足 nums[i] <= nums[i + 1]。

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/non-decreasing-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class CheckPossibility {
    
    /**
     *  
     * @param nums
     * @return
     */
    public static boolean checkPossibility(int[] nums) {
         if(nums.length==1) return true;
         int count = 1;
         for(int i = 0;i<nums.length-1;i++){
             if(nums[i]<=nums[i+1]){
                 count++;
             }else{
                  if(i==0||i==nums.length-2) continue;
                  if(nums[i-1]<=nums[i+1]||nums[i+2]>=nums[i]){
                      continue;
                  }else{
                      return false;
                  }
             }
         }
         if(count>=nums.length-1) return true;
         return false; 
    }
    public static void main(String[] args) {
        int []nums = {4,2,1};
        System.out.println(checkPossibility(nums));
        
    }
}

