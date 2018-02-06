package decorator.whatisit;

public class DecoratingClass implements TheType {

    private final TheType decoratedInst;

    DecoratingClass(TheType inner) {
        decoratedInst = inner;
    }

    @Override public String doTheOperation() {
        return decoratedInst.doTheOperation() + ", and do something extra";
    }
}
