package Book.Part2;

import java.util.LinkedList;
import java.util.ListIterator;

public class ListPalindrome {
    public static void main(String[] args) {
        LinkedList<Integer> num = new LinkedList<>();
        num.add(6);
        num.add(1);
        num.add(7);
        num.add(5);
        num.add(7);
        num.add(1);
        num.add(6);
        System.out.println(isPalindrome(num));
    }

    public static boolean isPalindrome(LinkedList<Integer> list) {
        ListIterator iterBegin = list.listIterator();
        ListIterator iterEnd = list.listIterator(list.size());
        while(iterBegin.nextIndex() < iterEnd.previousIndex()) {
            if (iterBegin.next() != iterEnd.previous()) {
                return false;
            }
        }
        return true;
    }
}
