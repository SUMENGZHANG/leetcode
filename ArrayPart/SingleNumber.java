
/**
 *   异或运算   leetcode 136
 */
public class SingleNumber {
    public static int singleNumber(int[] nums) {
        int dur = 0;
         for(int i = 0;i<nums.length;i++){
             dur ^=nums[i];

         }
         return dur;
        

    }
    public static void main(String[] args) {
        int []nums = {1,2,2};
        System.out.println(singleNumber(nums));
        
   
    }
    
}
