package map;

import java.util.ArrayList;
import java.util.Iterator;

public class ArraysDemo{
    public static void main(String[] args) {
        /*Integer arr[] = {2,3,4};
        List<Integer> list = Arrays.asList(arr);
        System.out.println(list.remove(0));*/
        ArrayList<Integer> alist = new ArrayList();
        alist.add(1);
        alist.add(2);
        alist.add(3);
        alist.add(4);
        alist.add(5);

        Iterator<Integer> iterator = alist.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        alist.replaceAll((a -> {
            if (a.equals(1))
                return 2;
            else return a;
        }));
        for (Integer s : alist) {
            System.out.println(s);
        }


        /*Integer[] arr = alist.toArray(new Integer[alist.size()]);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);

        }*/


    }
}
