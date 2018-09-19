package proxy;

public class Proxy implements Subject {
    private Subject mSubject;

    public Proxy(Subject subject) {
        mSubject = subject;
    }

    @Override
    public void doSomething(int arg) {
        System.out.println("preProcess");
        mSubject.doSomething(arg);
        System.out.println("postProcess");
    }
}
