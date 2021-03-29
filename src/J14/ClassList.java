package J14;

import java.util.*;

public class ClassList {
    public static class COMP1110Student{
        String name;
        int age;
        int ass1;
        int ass2;
        int ass3;
        String uid;


        COMP1110Student(String name, int age, String uid, int ass1, int ass2, int ass3){
            this.name = name;
            this.age = age;
            this.ass1 = ass1;
            this.ass2 = ass2;
            this.ass3 = ass3;
            this.uid = uid;
        }
    }

    public static void main(String[] args) {
        COMP1110Student studentArray[] = {
                new COMP1110Student("Mary", 19, "u2345678", 4, 15, 5),
                new COMP1110Student("Josh", 29, "u2345678", 4, 15, 5),
                new COMP1110Student("Bob", 17, "u2345678", 4, 15, 5),
                new COMP1110Student("Via", 12, "u2345678", 4, 15, 5),
        };

        List<COMP1110Student> studentList = new ArrayList<>(Arrays.asList(studentArray));//just like the below code
//        for (var student : studentArray){
//            studentList.add(student);
//        }
        List<COMP1110Student> studentsList1 = new ArrayList<>();
        studentsList1.addAll(Arrays.asList(studentArray));//把所有的studentArray成员全部加进来,和上面代码等价

        for (var student : studentList) {
            System.out.println(student);
        }

        var newArray = studentList.toArray(new COMP1110Student[studentList.size()]);
        //必须给toArray()里面传入一个想要转换的类数组的初始化实例对象（相同长度）

        COMP1110Student thirdStudent = studentList.get(2);
        System.out.println(thirdStudent);

        studentList.add(3, new COMP1110Student("jasleen", 23, "u89076", 12, 12, 12));
        //studentList.remove(5); 可以remove某个成员

        Set<COMP1110Student> studentSet = new HashSet<>();
        studentSet.add(studentList.get(0));// set内部是无序的
        studentSet.add(studentList.get(1));







    }
}
