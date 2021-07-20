public class BubbleSort {
    public static void bubbleSortV1(int[] nums){
        for(int i = 0;i<nums.length-1;i++){
            for(int j = 0;j<nums.length-1-i;j++){
                 if(nums[j]>nums[j+1]){
                     nums[j+1] = nums[j+1]+nums[j];
                     nums[j] = nums[j+1]-nums[j];
                     nums[j+1] = nums[j+1]-nums[j];
                 }


            }
        }


    }
    /**
     * 添加了 阻截点，如果遍历一遍没有发生变化说明 排序已经完成
     * @param nums
     */
    public static void bubbleSortV2(int[] nums){
        boolean isOk = true;
        for(int i = 0;i<nums.length;i++){
            if(!isOk) break;
             isOk = false;
            for(int j = 0;j<nums.length-i-1;j++){
                if(nums[j]>nums[j+1]){
                    int temp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = temp;
                    isOk = true;
                }
            }
        }



    }

    public static void bubbleSortV3(int[] nums){
        

    }
    public static void main(String[] args) {
        int[] arr = new int[]{
            3,2,14,23,32
        };
        bubbleSortV2(arr);
        for (int i : arr) {
            System.out.println(i);
        }
        
    }
}
