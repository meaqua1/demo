package map;

import java.util.*;

/**
 * @author hh
 * @create 2019-09-24 16:59
 */
public class Com {

    public static void main(String[] args) {
        String s1 = "Hello";
        String s2 = "Hello";
        String s3 = "Hel" + "lo";
        String s4 = "Hel" + new String("lo");
        String s5 = new String("Hello");
        String s6 = s5.intern();
        String s7 = "H";
        String s8 = "ello";
        String s9 = s7 + s8;

        System.out.println(s1 == s2);  // true
        System.out.println(s1 == s3);  // true
        System.out.println(s1 == s4);  // false
        System.out.println(s1 == s9);  // false
        System.out.println(s4 == s5);  // false
        System.out.println(s1 == s6);  // true
        String str = "";
        String[] Str = new String[1];

        String[] split = str.split(",");
        List<String> list = Arrays.asList(Str);
        System.out.println(list);
        for (String s : split) {
            System.out.println(s+"b");
        }
        TreeMap<Person,Integer> treeMap = new TreeMap<>(new My());
        treeMap.put(new Person(26,"张三"),1);
        treeMap.put(new Person(22,"李四"),2);
        treeMap.put(new Person(33,"王五"),3);

        Set<Map.Entry<Person,Integer>> entries = treeMap.entrySet();
        Iterator<Map.Entry<Person,Integer>> iterator = entries.iterator();
        while (iterator.hasNext()){
            Map.Entry<Person, Integer> next = iterator.next();
            System.out.println(next);
        }

    }
}

class Person{
    private Integer age;
    private String name;

    public Person() {
    }

    public Person(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;

        Person person = (Person) o;

        if (age != null ? !age.equals(person.age) : person.age != null) return false;
        return name != null ? name.equals(person.name) : person.name == null;
    }

    @Override
    public int hashCode() {
        int result = age != null ? age.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        return result;
    }


}

class My implements Comparator<Person> {

    @Override
    public int compare(Person o1, Person o2) {
        return o1.getAge().compareTo(o2.getAge());
    }
}