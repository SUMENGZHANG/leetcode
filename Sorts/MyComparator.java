/**
 *  重写排序大小的方法
 */
import java.util.*;
public class MyComparator implements Comparator<Student>{
    public int compare(Student s1, Student s2){
        return s1.getGrade()-s2.getGrade();
    }
    
    public static void main(String[] args) {
        Student[] arr = new Student[]{
            new Student("小张",15,0,1),
            new Student("小红",4,3,4),
            new Student("小赵",4,1,2)
        };
        Arrays.sort(arr,new MyComparator());
        for (Student student : arr) {
            System.out.println(student.getName());
        }
    }
    
}
