import java.util.*;
/**给定一个整数数组 a，其中1 ≤ a[i] ≤ n （n为数组长度）, 其中有些元素出现两次而其他元素出现一次。

找到所有出现两次的元素。

你可以不用到任何额外空间并在O(n)时间复杂度内解决这个问题吗？

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/find-all-duplicates-in-an-array
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * 
 */
public class FindDuplicates {
    /**
     *  可以结合448 加强理解  https://leetcode-cn.com/problems/find-all-numbers-disappeared-in-an-array
     */
    public static List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<nums.length;i++){
            // 拿到该点的值，当作一个下标,防止被*-1
             int num = Math.abs(nums[i]);
             //
             int index = num-1;
             if(nums[index]<0){
                 res.add(index+1);
             }else{
                nums[index] *= -1;

             }   
             
        }

        

        return res;

    }
    public static void main(String[] args) {
        int []nums = {4,3,2,7,8,2,3,1};
        System.out.println(findDuplicates(nums));


        
    }

    
}
