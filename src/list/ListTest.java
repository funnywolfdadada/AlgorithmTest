package list;

public class ListTest {
    public static void simpleListTest(int n) {
        if(n <= 0) {
            return;
        }
        System.out.println("simpleListTest start");
        SimpleList<Integer> list = new SimpleList<>();
        for(int i = 0; i < n; i++) {
            list.insert(i, i);
        }
        System.out.println("List: " + list.toString());
        list.remove(n - 1);
        System.out.println("remove List[" + (n - 1) + "]: " + list.toString());
        list.remove(n / 2);
        System.out.println("remove List[" + (n / 2) + "]: " + list.toString());
        list.remove(0);
        System.out.println("remove List[0]: " + list.toString());
        list.reverse();
        System.out.println("reverse List: " + list.toString());
        System.out.println("get " + (n / 2) + " from tail: " + list.getFromTail(n / 2));
        System.out.println("getMiddle: " + list.getMiddle());
        System.out.println("simpleListTest start");
    }
}
