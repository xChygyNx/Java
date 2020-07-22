package Book.Part2;
import java.util.LinkedList;
import java.util.ListIterator;

public class PlusOperation {
    public static void main(String[] args) {
        LinkedList<Integer> num1 = new LinkedList<>();
        LinkedList<Integer> num2 = new LinkedList<>();
        num1.add(6);
        num1.add(1);
        num1.add(7);
        num2.add(8);
        num2.add(6);
        num2.add(6);
        LinkedList<Integer> res = plus(num1, num2);
        System.out.println(res.toString());
    }

    public static LinkedList<Integer> plus(LinkedList<Integer> num1, LinkedList<Integer> num2) {
        int remainder = 0;
        LinkedList<Integer> res = new LinkedList<>();
        ListIterator<Integer> iter1 = num1.listIterator(num1.size());
        ListIterator<Integer> iter2 = num2.listIterator(num2.size());
        while (iter1.hasPrevious() && iter2.hasPrevious()) {
            int digit1 = iter1.previous();
            int digit2 = iter2.previous();
            res.addFirst((digit1 + digit2 + remainder) % 10);
            remainder = (digit1 + digit2 + remainder) / 10;
        }
        ListIterator<Integer> iter = iter1.hasPrevious() ? iter1 : iter2;
        while (iter.hasPrevious()) {
            int digit = iter.previous();
            res.addFirst((digit + remainder) % 10);
            remainder = (digit + remainder) / 10;
        }
        if (remainder > 0) {
            res.addFirst(remainder);
        }
        return res;
    }
}
