package other.stream;

import java.util.TreeSet;

/**
 * @author keboom
 * @date 2021/8/6 20:08
 */
public class LambdaTest {

    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };

        Runnable runnable2 = () -> System.out.println("hell");

        TreeSet<String> set = new TreeSet<>(((o1, o2) -> Integer.compare(o1.length(), o2.length())));


    }
}
