/**
 * 初级算法-数组 给定一个排序数组，你需要在 原地 删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 * 
 * 不要使用额外的数组空间，你必须在 原地 修改输入数组 并在使用 O(1) 额外空间的条件下完成。
 * 
 *  
 * 
 * 作者：力扣 (LeetCode)
 * 链接：https://leetcode-cn.com/leetbook/read/top-interview-questions-easy/x2gy9m/
 * 来源：力扣（LeetCode） 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
 */
public class RemoveDeplicates {
    /**
     * 不使用额外的空间
     * 菜鸡写法
     * 
     */
    public static int removeDuplicates(int[] nums) {
        if (nums.length == 0)
            return nums.length;

        int indexOne = 0;
        int indexTwo = 1;

        while (indexOne < nums.length) {

            if (indexTwo < nums.length && nums[indexTwo] <= nums[indexOne]) {
                indexTwo++;
            } else {
                if (indexTwo >= nums.length)
                    break;
                nums[++indexOne] = nums[indexTwo];
                indexTwo = indexOne + 1;
            }
        }
        return indexOne + 1;

    }
    
    /**
     * 别人家的双指针就是优雅，我写的是坨屎
     */
    public int removeDuplicatesAD(int[] nums) {
        if (nums.length == 0)
            return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;

    }

    public static void main(String[] args) {
        int[] nums = { 0, 0, 1, 1, 1, 2, 2, 3, 3, 4 };
        System.out.println(removeDuplicates(nums));

    }

}
