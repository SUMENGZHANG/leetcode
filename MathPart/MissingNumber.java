public class MissingNumber {
    public static int missingNumber(int[] nums){
        int []arr = new int[nums.length+1];
        for(int i = 0;i<nums.length;i++){
            arr[nums[i]] = 1;
        }
        for(int i = 0;i<arr.length;i++){
            if(arr[i]!=1) return i;
        }
        return 0;

    }
    public static void main(String[] args) {
        int []nums = {3,0,1};
        System.out.println(missingNumber(nums));
    }
    
}
