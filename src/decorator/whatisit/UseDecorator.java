package decorator.whatisit;

public class UseDecorator {
    public static void main(String[] args) {
        TheType inst = new DecoratingClass(
                new TopClass());
        System.out.println(inst.doTheOperation());
    }
}
