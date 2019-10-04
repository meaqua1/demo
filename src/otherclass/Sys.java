package otherclass;


import java.util.Properties;

public class Sys {
    public static void main(String[] args) {
        Properties pro = System.getProperties();
        for (Object object : pro.keySet()
        ) {
            String value = (String) pro.get(object);
            System.out.println(object + "" + value);
        }
        System.out.println(System.getProperty("os.name"));
    }
}
