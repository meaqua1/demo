package otherclass;

import java.io.IOException;

public class RunTimeDemo {
    public static void main(String[] args) throws IOException {
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("C:\\Users\\hh\\AppData\\Local\\360Chrome\\Chrome\\Application\\360chrome.exe");
    }
}
