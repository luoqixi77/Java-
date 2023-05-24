package test;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/5 12:06
 * @Description TODO
 */
public class Two {
    public static void main(String[] args) throws InterruptedException {
        One one = new One();
        one.setA(msg -> System.out.println(msg));
        one.test();

    }
}
