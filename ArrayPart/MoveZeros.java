/**
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。

示例:

输入: [0,1,0,3,12]
输出: [1,3,12,0,0]

来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/move-zeroes
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class MoveZeros {
    public static void moveZeroes(int[] nums) {
       for(int i = 0;i<nums.length;i++){
           if(nums[i]==0){
               for(int j = i+1;j<nums.length;j++){
                   if(nums[j]!=0){
                       int cur = nums[j];
                       nums[j] = nums[i];
                       nums[i] = cur;
                       break;
                   }
               }
           }
       }
        

    }

    /**
     * 双指针
     * 
     */
    public static void moveZeroSWithDoublePoint(int[] nums){
        int indexOne = 0;
        int indexTwo = 0;
        while(indexTwo<nums.length){
            if(nums[indexTwo]!=0){
                int curVal = nums[indexTwo];
                nums[indexTwo] = nums[indexOne];
                nums[indexOne] = curVal;
                indexOne++;
            }
            indexTwo++;


        }
    }
    public static void main(String[] args) {
        int []nums = {1,0,1,2,0,12,0,1};
        moveZeroSWithDoublePoint(nums);
        for (int i : nums) {
            System.out.println(i);
        }
    }
    
}
