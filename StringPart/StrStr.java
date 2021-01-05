/**
 * 
 */
public class StrStr {
    /**
     * 遍历
     */
    public static int strStr(String haystack, String needle) {
        // 如果 needle为空
        if ("".equals(needle))
            return 0;
        // 如果不包含就返回-1

        for (int i = 0; i <= haystack.length() - needle.length(); i++) {

            if (haystack.substring(i, i + needle.length()).equals(needle)) {
                return i;

            }

        }
        return -1;

    }

    /**
     * 遍历改进
     * 
     * @param args
     */
    public static int strStrBetter(String haystack, String needle) {
        // 如果 needle为空
        if ("".equals(needle))
            return 0;
    
         //  长度预先统计，避免预算过多的时间
        int len1 = haystack.length();
        int len2 = needle.length();
        for (int i = 0; i <= len1 - len2; i++) {
            if (haystack.substring(i, i + len2).equals(needle)) {
                return i;
            }
        }
        return -1;

    }

    public static void main(String[] args) {
        String haystack = "hello";
        String needle = "ll";
        System.out.println(strStr(haystack, needle));

    }

}
