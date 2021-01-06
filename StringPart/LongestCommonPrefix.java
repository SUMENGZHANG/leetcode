/**
 * leetcode 14
 */
public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if(strs.length==0) return "";
        if(strs.length==1) return strs[0];

        StringBuffer res = new StringBuffer();
        int index = 0;
        int len = strs[0].length();
        boolean flag;
        while(index<len){
            flag = true;
            char cur = strs[0].charAt(index);
            for(int i = 1;i<strs.length; i++){
                // 最长公共由最短的单词决定
                if(index>=strs[i].length()) return res.toString();
                if(cur!=strs[i].charAt(index)) flag = false;
            }
            if(flag){
                res.append(cur);
                index++;
            }else{
                return res.toString();
            }


        }
        return res.toString();

    }

    public static void main(String[] args) {
        String []strs = {"ad","a"};
        System.out.println(longestCommonPrefix(strs));

    }
    
}

