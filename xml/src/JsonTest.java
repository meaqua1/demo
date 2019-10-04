import com.fasterxml.jackson.databind.ObjectMapper;
import domain.Person;
import org.junit.Test;

import java.util.*;

/**
 * @author hh
 * @create 2019-08-11 13:46
 */
public class JsonTest {
    //java对象转json


    @Test
    public void Test() throws Exception {
        Person p1 = new Person("张三",23,"男");
        Person p2 = new Person("张三在",33,"女");
        Person p3 = new Person("张三咋",27,"男");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        p1.setDate(new Date());
        ObjectMapper mapper = new ObjectMapper();
        String value = mapper.writeValueAsString(p1);
        System.out.println(value);

        String s = mapper.writeValueAsString(list);
        System.out.println(s);
        //将数据储存到"d://a.txt"中
//        mapper.writeValue(new File("d://a.txt"),p1);
    }
    @Test
    public void Test2() throws Exception {
        Person p1 = new Person("张三",23,"男");
        Person p2 = new Person("张三在",33,"女");
        Person p3 = new Person("张三咋",27,"男");
        List<Person> list = new ArrayList<>();
        list.add(p1);
        list.add(p2);
        list.add(p3);

        Map<String,Object> map = new HashMap<>();
        map.put("name","zhangsan");
        map.put("age",23);
        ObjectMapper mapper = new ObjectMapper();
        String s = mapper.writeValueAsString(list);
        System.out.println(s);
    }
}
