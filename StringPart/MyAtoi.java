import java.util.*;

/**
 * 
 */
public class MyAtoi {
    /**
     * 1. 遍历，得到的所有数值都放入一个容器 2. 求出长度最长的，保存符号
     * 2. 臃肿的代码解决方案不可取
     * 
     * @param s
     * @return
     */
    public static int myAtoi(String s) {
        
        if(s.length()==0) return 0 ;
        char[] arr = s.toCharArray();
        if (arr.length == 1) {
            if (arr[0] - '0' >= 0 && arr[0] - '0' <= 9)
                return arr[0]-'0';
            else
                return 0;
        }
        // 创建一个容器
        long rest = 0;
        int sign = 0;
        // 快慢指针遍历 存入每一个数值
        int indexOne = 0;
        int indexTwo = 1;
        char now = arr[indexOne];
        while (indexOne < arr.length && arr[indexOne] == ' ')
            indexOne++;
        if (indexOne == arr.length)
            return 0;
        indexTwo = indexOne + 1;
        // 第一位是数字
        // 第一位是正负号且第二位是数字
        if (!(((arr[indexOne] == '-'||arr[indexOne]=='+')&& (
               arr[indexTwo] - '0' >= 0 && arr[indexTwo] - '0' <= 9))
                || (arr[indexOne] - '0' >= 0 && arr[indexOne] - '0' <= 9)))
            return 0;

        // 第一位肯定是正负或者数字了，如果不是数字就往后挪动
        while (!(arr[indexOne] - '0' >= 0 && arr[indexOne] - '0' <= 9)) {
            indexOne++;
        }
        indexTwo = indexOne;

        // 在长度之内的数字
        while (indexTwo < arr.length && (arr[indexTwo] - '0' >= 0 && arr[indexTwo] - '0' <= 9)) {
            indexTwo++;
        }
        // 切割字符串，然后往后挪
        String curVal = s.substring(indexOne, indexTwo);
        if (curVal != null || curVal.equals(" ")) {
            // 去除前面为0的数
            curVal = curVal.replaceFirst("^0*", "");
            if(curVal.length()==0) return 0;
            // 判断是否为负数
            if (indexOne == 0 || (indexOne >= 1 && arr[indexOne - 1] != '-')) {
                sign = 0;
            } else {
                sign = 1;
            }
            if(curVal.length()>10){
                if(sign==0){
                    rest = Integer.MAX_VALUE;
                    return (int) rest;

                }else{
                    rest = Integer.MIN_VALUE;
                    return (int)rest;
                }

            }else{
                rest = Long.valueOf(curVal);
            }
            

        }

        if (sign == 1)
            rest = -rest;
        if(rest>Integer.MAX_VALUE) rest = Integer.MAX_VALUE;
        if(rest<Integer.MIN_VALUE) rest = Integer.MIN_VALUE;
        return (int) rest;

    }


    /**
     * 确定有限状态机
     */
    public static int myAtoiAd(String s){
        Automaton automaton = new Automaton();
        int length = s.length();
        for (int i = 0; i < length; ++i) {
            automaton.get(s.charAt(i));
        }
        return (int) (automaton.sign * automaton.ans);
        

    }
    public static void main(String[] args) {
        String s = "2147483648";
        System.out.println(myAtoiAd(s));

    }

}

class Automaton {
    public int sign = 1;
    public long ans = 0;
    private String state = "start";
    
    private Map<String, String[]> table = new HashMap<String, String[]>() {{
        put("start", new String[]{"start", "signed", "in_number", "end"});
        put("signed", new String[]{"end", "end", "in_number", "end"});
        put("in_number", new String[]{"end", "end", "in_number", "end"});
        put("end", new String[]{"end", "end", "end", "end"});
    }};

    public void get(char c) {
        state = table.get(state)[get_col(c)];
        if ("in_number".equals(state)) {
            ans = ans * 10 + c - '0';
            ans = sign == 1 ? Math.min(ans, (long) Integer.MAX_VALUE) : Math.min(ans, -(long) Integer.MIN_VALUE);
        } else if ("signed".equals(state)) {
            sign = c == '+' ? 1 : -1;
        }
    }

    private int get_col(char c) {
        if (c == ' ') {
            return 0;
        }
        if (c == '+' || c == '-') {
            return 1;
        }
        if (Character.isDigit(c)) {
            return 2;
        }
        return 3;
    }
}
