import java.util.*;

/** 
 * 给定一个非空数组，返回此数组中第三大的数。如果不存在，则返回数组中最大的数。要求算法时间复杂度必须是O(n)。

示例 1:
*/
public class ThirdMax {
   
    /**
     *  1. 可能有重复的数据出现
     */
    public static int thirdMax(int[] nums) {

        long fir = Long.MIN_VALUE;
        long sec = Long.MIN_VALUE;
        long third = Long.MIN_VALUE;
        for(int i = 0;i<nums.length;i++){
            int curVal = nums[i];
            if(curVal>fir){
                third = sec;
                sec = fir;
                fir = curVal;
            }else if(curVal==fir){
                continue;
            }else if(curVal>sec){
                third = sec;
                sec = curVal;
            }else if(curVal==sec){
                continue;
            }else if(curVal>third){
                third = curVal;
            }else{
                continue;
            }
        }
        if(third==Long.MIN_VALUE) return (int)fir;
        return (int)third;
    }

    /**
     * 红黑树的协助
     * @param nums
     * @return
     */
    public static int thirdMaxWithTree(int[] nums) {
        TreeSet<Integer> set = new TreeSet<>();
        for (Integer cur : nums) {
            set.add(cur);
            if(set.size()>3){
                set.remove(set.first());
            }
            
        }
        return set.size()<3?set.last():set.first();
    }

    public static void main(String[] args) {
        
    }

}

