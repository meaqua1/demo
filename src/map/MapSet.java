package map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapSet {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("01","张三");
        map.put("02","王五");
        map.put("03","王五");
        map.put("04","李五");


        Set<Map.Entry<String,String>> entrySet = map.entrySet();
        Iterator<Map.Entry<String,String>> it = entrySet.iterator();
        while (it.hasNext()){
            Map.Entry<String,String> me = it.next();
            System.out.println(me.getKey()+"="+me.getValue());
        }


        /*Set<String> keySet = map.keySet();
        Iterator<String> it = keySet.iterator();
        while (it.hasNext()){
            String key = it.next();
            System.out.println(key + "=" + map.get(key));
        }*/
    }


}
