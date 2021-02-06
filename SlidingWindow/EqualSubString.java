/**
 * leetcode 1208
 */
public class EqualSubString {
    /**
     * 我的解决思路
     * 1 滑动窗口
     * 
     * 
     * @param s
     * @param t
     * @param maxCost
     * @return
     */
    public static int equalSubString(String s,String t,int maxCost){
        int len = s.length();
        // 开头就不满足
        int cost =0;
        int left = 0;
        int right = 0;
        int maxWindow = 0;
        while(right<len){
            
            cost +=Math.abs(s.charAt(right)-t.charAt(right));
            // 如果目前窗口可以被转化，消耗小于最大消耗那么就扩大窗口（），不然就移动窗口
            while(cost>maxCost){
                cost -=Math.abs(s.charAt(left)-t.charAt(left));
                left++;
            }
            maxWindow = Math.max(maxWindow,right-left+1);
            right++;
           
        }

        return maxWindow;


    }
    public static void main(String[] args) {
        String s = "pxezla";
        String t = "loewbi";
        int maxCost = 25;
        System.out.println(equalSubString(s, t, maxCost));
    }

}
