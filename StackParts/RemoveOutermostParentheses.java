import java.util.Stack;

/**
 * 有效括号字符串为空 ("")、"(" + A + ")" 或 A + B，其中 A 和 B 都是有效的括号字符串，+ 代表字符串的连接。例如，""，"()"，"(())()" 和 "(()(()))" 都是有效的括号字符串。
 * 如果有效字符串 S 非空，且不存在将其拆分为 S = A+B 的方法，我们称其为原语（primitive），其中 A 和 B 都是非空有效括号字符串。
 * 给出一个非空有效字符串 S，考虑将其进行原语化分解，使得：S = P_1 + P_2 + ... + P_k，其中 P_i 是有效括号字符串原语。
 * 对 S 进行原语化分解，删除分解中每个原语字符串的最外层括号，返回 S 。
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/remove-outermost-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class RemoveOutermostParentheses {
    
    /**
     * 愚蠢版本
     */
    public static String removeOuterParentheses(String S) {
        int left = 0;
        int right = 0;
        String res = "";
        // 将字符串转化为字符数组
        char []arr = S.toCharArray();
        Stack<Character> stack = new Stack<>();
        // 遍历字符数组，利用stack先进后出的作用，完成部分完整的括号匹配
        for (char ch : arr) {
            if('('==ch){
                left++;
                stack.push(ch);
            }
            if(')'==ch){
                right++;
                stack.push(ch);
            }
            // 如果左边和右边想等，可认为是部分完整匹配
            if(left==right){
                String partRes = "";
                while(!stack.isEmpty()){
                    // 得到部分完整的字符串
                    partRes = stack.pop()+partRes;
                }
                // System.out.println(partRes);
                left = 0;
                right = 0;
                // 删除最外侧的括号
                // 去掉第一位
                partRes = partRes.substring(1);
                // 去掉最后一位
                partRes = partRes.substring(0, partRes.length()-1);
                res = res+partRes;

            }
            
        }
    
        return res;
        
    }
    /**
     * 进阶版-参考 力扣大佬的
     *  1. 有一个level的概念
     *  2. 因为部分完整部分是三级（（（））） 那么level 为0，1，2
     *  3. 我们去掉最外面的一层
     *  
     * 
     */
    public static String removeOuterParenthesesVersionTwo(String s){
        int level = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for(char c:s.toCharArray()){
            if(c==')')  --level;
            if(level>=1){
                stringBuilder.append(c);         
            }
            if(c=='(') ++level;
        }
        return stringBuilder.toString();


    }
    public static void main(String[] args) {
        String res = removeOuterParenthesesVersionTwo("(()())(())(()(()))");
        System.out.println(res);

    

    }


    
}
