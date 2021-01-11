import java.util.ArrayList;

/**
 *  leetcode 228
 * */
import java.util.*;

public class SummaryRanges {

    public static List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList<>();
        int index = 0;
        int len = nums.length;
        while(index<len){
            int low = index;
            index++;
            while(index<len&&nums[index-1]+1==nums[index]){
                index++;
            }
            int high = index-1;
            StringBuffer cur = new StringBuffer(Integer.toString(nums[low]));
            if(low<high){
                cur.append("->");
                cur.append(""+nums[high]);

            }
            res.add(cur.toString());
        }
        return res;

      
    }
    public static void main(String[] args) {
        int []nums = {0,1,2,4,5,7};
        List<String> res = summaryRanges(nums);
        for (String string : res) {
            System.out.println(string);
        }
    }
}
