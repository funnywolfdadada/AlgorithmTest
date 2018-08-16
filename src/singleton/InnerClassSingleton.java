package singleton;

public class InnerClassSingleton {

    static {
        System.out.println("InnerClassSingleton static block");
    }

    {
        System.out.println("InnerClassSingleton block");
    }

    private static Holder sHolder = new Holder();

    private InnerClassSingleton() {}

    public static InnerClassSingleton getInstance() {
        return sHolder.innerClassSingleton;
    }

    public void test() {
        System.out.println("InnerClassSingleton test");
    }

    private static class Holder {

        static {
            System.out.println("Holder static block");
        }

        {
            System.out.println("Holder block");
        }

        private InnerClassSingleton innerClassSingleton = new InnerClassSingleton();
    }

}
