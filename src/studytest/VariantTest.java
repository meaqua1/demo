package studytest;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author hh
 * @create 2019-09-21 10:55
 */
public class VariantTest {
    public static void main(String[] args) throws Exception {
        ArrayList a = new ArrayList<>();


            print(a);

    }
    static void print(List list) throws Exception {
        int a;
        Class c = list.getClass();
        //elementData 就是ArrayList用于底层存储数据的数组,
        //我们通过观察数组长度的变化来证明我们所说的扩容机制正确性
        Field f = c.getDeclaredField("elementData");
        //设置可访问
        f.setAccessible(true);
        //反射对象
        Object[] elementData = (Object[])f.get(list);
        System.out.println("elementData.length" + elementData.length + ",size" + list.size());
    }
}
class MyThreadThree implements Callable<Integer> {

    public static void main(String[] args) throws InterruptedException {
        MyThreadThree myThreadThree = new MyThreadThree();
        FutureTask<Integer> ft = new FutureTask<>(myThreadThree);
        FutureTask<Integer> ft1 = new FutureTask<>(myThreadThree);
        System.out.println(Thread.currentThread().getName() + "===== ");

        try {
            System.out.println("return thread-1'result ：" + ft.get());
            System.out.println("return thread-2'result ：" + ft1.get());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    public Integer call() throws Exception {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() + " " + i);
        }
        return 20;
    }
}

class Yy{
    public void a(){
        System.out.println("yy");
    }
}
class Bb{
    public void a(){
        System.out.println("Bb");
    }
}
class ThreadLocalExample {
    public static class MyRunnable implements Runnable {

/*        private ThreadLocal<Integer> threadLocal =
                new ThreadLocal<Integer>();*/

        @Override
        public void run() {
            /*threadLocal.set((int) (Math.random() * 100D));

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }

            System.out.println(threadLocal.get());*/
            for (int i = 0; i < 20; i++) {
                System.out.println(Thread.currentThread().getName()+"==="+i);
            }
        }
    }


    public static void main(String[] args) throws InterruptedException {
        MyRunnable sharedRunnableInstance = new MyRunnable();

        Thread thread1 = new Thread(sharedRunnableInstance);
        Thread thread2 = new Thread(sharedRunnableInstance);

        thread1.start();
        thread1.join(); //wait for thread 1 to terminate
        thread2.start();

    }
}