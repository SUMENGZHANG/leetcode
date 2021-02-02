/**
 *  leetcode 424
 */
class CharacterReplacement{
    public static int characterReplacement(String s, int k) {
        int maxCount = 0;
        int left = 0;
        int right = 0;
        int len = s.length();
        int []num = new int[26];
        // 双指针 滑动窗口
        while(right<len){
            int index = s.charAt(right)-'A';
            num[index] = num[index]+1;
            maxCount = Math.max(num[index],maxCount);
            if(right-left+1>k+maxCount){
                num[s.charAt(left)-'A']--;
                left++;
            }
            right++;

        }
        return right-left;

    }
    public static void main(String[] args) {
        String s = "AABABBA";
        int k = 1;
        System.out.println(characterReplacement(s, k));
    }
}