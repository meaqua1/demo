package studytest;

public class FanXingmethod {
    public  <T> T add(T t,T t2){
        System.out.println(t);
        System.out.println(t2);
        return t;
    }

}
class TTt{
    public static void main(String[] args) {
        FanXingmethod f = new FanXingmethod();
        System.out.println(f.add(3, 4));
        f.add("aa",4);
    }
}