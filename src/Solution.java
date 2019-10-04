import java.io.Serializable;
import java.util.Objects;

public class Solution implements Serializable {

    private static final long serialVersionUID = -6888569084489318695L;

    //psvm  main方法快捷键
    public static void main(String[] args) {
        //sout 输出语句快捷键
        System.out.println("1");
        //fori  简单for循环
        for (int i = 0; i < 10; i++) {

        }
        String arr[] = {"aaa", "bbb", "ccc"};
        //arr.for   增强for循环快捷键
        for (String s : arr) {
            System.out.println(s);
        }
        //Ctrl+Alt+T    生成包裹语句
        if (true) {
            System.out.println();
        } else {
        }
    }
}

//Ctrl+Alt+L    代码格式对齐
class Student {
    private String name;
    private int age;
    //Alt+Insert    生成构造方法，getset方法等快捷键

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public Student(String name, int age) {
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
}