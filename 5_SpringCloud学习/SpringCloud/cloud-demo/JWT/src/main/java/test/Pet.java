package test;

/**
 * @author 20739
 */
public class Pet implements Animal {
    private String name;
    private int full;
    private int happy;

    public Pet(String name) {
        this(name, 50, 50);
    }

    public Pet(String name,int full,int happy) {
        this.name = name;
        this.full = full;
        this.happy = happy;
    }

    public void feed() {//宠物的喂食方法
        if(full == 100) {
            System.out.println(name+"已经吃饱了");
            return;
        }
        System.out.println("给"+name+"喂食");
        full += 10;
        System.out.println("饱食度："+full);
    }

    @Override
    public void play() {//宠物的互动玩耍方法
        if(full == 0) {
            System.out.println(name+"已经饿得玩不动了");
            return;
        }
        System.out.println("陪"+name+"玩耍");
        happy += 10;
        full -= 10;
        System.out.println("快乐度："+happy);
        System.out.println("饱食度："+full);
    }

    public void punish() {//宠物的惩罚方法
        //子类不同的代码，改成调方法
        System.out.println(
                "打"+name+"的pp，"+name+"哭叫："+cry());
        happy -= 10;
        System.out.println("快乐度："+happy);
    }

    public String cry() {//小动物被打哭了
        //无意义代码
        //cry()方法需要在子类中重写，返回具体哭叫声
        return "此处有哭叫声";
    }
}

