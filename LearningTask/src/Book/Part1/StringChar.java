package Book.Part1;

public class StringChar {
    public static void main(String[] args) {
        String str = "Hello";
        str = str.toUpperCase();
        char[] strCh = str.toCharArray();
        System.out.println(str);
        for (char ch : strCh) {
            System.out.println(ch);
        }
    }
}
