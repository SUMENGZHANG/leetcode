import java.util.*;

/**
 *  leetcode 1178 猜字谜
 * */
 public class FindNumOfValidWords {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0;i<puzzles.length;i++){
            int count = 0;
            for(int j = 0;j<words.length;j++){
                if(isValid(words[j], puzzles[i])){
                    count++;
                }

            }
            res.add(count);
        }
        return res;

        

    }
    public boolean isValid(String word,String puzzle){
        // puzzle 第一个字母
        if(!word.contains(puzzle.substring(0,1))) return false;
        // puzzle 使用hashset统计
        HashSet<Character> set = new HashSet<>();
        for(int i = 0;i<puzzle.length();i++){
            set.add(puzzle.charAt(i));
        }
        for (int i = 0;i<word.length();i++){
            if(!set.contains(word.charAt(i))){
                return false;

            }
        }
        return true;



    }

    /**
     *  
     * @param words
     * @param puzzles
     * @return
     */
    public List<Integer> findNumOfValidWordsWithBit(String[] words, String[] puzzles) {
        List<Integer> res = new ArrayList<>();
        Map<Integer,Integer> state = new HashMap<>();
        for(int i = 0;i<words.length;i++){
            String s = words[i];
            int temp = 0;
            for(int j = 0;j<s.length();j++){
                // 起到的效果是，哪个字母出现，就在二进制位对应位置变成1 
                // 例子： 's'-'a'是18  1<<18 第18位是1 
                temp = temp|(1<< s.charAt(j)-'a');
            }
            state.put(temp,state.getOrDefault(temp, 0)+1);

        }

        for(int i = 0;i<puzzles.length;i++){
            String s = puzzles[i];
            int temp = 0;
            // 求到每个puzzle 哪几位是1 
            for(int j = 0;j<s.length();j++){
                temp = temp|(1<<s.charAt(j)-'a');
            }
            int count = 0;
            
    //  核心技术：n = (n-1)&puzzle    枚举s 的子集 k
            for(int k=temp;k!=0;k = (k-1)&temp){

                if((1<<(s.charAt(0)-'a')&k)!=0) count +=state.getOrDefault(k, 0);
            }
            res.add(count);
        }
        return res;
    } 

    /**
     * 
     * @param words
     * @param pizzles
     * @return
     */
    public List<Integer> findNumOfValidWordsWithSimple(String[] words,String[] pizzles){

        List<Integer> res = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        for(String word:words){
            // 每一个单词包含的 字符都可以在一个 长度为 26的二进制编码上表示位置
            list.add(getBin(word));
        }
        for (String str : pizzles) {
            res.add(getCount(list, str));
            
        }
        return res;


    }

    /**
     *      puzzle 和 list（words）
     */
    public int getCount(List<Integer> list,String str){
        int ans = 0;
        int puzzleBin = getBin(str);
        int first = str.charAt(0)-'a';
        for (int w : list) {
            if((w>>first&1)==0) continue;
            if((w&puzzleBin)==w) ans++;
            
        }
        return ans;


    }


    /**
     * 二进制表示一个str
     * @param str
     * @return
     */
    public Integer getBin(String str){
        int t = 0;
        char[] cs = str.toCharArray();
        for (char c : cs) {
            // 每一位字符所对应二进制数字中哪一位
            int u = c - 'a';
            // 如果当前位置为 0，代表还没记录过，则进行记录 (不重复记录)
            if ((t >> u & 1) == 0) t += 1 << u;
        }
        return t;


    }


}
