package proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Type;

public class SubjectHandler implements InvocationHandler {
    private Object mObject;

    public SubjectHandler(Object o) {
        mObject = o;
    }

    @Override
    public Object invoke(Object o, Method method, Object[] objects) throws Throwable {
        System.out.println("---before---");
        Object result = method.invoke(mObject, objects);
        System.out.println("---after---");
        return result;
    }
}
