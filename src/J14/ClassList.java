package J14;

import org.jetbrains.annotations.NotNull;

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

        public String getUid(){
            return this.uid;
        }

        public String getName(){
            return this.name;
        }


        public int compareTo(COMP1110Student o){
            return this.getName().compareTo(o.getName());
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
        System.out.println(studentArray == newArray);//返回false，指向的不是同一个array
        System.out.println(Arrays.equals(studentArray, newArray));//返回true，内部每一个元素指向的同一个对象


        COMP1110Student thirdStudent = studentList.get(2);
        System.out.println(thirdStudent);

        studentList.add(3, new COMP1110Student("jasleen", 23, "u89076", 12, 12, 12));
        //studentList.remove(5); 可以remove某个成员

        Set<COMP1110Student> studentSet = new HashSet<>();
        studentSet.add(studentList.get(0));// set内部是无序的，同样的成员只能添加一次
        boolean added = studentSet.add(studentList.get(1));//会返回是否添加成功了，返回true
        added = studentSet.add(studentList.get(1));//会返回false，因为已经有了同样的成员

        boolean isBobinSet = studentSet.contains(studentList.get(2));//返回false，无法通过这种方式判断是够含有Bob

        Map<String, COMP1110Student> uidMap = new HashMap<>();//类似dict
        for (var student : studentArray){
            uidMap.put(student.getUid(), student);//第一个参数是key，第二个参数是value
        }

        for (var student : uidMap.values()){
            System.out.println(student);
        }

        for (var uid : uidMap.keySet()){//访问key
            System.out.println(uid);
        }

        uidMap.remove("u2345678"); //remove掉key和对应的value
        uidMap.put("u12345", new COMP1110Student("Mary", 23, "u12345", 5, 1, 3));//增加一个元素

        Collections.sort(studentList, (s1, s2) -> s1.getName().compareTo(s2.getName()));//String只之间允许进行compare，按alphabet排序
        //传入一个lambda表达式
        //也可以在COMP1110Student类中override compareTo的方法，sort会直接调用
        //compareTo是String的默认提供方法，可以override
        //Collections.sort(studentList);
















    }
}
