package proxy;

public class ProxyTest {
    public static void test() {
        RealSubject realSubject = new RealSubject();
        SubjectHandler handler = new SubjectHandler(realSubject);
        Subject subject = (Subject) java.lang.reflect.Proxy.newProxyInstance(
                realSubject.getClass().getClassLoader(),
                realSubject.getClass().getInterfaces(),
                handler);
        subject.doSomething(11);
    }
}
