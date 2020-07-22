package Book.Part1;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class Sub {
    public static void main(String[] args) {
        ArrayList<Integer> src = new ArrayList<>();
        for (int i = 10; i > 0; i--) {
            src.add(i);
        }
        //ArrayList<Integer> sub = new ArrayList<>(src.subList(2, 7));
        System.out.println(src);
        src = mySort(src);
        System.out.println(src);

    }

    private static ArrayList<Integer> mySort(ArrayList<Integer> arr) {
        if (arr.size() == 1) {
            return arr;
        }
        ArrayList<Integer> part1 = new ArrayList<>(arr.subList(0, arr.size()/2));
        ArrayList<Integer> part2 = new ArrayList<>(arr.subList(arr.size()/2, arr.size()));

        part1 = mySort(part1);
        part2 = mySort(part2);
        arr = mergeParts(part1, part2);

        return arr;
    }

    private static ArrayList<Integer> mergeParts (ArrayList<Integer> part1, ArrayList<Integer> part2) {
        int size1 = part1.size();
        int size2 = part2.size();
        ArrayList<Integer> res = new ArrayList<>(size1 + size2);
        int i = 0;
        int j = 0;
        //System.out.printf("%d %d", i, j);
        while (i < size1 || j < size2)  {
            if(i == size1) {
                res.add(part2.get(j));
                j++;
            } else if (j == size2) {
                res.add(part1.get(i));
                i++;
            } else {
                if (part1.get(i) < part2.get(j)) {
                    res.add(part1.get(i));
                    i++;
                } else {
                    res.add(part2.get(j));
                    j++;
                }
            }
        }
        return res;
    }
}
