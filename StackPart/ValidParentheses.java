import java.util.*;


public class ValidParentheses {
    public static  boolean isValid(String s) {
        Stack<Character> charStack = new Stack<Character>();
        Map<Character,Character> map = new HashMap<Character,Character>();
         // add parenthese map 可以封装成一个方法
         map.put( '}','{');
         map.put(']','[');
         map.put(')','(');
        
        char []arr = s.toCharArray();
        for (char c : arr) {
            // 如果为空，则直接放入
            if(charStack.empty())
            {
                charStack.push(c);
            }else{
                 // 不为空则判断，最顶端是不是一样，一样则POP，不一样继续放
                if(charStack.peek()==map.get(c)){
                    charStack.pop();
                }else{
                    charStack.push(c);
                }

            }

        }
        if(charStack.size()==0){
            return true;
        }
        return false;



    }
    public static void main(String[] args) {
        String s = "()[{}";
        System.out.println(isValid(s));
    }
}
