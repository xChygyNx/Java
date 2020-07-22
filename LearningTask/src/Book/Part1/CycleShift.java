package Book.Part1;

public class CycleShift {
    public static void main(String[] args) {
        String word1 = "waterbottle";
        String word2 = "ewaterbottl";
        System.out.println(isShift(word1, word2));
    }

    private static boolean isShift(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        if (len1 != len2) {
            return false;
        }
        for (int i = 0; i < len1; i++) {
            System.out.println(word1.substring(0, i) + "   |" + word2.substring(len1 - i));
            System.out.println(word1.substring(i) + "   |" + word2.substring(0, len1 - i));
            if (word1.substring(0, i).equals(word2.substring(len1 - i)) &&
                    word1.substring(i).equals(word2.substring(0, len1 - i))) {
                return true;
            }
            System.out.println("#############################");
        }
        return false;
    }

}
