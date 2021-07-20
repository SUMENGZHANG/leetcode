/**
 * 排序算法的模型
 */
public class SortModel {
    public static void sort(Comparable[] a){
        // add sort algorithms

    }
    private static boolean less(Comparable v, Comparable w){
        return v.compareTo(w)<0;
    }
    private static void exch(Comparable[]a,int i,int j){
        Comparable t =  a[i];
        a[i] = a[j];
        a[j] = t;
    }
    private static void show(Comparable[] a){
        for (Comparable val: a) {
            System.out.println(val);
            
        }
    }
    public static boolean isSorted(Comparable[] a){
        for(int i = 1;i<a.length;i++){
            if(less(a[i], a[i-1])) return false;
        }
        return true;
    }


}
