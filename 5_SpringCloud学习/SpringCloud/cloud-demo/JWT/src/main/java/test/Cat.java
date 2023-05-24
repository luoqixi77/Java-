package test;

/**
 * @author 20739
 */
public class Cat extends Pet{
    public Cat(String name, int full, int happy) {
        super(name, full, happy);
    }
    public Cat(String name) {
        super(name);
    }
    @Override
    public String cry() {
        return "喵~";
    }
}

