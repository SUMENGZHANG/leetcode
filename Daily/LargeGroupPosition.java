import java.util.*;

/**
 *        leetcode 830
 */
public class LargeGroupPosition {
    /**
     * 我的解法 O(n**2)
     */
    public static List<List<Integer>> largeGroupPositions(String s) {

        LinkedList<List<Integer>> queue = new LinkedList<>();
        List<List<Integer>> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        if (arr.length == 0 || arr.length == 1)
            return res;
        int indexOne = 0;
        int indexTwo = 0;
        int count = 3;
        // 一次遍历
        for (int i = indexOne; i < arr.length; i++) {
            int curCount = 0;
            indexTwo = indexOne;
            while (indexTwo < arr.length && arr[indexOne] == arr[indexTwo]) {
                indexTwo++;
                curCount++;
            }
            // 大于等于3就可以被计算
            if (curCount >= count) {
                List<Integer> list = new ArrayList<>();
                list.add(indexOne);
                list.add(indexOne + curCount - 1);
                queue.addLast(list);
                indexOne = indexTwo;
            } else {
                indexOne++;
            }

        }

        while (!queue.isEmpty()) {
            res.add(queue.pollFirst());
        }
        return res;

    }

    /**
     * 时间复杂度 O(n)
     * 
     * @param s
     * @return
     */
    public static List<List<Integer>> largeGroupPositionsAd(String s) {
        List<List<Integer>> res = new ArrayList<>();
        char[] arr = s.toCharArray();
        int indexOne = 0;
        int indexTwo = 1;
        int count = 1;
        while (indexOne < arr.length) {

            if (indexTwo < arr.length && arr[indexOne] == arr[indexTwo]) {
                count++;
                indexTwo++;

            } else {
                if (count >= 3) {
                    List<Integer> list = new ArrayList<>();
                    list.add(indexOne);
                    list.add(indexOne + count - 1);
                    res.add(list);
                    indexOne = indexTwo;
                    count = 1;
                } else {
                    count = 1;
                    indexOne++;

                }
                indexTwo = indexOne + 1;
                if (indexTwo >= arr.length)
                    break;
            }

        }
        return res;
    }

    /**
     * 精简
     */
    public List<List<Integer>> largeGroupPositionsSimple(String s) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        int n = s.length();
        int num = 1;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || s.charAt(i) != s.charAt(i + 1)) {
                if (num >= 3) {
                    ret.add(Arrays.asList(i - num + 1, i));
                }
                num = 1;
            } else {
                num++;
            }
        }
        return ret;

    }

    public static void main(String[] args) {
        String s = "aaa";
        System.out.println(largeGroupPositionsAd(s));

    }

}
