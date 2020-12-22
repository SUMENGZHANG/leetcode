import java.util.Arrays;

/**
 * 集合 S 包含从1到 n 的整数。不幸的是，因为数据错误，导致集合里面某一个元素复制了成了集合里面的另外一个元素的值，导致集合丢失了一个整数并且有一个元素重复。

给定一个数组 nums 代表了集合 S 发生错误后的结果。你的任务是首先寻找到重复出现的整数，再找到丢失的整数，将它们以数组的形式返回。

示例 1:

输入: nums = [1,2,2,4]
输出: [2,3]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/set-mismatch
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindErrorNums {
    /**
     * 
     * @param nums
     * @return
     */
    public static int[] findErrorNums(int[] nums) {
        int []res = new int[2];
        int missing  = 1;
        //排序
        Arrays.sort(nums);
        
        for(int i = 0;i<nums.length-1;i++){
            // 如果想等就确定重复的数据
            if(nums[i]==nums[i+1]){
                res[0] = nums[i];
            }else if(nums[i]+1<nums[i+1]){
                missing = nums[i]+1;
            }

        }
        res[1] = nums[nums.length-1]!=nums.length?nums.length:missing;
        return res;


    }
    public static void main(String[] args) {
        int []nums = {2,2};
        System.out.println(findErrorNums(nums)[0]);
        System.out.println(findErrorNums(nums)[1]);
    }
    
}
