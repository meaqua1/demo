package map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListSort {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bb");
        list.add("ace");
        list.add("cbbbdc");
        list.add("zzzd");

        Collections.sort(list,new ZiCom());
//        Collections.swap(list,1,2);
//        Collections.shuffle(list);
        System.out.println(list);

    }
}
class ZiCom implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        int num =  -(o1.length()-o2.length());
        if (num == 0){
            return o1.compareTo(o2);
        }
        return num;
    }
}
