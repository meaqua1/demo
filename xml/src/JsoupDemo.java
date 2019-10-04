import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;
import java.io.IOException;

/**
 * @author hh
 * @create 2019-08-03 19:20
 */
public class JsoupDemo {
    public static void main(String[] args) throws IOException {
        String path = JsoupDemo.class.getClassLoader().getResource("student.xml").getPath();
        Document document = Jsoup.parse(new File(path), "utf-8");
        /*System.out.println(document);*/

        Elements name = document.select("name > xing");//获取name标签下标签为xing的对象
        System.out.println(name);
        System.out.println("---------------------");
        Elements elements = document.getElementsByTag("name");//获取标签为xx的所有对象
        Element element = elements.get(0);
        String text = element.text();//获取文本内容,仅获取文本
        System.out.println(text);
        String html = element.html();//获取标签内所有内容,包括子标签
        System.out.println(html);

        String id = elements.get(1).attr("id");//根据属性获取属性值
        System.out.println(id);

        /*Elements number = document.getElementsByAttribute("number");//获取属性为number的所有对象
        System.out.println(number);*/
        /*Elements elementsByAttributeValue = document.getElementsByAttributeValue("id", "aaa");
        //获取属性与属性值对应的所有对象
        System.out.println(elementsByAttributeValue);*/
        /*Element itcast = document.getElementById("itcast");
        //获取id为xx的对象
        System.out.println(itcast);*/
        /*URL url = new URL("https://www.baidu.com");
        Document document1 = Jsoup.parse(url, 10000);
        System.out.println(document1);*/
    }
}
