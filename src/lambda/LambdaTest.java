package lambda;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author hh
 * @create 2019-07-25 13:46
 */
public class LambdaTest {
    public static void main(String[] args) {
        Runnable runnable1 = new Runnable() {
            @Override
            public void run() {
                System.out.println("大家好");
            }
        };
        runnable1.run();
        //Lambda写法
        Runnable runnable = () -> System.out.println("你好");
        runnable.run();
    }
}

class Lam2 {
    public static void main(String[] args) {
        Consumer<String> consumer1 = new Consumer<String>() {
            @Override
            public void accept(String s) {
                System.out.println(s);
            }
        };
        consumer1.accept("啦啦啦");

        Consumer<String> consumer = s -> {
//        Consumer<String> consumer = (String s) -> {
            System.out.println(s);
        };
        consumer.accept("哈哈哈");
    }
}

class Lam3 {
    public static void main(String[] args) {
        Comparator<Integer> com = new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1.compareTo(o2);
            }
        };

        Comparator<Integer> com2 = (Integer o1, Integer o2) -> {
            return o2.compareTo(o1);
        };
//      只有一条执行语句，大括号与return可以省略
        Comparator<Integer> com3 = (o1, o2) -> o2.compareTo(o1);

    }
}

class Lam4{
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("张三");
        list.add("李四");
        list.add("王五");
        list.add("赵六");
        for (String s : list) {
            System.out.println(s);
        }

        Comparator<String> com = (o1,o2) -> o2.compareTo(o1);
        list.sort(com);
        System.out.println(list);
        Stream<String> stream = list.stream();
        Stream<String> stream1 = stream.sorted(com);
        List<String> list1 = stream1.collect(Collectors.toList());
        System.out.println(list1);


    }
}