/** 旋转数组
 * 给定一个数组，将数组中的元素向右移动 k 个位置，其中 k 是非负数。
 */
public class Rotate {
    /**
     * 暴力法
     * @param nums
     * @param k
     */
    public static  void rotate(int[] nums, int k) {
        // 如果查过了数组长度，则取余
        k = k%nums.length;
        // 每次移动一个位置
        for(int i = 0;i<k;i++){
            int cur = nums[nums.length-1];
            for(int j = 0;j<nums.length;j++){
                int nowVal = nums[j];
                nums[j] = cur;
                cur =  nowVal;
            }
        }
    }

    /**
     * 旋转数组
     */
    public static  void rotateWithReverse(int[] nums, int k) {
         // 反转所有的数

         // 


   
    }
    public static void reverse(int []nums,int start,int end){
        

    }

    public static void main(String[] args) {
        int []nums = {1,2,3,4,5,6,7};
        int k = 3;
        rotate(nums, k);
        for (int i : nums) {
            System.out.println(i);
        }



    }
    
}
