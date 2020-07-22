package Book.Part1;

import java.util.Scanner;

public class CheckStrChange {
    public static void main(String[] args) {
        int i;
        boolean diff = false;
        Scanner scan = new Scanner(System.in);
        String str1 = scan.nextLine().toUpperCase();
        String str2 = scan.nextLine().toUpperCase();
        int len1 = str1.length();
        int len2 = str2.length();
        if (Math.abs(len1 - len2) > 1) {
            System.out.println(false);
            return;
        } else if (str1.equals(str2)) {
            System.out.println(true);
            return;
        } else {
            int len = Math.min(len1, len2);
            for (i = 0; i < len; i++) {
                if (str1.charAt(i) != str2.charAt(i)) {
                    diff = true;
                    break;
                }
            }
            if ((!diff && Math.abs(len1-len2) == 1) ||
                    (str1.substring(i).equals(str2.substring(i+1)) ||
                    str1.substring(i+1).equals(str2.substring(i)) ||
                    str1.substring(i+1).equals(str2.substring(i+1)))) {
                System.out.println(true);
                return;
            }
            System.out.println(false);
        }
    }

}
