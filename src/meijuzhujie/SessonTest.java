package meijuzhujie;

/**
 * @author hh
 * @create 2019-07-20 10:45
 */
public class SessonTest {


}

class Sesson{//自定义枚举类
    private final String sessonName;
    private final String sessonDesc;

    private Sesson(String sessonName, String sessonDesc) {
        this.sessonName = sessonName;
        this.sessonDesc = sessonDesc;
    }

    public static final Sesson spring = new Sesson("春天","春暖花开");

    public String getSessonName() {
        return sessonName;
    }

    public String getSessonDesc() {
        return sessonDesc;
    }
}

enum Sesson1 implements M{

    SPRING("春天","春暖花开"){
        @Override
        public void Aa() {

        }
    },
    SUMMER("夏天","夏日炎炎"){
        @Override
        public void Aa() {

        }
    };
    private final String sessonName;
    private final String sessonDesc;
    Sesson1(String sessonName, String sessonDesc) {
        this.sessonName = sessonName;
        this.sessonDesc = sessonDesc;
    }

    public String getSessonName() {
        return sessonName;
    }

    public String getSessonDesc() {
        return sessonDesc;
    }
}

class Ttt{
    public static void main(String[] args) {
        System.out.println(Sesson1.SPRING.getSessonName());
        Sesson1[] values = Sesson1.values();
        for (Sesson1 value : values) {
            System.out.println(value);
        }
        Sesson1 winter = Sesson1.valueOf("SPRING");
        System.out.println(winter);




    }


}

interface M{
    void Aa();
}

enum Aa{
    SUM,AAA;
}

class Aaaa{
    public static void main(String[] args) {
        Aa[] values = Aa.values();
        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i]);

        }
        System.out.println(Aa.values());

    }
}


