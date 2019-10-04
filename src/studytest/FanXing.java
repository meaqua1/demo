package studytest;

public class FanXing {
    public static void main(String[] args) {
        Demo<Integer> demo = new Demo<>();
        demo.print(5);
        demo.show(4);
    }


}

class Demo<T> {
    public void show(T t) {
        System.out.println(t);
    }

    public void print(T t) {
        System.out.println(t);
    }
}