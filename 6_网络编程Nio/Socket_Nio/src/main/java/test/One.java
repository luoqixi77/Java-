package test;

/**
 * @author luoqixi77
 * @version V1.0
 * @date 2023/5/5 12:05
 * @Description TODO
 */
public class One {

    private a a1;


    public interface a{
        void goBack(String msg);
    }

    public void setA(a a1) throws InterruptedException {
        Thread.sleep(2000);
        this.a1 = a1;
    }

    public void B(String msg){
        a1.goBack(msg);
    }

    public void test(){
        String msg="111";
        B(msg);
    }
}
