package studytest;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * @author hh
 * @create 2019-09-26 17:14
 */
public class sort {
    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        for (int m = 0; m < 100000; m++) {
            int[] arr = new int[]{25, 13, 54, 8, 44, 78, 5, 30, 25, -5, -30};
            while (true) {
                int count = 0;
                for (int i = 0; i < arr.length - 1; i++) {
                    int temp;
                    if (arr[i + 1] < arr[i]) {
                        temp = arr[i + 1];
                        arr[i + 1] = arr[i];
                        arr[i] = temp;
                        count++;
                    }
                }
                if (count == 0)
                    break;
            }
        }
        long end = System.currentTimeMillis();
        long l = end - start;
        System.out.println(l);
    }
}

class BubbleSort {
    public static void main(String[] args) {
        int[] arr = new int[]{25, 13, 54, 8, 44, 78, 5, 30, 25, -5, -30};
        int temp;//临时变量
        for (int i = 0; i < arr.length - 1; i++) {   //表示趟数，一共arr.length-1次。
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
        System.out.println("冒泡排序：");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

class SelctionSort {
    public static void main(String[] args) {
        int[] arr = new int[]{25, 13, 54, 8, 44, 78, -5, -30, 25, 3};
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            if (minIndex != i) {
                int temp = arr[i];
                arr[i] = arr[minIndex];
                arr[minIndex] = temp;
            }
        }
        System.out.println("选择排序：");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

class InsertSort {

    public static void main(String[] args) {
        int[] arr = new int[]{25, 13, 54, 8, 44, 78, -5, -30, 25, 3};
        int temp;
        int count;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j > 0; j--) {
                if (arr[j] < arr[j - 1]) {
                    temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                } else {
                    break;
                }
            }
        }
        System.out.println("插入排序：");
        for (int i : arr) {
            System.out.println(i);
        }
    }
}

class Quicksort {
    public static void main(String[] args) {
        int[] arr = new int[]{25, 13, 54, 8, 44, 78, -5, -30, 25, 3};
        int mid = arr[(arr.length >> 1) - 1];
        for (int i = 0; i < (arr.length >> 1) - 2; i++) {

        }
    }
}

class ss {
    public static void a() {
        System.out.println("b");
    }
}

class Main {
    public static void main(String[] args) {
        int i = 1;
        i = i++;
        int j = i++;
        int k = i + ++i * i++;
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
    }

}

class Single {
    private Single() {
        System.out.println("a");
    }

    private static final Single SINGLE = new Single();

    public static Single getInstance() {
        return SINGLE;
    }


}

class Single2 {
    private Single2() {
    }

    private static Single2 s = null;

    public static Single2 getInstance() {
        if (s == null) {
            synchronized (Single2.class) {
                if (s == null) {
                    s = new Single2();
                }
            }
        }
        return s;
    }

}

class Single3 {
    private Single3() {
    }

    private static final Single3 SINGLE_3 = new Single3();

    public static Single3 getInstance() {
        return SINGLE_3;
    }
}

class Chick {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String stack = scanner.nextLine();
        int m1 = 0;
        int m2 = 0;
        for (int i = 0; i < stack.length(); i++) {
            if (stack.charAt(i) == 'D') {
                String s = stack.substring(0, i);
                m1 += count(s, "C");
            }
        }
        for (int i = 0; i < stack.length(); i++) {
            if (stack.charAt(i) == 'C') {
                String s = stack.substring(0, i);
                m2 += count(s, "D");
            }
        }
        int min = Math.min(m1, m2);
        System.out.println(min);
    }

    public static int count(String stack, String s) {
        String d = stack.replaceAll(s, "");
        return stack.length() - d.length();
    }
}

class ByteMoney {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<Integer> coin = new ArrayList<>();
        while (in.hasNextInt()) {
            coin.add(in.nextInt());
        }
        Collections.sort(coin);
        int i = coin.get(coin.size()-1) - coin.get(0);
        System.out.println(i);
    }
}
