package Book.Part2;
import java.util.HashSet;
import java.util.LinkedList;

public class CrossLinkedList {
    public static void main(String[] args) {
        LinkedListNode list1 = new LinkedListNode();
        LinkedListNode list2 = new LinkedListNode();
        LinkedList<Integer> listStd = new LinkedList<>();
        LinkedList<Integer> listTmp = new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(4);
        list1.add(5);
        list1.add(6);
        list1.add(7);
        listTmp.add(1488);
        listTmp.add(69);
        listTmp.add(666);
        listStd.add(1);
        listStd.add(2);
        listStd.add(3);
        listStd.add(4);
        listStd.add(5);
        listStd.add(6);
        listStd.add(7);
        listStd.addAll(3,listTmp);
        list2.add(10);
        list2.add(20);
        list2.add(30);
        list2.add(40);
        //list2.add(list1.get(1));
        //list2.add(list1.get(2));
        System.out.println(list1);
        System.out.println(list2);
        System.out.println(listStd);
        listStd.clear();
        System.out.println(listStd.isEmpty());
        listStd.add(5);
        System.out.println(listStd.isEmpty());
        System.out.println(checkCross(list1, list2));
    }

    public static boolean checkCross(LinkedListNode list1, LinkedListNode list2) {
        HashSet<LinkedListNode> set = new HashSet<>(list1.size());
        for (LinkedListNode tmp = list1.head; tmp != null; tmp = tmp.next) {
            if (set.contains(tmp)) {
                break;
            }
            set.add(tmp);
        }
        for (LinkedListNode tmp = list2.head; tmp != null; tmp = tmp.next) {
            if (set.contains(tmp)) {
                return true;
            }
        }
        return false;
    }
}
