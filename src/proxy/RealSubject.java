package proxy;

public class RealSubject implements Subject {
    @Override
    public void doSomething(int arg) {
        System.out.println("RealSubject doSomething " + arg);
    }
}
