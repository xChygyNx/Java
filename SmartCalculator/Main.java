import Exceptions.*;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        for (String str = scanner.nextLine();; str = scanner.nextLine()) {
            str = str.trim();
            if (str.equals("")) {
                continue;
            }
            if (str.charAt(0) == '/') {
                try {
                    executeCommand(str);
                    continue;
                } catch (exitException ee) {
                    System.out.println(ee.getMessage());
                    break;
                }
            }
            Pattern equal = Pattern.compile("=");
            if (equal.matcher(str).find()) {
                try {
                    Vars.setVar(str);
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
                continue;
            }
            str = replaceMultiOps(str);
            String[] statement = str.split("\\s+");
            //printArray(statement);
            try {
                Result.countRes(statement);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        }
    }

    public static String replaceMultiOps(String str) {
        Pattern pMM = Pattern.compile("-{2}");
        Pattern pPP = Pattern.compile("\\+{2,}");
        Pattern pPM = Pattern.compile("\\+-");
        Pattern pMP = Pattern.compile("-\\+");
        while (true) {
            Matcher mMM = pMM.matcher(str);
            str = mMM.replaceAll("+");
            Matcher mPP = pPP.matcher(str);
            str = mPP.replaceAll("+");
            Matcher mPM = pPM.matcher(str);
            str = mPM.replaceAll("-");
            Matcher mMP = pMP.matcher(str);
            str = mMP.replaceAll("-");
            if (!pMM.matcher(str).find() &&
                    !pPP.matcher(str).find() &&
                    !pPM.matcher(str).find() &&
                    !pMP.matcher(str).find()) {
                break;
            }
        }
        return str;
    }



    public static void executeCommand(String str) throws exitException {
        if (str.equals("/exit")) {
            throw new exitException();
        }
        else if (str.equals("/help")) {
            printHelp();
        } else {
            System.out.println("Unknown command");
        }
    }

    public static void printHelp() {
        System.out.println("The program calculates the sum of numbers and work with variables");
        System.out.println();
        System.out.println("Calculator work this following operations:");
        System.out.println("\'+\' - plus");
        System.out.println("\'-\' - minus");
        System.out.println("\'*\' - multiplication");
        System.out.println("\'/\' - division");
        System.out.println("\'^\' - pow");
        System.out.println("Calculator can processed repeat \'+\' & \'-\'. Repeating others signs of operation considered an error");
        System.out.println("Can memorize and use variables");
    }

    private static void printArray (String[] arr) {
        int i = 0;
        System.out.print("[");
        for (; i < arr.length - 1; i++) {
            System.out.print(arr[i] + ", ");
        }
        if (arr.length > 0) {
            System.out.print(arr[i]);
        }
        System.out.println("]");
    }
}
