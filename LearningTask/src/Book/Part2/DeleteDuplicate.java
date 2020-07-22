package Book.Part2;
import java.util.LinkedList;
import java.util.ListIterator;

public class DeleteDuplicate {
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(4);
        list.add(0);
        list.add(7);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(9);
        list.add(7);
        list.add(3);
        list.add(8);
        list.add(2);
        System.out.println(list);
        list = deleteDuplicate(list);
        System.out.println(list);
    }

    private static LinkedList<Integer> deleteDuplicate(LinkedList<Integer> list) {
        for (ListIterator<Integer> iter = list.listIterator(); iter.hasNext();) {
            if (list == null) {
                return list;
            }
            int elem = iter.next();
            for (ListIterator<Integer> iter2 = list.listIterator(iter.nextIndex()); iter2.hasNext();) {
                if (iter2.next() == elem) {
                    iter2.remove();
                    iter = list.listIterator(iter.nextIndex());
                }
            }
        }
        return list;
    }
}
