import jdk.javadoc.internal.tool.resources.javadoc;

public class InsertSort {

    /**
     *  每次插入时选择一个合适的位置
     */
    public static void insertSort(int[] nums){
        for(int i = 1;i<nums.length;i++){
            // 维护当前点的值
            int curIndex = i-1;
            int curVal = nums[i];
            //把值往后移动
            while(curIndex>=0&&nums[curIndex]>curVal){
                 nums[curIndex+1] = nums[curIndex];
                 curIndex--;
            }
            
            nums[curIndex+1] = curVal;
        }
    }

    public static void main(String[] args) {
       int[] arr = new int[]{
           3,2,14,23,32
       };
       insertSort(arr);
       for (int i : arr) {
           System.out.println(i);
       }
       
   }
}
