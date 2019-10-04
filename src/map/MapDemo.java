package map;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class MapDemo {
    public static void main(String[] args) {
        Map<String,String> map = new HashMap<>();
        map.put("张三","18");
        map.put("王五","18");
        map.put("张三2","18");
        map.remove("张三2");
        boolean b = map.containsKey("张三2");
        System.out.println(b);
        Collection coll = map.values();
        System.out.println(coll);
    }
}
