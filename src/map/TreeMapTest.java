package map;

import java.util.Map;
import java.util.TreeMap;

public class TreeMapTest {
    public static Map<Character, Integer> findCount(String s){
        System.out.println(s.toCharArray()[1]);
        TreeMap<Character,Integer> map = new TreeMap();
        for (int i = 0; i < s.length(); i++) {
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else{
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }

        }
        return map;

    }
    public static void main(String[] args) {
        System.out.println(findCount("cvccavd"));


    }
}
