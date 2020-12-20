import java.util.*;

/**
 * 给你一个字符串 s ，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证 返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 */
public class RemoveDuplicateLetters {
    /**
     * 
     * 
     * @param s
     * @return
     */
    public static String removeDuplicateLettersOnMyWay(String s) {

        // 维护一个栈
        Deque<Character> deque = new LinkedList<>();
        // 遍历这个字符数组
        char[] arr = s.toCharArray();
        // 通过一个key value 存储数量
        Map<Character, Integer> map = new HashMap<>();
        for (char c : arr) {
            if (map.containsKey(c)) {
                int cur = map.get(c);
                map.put(c, ++cur);
            } else {
                map.put(c, 1);
            }

        }
        String res = "";

        for (int i = 0; i < arr.length; i++) {

            char curVal = arr[i];
            // 如果栈不为空，且栈中前面的值比当前的值大，且不是唯一的
            if (!deque.contains(curVal)) {
                while (!deque.isEmpty() && deque.peekLast() > curVal && map.get(deque.peekLast()) > 1) {
                    int val = map.get(deque.peekLast());
                    map.put(deque.peekLast(), --val);
                    deque.pollLast();

                }
                deque.add(curVal);
            } else {
                int val = map.get(curVal);
                map.put(curVal, --val);
            }
        }
        while (!deque.isEmpty()) {
            res = res + deque.pollFirst();
        }
        return res;

    }

    public static void main(String[] args) {
        String s = "bbcaac";
        // System.out.println((char)-1);
        System.out.println(removeDuplicateLettersOnMyWay(s));
    }

}
