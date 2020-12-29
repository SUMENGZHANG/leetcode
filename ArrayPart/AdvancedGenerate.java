/**
 * leetcode 119
 */

import java.util.*;
public class AdvancedGenerate {
    public static List<Integer> getRow(int rowIndex) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        if(rowIndex==0) return list;
        list.add(1);

        for(int i = 1;i<rowIndex;i++){
             for(int j = 0;j<i;j++){
                 list.set(j,list.get(j+1)+list.get(j));
             }
             list.add(0,1);
        }

        return list;
   }
   public static void main(String[] args) {
       List<Integer> res = getRow(3);
       for (Integer integer : res) {
           System.out.println(integer);
       }
   }
    
}
