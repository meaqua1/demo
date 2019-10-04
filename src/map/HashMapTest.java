package map;

import java.util.*;

public class HashMapTest {
    public static void main(String[] args) {
//        treeMap<student, String> treeMap = new treeMap<>();
        TreeMap<student, String> treeMap = new TreeMap<>();
        treeMap.put(new student("张三", 21), "北京");
        treeMap.put(new student("王五", 21), "上海");
        treeMap.put(new student("李四", 18), "南京");
        treeMap.put(new student("小明", 21), "荷兰");

        Set<Map.Entry<student, String>> entrySet = treeMap.entrySet();
        Iterator<Map.Entry<student, String>> it = entrySet.iterator();
        while (it.hasNext()) {
            Map.Entry me = it.next();
            student stu = (student) me.getKey();
            System.out.print(stu.getName() + " " + stu.getAge() + " ");
            System.out.println(me.getValue());

        }

    }
}

class student implements Comparable<student> {
    private String name;
    private int age;

    public student(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }


    @Override
    public int compareTo(student o) {
        int num = new Integer(this.age).compareTo(new Integer(o.age));
        if (num == 0) {
            return name.compareTo(o.name);
        }
        return num;
    }
}

class MyCom implements Comparator<student> {


    @Override
    public int compare(student o1, student o2) {
        int num = new Integer(o1.getAge()).compareTo(new Integer(o2.getAge()));
        if (num == 0) {
            return o1.getName().compareTo(o2.getName());
        }
        return num;
    }
}
