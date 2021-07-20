import java.util.*;
public class Student implements Comparable<Student>{
    private String name;
    private int age;
    private int grade;
    private int clazz;
    
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getAge() {
        return age;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public int getClazz() {
        return clazz;
    }
    public void setClazz(int clazz) {
        this.clazz = clazz;
    }

    public int getGrade() {
        return grade;
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public Student(){

    }
    public Student(String name,int age, int grade, int clazz){
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.clazz = clazz;
    }

    @Override
    public int compareTo(Student stu){
        // 排序方法
        // 年纪 -》 班级 》 name
        if(this.grade<stu.grade){
            return -1;
        }else if(this.grade==stu.grade){
            if(this.clazz<stu.clazz){
                return -1;
            }else if(this.clazz==stu.clazz){
                if(this.age<stu.age){
                    return -1;
                }else if(this.age==stu.age){
                    return 0;

                }else{
                    return 1;
                }

            }else{
                return 1;
            }
        }else{
            return 1;

        }
        
        

    }
    public static void main(String[] args) {
        Student[] arr = new Student[]{
            new Student("小张",15,6,1),
            new Student("小红",4,3,4),
            new Student("小赵",4,1,2)
        };
        Arrays.sort(arr);
        for (Student student : arr) {
            System.out.println(student.name);
            
        }

    }

    

    
}
