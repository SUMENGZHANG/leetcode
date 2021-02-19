/**
 * 665
 */
public class CheckPosibility {
    public boolean checkPossibility(int[] nums){
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
    
}
