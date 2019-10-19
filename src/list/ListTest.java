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
        for(int i = 0; i < n; i++) {
            list.insert(i, i);
        }
        System.out.println("List: " + list.toString());
        list.removeDuplicate();
        System.out.println("removeDuplicate: " + list.toString());
        list.remove(n - 1);
        System.out.println("remove List[" + (n - 1) + "]: " + list.toString());
        list.remove(n / 2);
        System.out.println("remove List[" + (n / 2) + "]: " + list.toString());
        list.remove(0);
        System.out.println("remove List[0]: " + list.toString());
        list.reverse();
        System.out.println("reverse List: " + list.toString());
        System.out.println("find " + (n / 2) + " from tail: " + list.getFromTail(n / 2));
        System.out.println("getMiddle: " + list.getMiddle());
        System.out.println("toStringFromTail: " + list.toStringFromTail());
        list.tailPointTo(list.getLength() - 1);
        System.out.println("tailPointTo(" + (list.getLength() - 1) + "), isLoop: " + list.isLoop());
        SimpleList<Integer> list1 = new SimpleList<>();
        for(int i = 0; i < n; i++) {
            list1.insert(i, i);
        }
        SimpleList<Integer> list2 = new SimpleList<>();
        for(int i = 0; i < n; i++) {
            list2.insert(i, i);
        }
        System.out.println("list1(" + list1.getLength() + "): " + list1
                + ", list2(" + list2.getLength() + "): " + list2);
        list1.tailPointTo(list2, list2.getLength() / 2);
        System.out.println("list1.tailPointTo(list2, " + (list2.getLength() / 2) + ")");
        System.out.println("isIntersect: " + list1.isIntersect(list2));
        System.out.println("list1(" + list1.getLength() + "): " + list1
                + ", list2(" + list2.getLength() + "): " + list2);
        System.out.println("list1.intersectAt(list2): " + list1.intersectAt(list2));
        System.out.println("list2.intersectAt(list1): " + list2.intersectAt(list1));
        System.out.println("simpleListTest start");
    }
}
