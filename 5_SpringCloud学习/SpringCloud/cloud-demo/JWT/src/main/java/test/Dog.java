package test;

/**
 * @author 20739
 */
public class Dog extends Pet {
    public Dog(String name, int full, int happy) {
        super(name, full, happy);
    }
    public Dog(String name) {
        super(name);
    }
    @Override
    public String cry() {
        return "汪~";
    }
}

