package singleton;

public class InnerClassSingleton {

    static {
        System.out.println("InnerClassSingleton static block");
    }

    {
        System.out.println("InnerClassSingleton block");
    }

    private InnerClassSingleton() {}

    public static InnerClassSingleton getInstance() {
        return Holder.sInnerClassSingleton;
    }

    public void test() {
        System.out.println("InnerClassSingleton test");
    }

    private static class Holder {

        static {
            System.out.println("Holder static block");
        }

        private static InnerClassSingleton sInnerClassSingleton = new InnerClassSingleton();
    }

}
