package fanshe;

import java.lang.reflect.*;

/**
 * @author hh
 * @create 2019-07-24 14:20
 */
public class Refiect {


    public static void main(String[] args) throws Exception {
        Class clazz = Person.class;
        Constructor constructor = clazz.getConstructor(String.class, int.class);
        Object obj = constructor.newInstance("Tom", 12);
        Person p = (Person)obj;
        System.out.println(p.toString());
        Field age = clazz.getDeclaredField("age");
        age.set(p,10);
        System.out.println(p);
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(p);


        Constructor constructor1 = clazz.getDeclaredConstructor(String.class);
        constructor1.setAccessible(true);
        Object obj1 = constructor1.newInstance("jay");
        Person p1 = (Person)obj1;
        System.out.println(p1);
        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p1,"kangkang");
        System.out.println(p1);
        Method show2 = clazz.getDeclaredMethod("show2", String.class);
        show2.setAccessible(true);
        System.out.println(show2.invoke(p1, "China"));


    }



}
class Person{
    String name;
    public int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private Person(String name) {
        this.name = name;
    }

    public Person() {
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
    public static void show(){
        System.out.println("我是一个人");
    }
    private String show2(String nation){
        System.out.println(nation+"1");
        return nation;

    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

class Ref{

    public static void main(String[] args) throws Exception {
        Class<Person> clazz = Person.class;
        Person p = clazz.newInstance();//必须有一个空参构造器
        /*Method show2 = clazz.getDeclaredMethod("show2", String.class);
        show2.setAccessible(true);
        Object invoke = show2.invoke(p,"a");*/
        System.out.println(p);
        for (Field f : clazz.getFields()) {
            System.out.println(f);
            System.out.println(f.getModifiers());
        }//获取运行时类及父类声明为public访问权限的属性

        clazz.getDeclaredFields();//获取运行时类所有属性，不包括父类
        for (Field f : clazz.getDeclaredFields()) {
            System.out.println(f);
            System.out.println(f.getModifiers());
            System.out.println(Modifier.toString(f.getModifiers()));//权限
            System.out.println(f.getType().getName());//数据类型
            System.out.println(f.getName());//属性名
        }

        Field name = clazz.getDeclaredField("name");
        name.setAccessible(true);
        name.set(p,"张三");
        System.out.println(name.get(p));

        Method show2 = clazz.getDeclaredMethod("show2", String.class);
        show2.setAccessible(true);
        Object china = show2.invoke(p,"China");
        System.out.println(china);


    }

}

class ref3{
    public static void main(String[] args) throws Exception {
        Class clazz = Class.forName("fanshe.Person");
        Method show = clazz.getDeclaredMethod("show");
        show.invoke(Person.class);

        Constructor constructor = clazz.getDeclaredConstructor(String.class);
        constructor.setAccessible(true);
        Object o = constructor.newInstance("李四");
        System.out.println(o);
    }
}
