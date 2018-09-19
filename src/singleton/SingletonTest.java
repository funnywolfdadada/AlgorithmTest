package singleton;

public class SingletonTest {
    public static void innerClassSingleTest() {
        System.out.println("SingletonTest start");
        System.out.println("load InnerClassSingleton start");
        try {
            Class.forName("singleton.InnerClassSingleton");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println("load InnerClassSingleton end");
        InnerClassSingleton.getInstance().test();
        System.out.println("SingletonTest end");
    }
}
