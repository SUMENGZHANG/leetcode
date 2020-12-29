import java.util.ArrayList;

/**  leetcode 118
 * 给定一个非负整数 numRows，生成杨辉三角的前 numRows 行。
 */
import java.util.*;
public class Generate {
     
     public static List<List<Integer>> generate(int numRows) {
         LinkedList<List<Integer>> res = new LinkedList<>();
         for(int i = 1;i<=numRows;i++){
             List<Integer> curList = new ArrayList<>();
             if(i==1){
                 curList.add(1);
             }else if(i==2){
                 curList.add(1);
                 curList.add(1);
             }else{
                 // 得到上一个list
                 List<Integer> lastList = res.peekLast();
                 int []arr = new int[lastList.size()];
                 int index = 0;
                 for (int val : lastList) {
                     arr[index++] = val; 
                 }

                 for(int j = 0;j<i;j++){
                     if(j==0||j==i-1){
                         curList.add(1);
                     }else{
                         curList.add(arr[j]+arr[j-1]);
                     }

                 }


             }
             res.add(curList);

         }

         return res;

    }
    public static void main(String[] args) {
        List<List<Integer>> res = generate(3);
        for (List<Integer> list : res) {
            for (int list2 : list) {
                System.out.println(list2);
                
            }
        }
    }
}
