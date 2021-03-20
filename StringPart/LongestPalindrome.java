/**
   leetcode5 最长回文子串
*/
public class LongestPalindrome{
    /**
     * 暴力法
     *  o(n**3)
     * @param s
     * @return
     */
    public String longestPalindrome(String s){
        int max = 0;
        String res = "";
        for(int i = 0;i<s.length();i++){
            for(int j = i+1;j<=s.length();j++){
                String curStr = s.substring(i, j);
                if(isPalindrome(curStr)&&curStr.length()>max){
                    res = curStr;
                    max = res.length();
                    
                }

            }
        }
        return res;


    }

    public static boolean isPalindrome(String s){
        int len = s.length();
        for(int i = 0;i<len/2;i++){
            if(s.charAt(i)!=s.charAt(len-i-1)){
                return false;
            }
        }
        return true;

    }

    /**
     * 动态规划解决 最长回文子串
     * @param s
     * @return
     */
    public String longestPalindromeWithDp(String s){
        // 动态规划重点： 状态转移方程   子回文串加上首位相同的字符依旧是子回文串
        int len = s.length();
        if(len<2) return s;
        boolean [][]dp = new int[len][len];
        // 初始化，一个独立的字符也是回文的
        for(int i = 0;i<len;i++){
            dp[i][i] = true;
        }
        char []arr = s.toCharArray();
        int begin = 0;
        //  初始值 为 1 
        int maxLen = 1;
        
        for(int j = 1;j<len;j++){
            for(int i = 0;i<j;i++){
                if(arr[i]!=arr[j]){
                    dp[i][j] = false;
                }else{
                    if(j-i<3){
                        dp[i][j] = true;
                    }else{
                        dp[i][j] = dp[i+1][j-1];
                    }
                }
                if(dp[i][j]&&j-i+1>maxLen){
                    maxLen = j-i+1;
                    begin = i;
                }

            }
        }
        return s.substring(begin, begin+maxLen);


    }
}