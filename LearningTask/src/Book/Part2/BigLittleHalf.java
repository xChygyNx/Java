package Book.Part2;
//import java.util.LinkedList;
//import java.util.LinkedListNode;

public class BigLittleHalf {
    public static void main(String[] args) {
        LinkedListNode list = new LinkedListNode();
        list.add(-3);
        list.add(9);
        list.add(1);
        list.add(7);
        list.add(4);
        list.add(5);
        list.add(10);
        list.add(9);
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(2);
        System.out.println(list);
        list = bigLittleHalf(list.head, 5);
        System.out.println(list);
    }

    public static LinkedListNode bigLittleHalf(LinkedListNode list,int point) {
        LinkedListNode before = new LinkedListNode();
        LinkedListNode after = new LinkedListNode();
        for (; list != null; list = list.next) {
            System.out.println("---------------------------------------");
            if (list.data < point) {
                before.add(list.data);
            } else {
                after.add(list.data);
            }
            System.out.println(before);
            System.out.println(after);
            System.out.println("---------------------------------------");
        }
        before.last.next = after.head;
        list = before.head;
        return list;
    }
}


