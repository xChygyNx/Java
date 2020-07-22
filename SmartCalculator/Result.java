import java.util.ArrayList;
import java.util.ArrayDeque;
import java.util.Deque;
import java.math.BigInteger;

import Exceptions.*;


public class Result {
    private static ArrayList<String> mathExp = new ArrayList<>();

    public static ArrayList<String> getMathExp() {
        return mathExp;
    }

    public static void addMathExp(String elem) {
        mathExp.add(elem);
    }

    public static void setMathExp(ArrayList<String> mathExp) {
        Result.mathExp = mathExp;
    }

    public static void countRes (String[] statement) throws Exception{
        //System.out.println(mathExp);
        mathExp.clear();
        Ops.getOps().clear();
        //System.out.println(mathExp);
        for (int i = 0; i < statement.length; i++) {
            String elem = statement[i].trim();
            //System.out.println("elem = " + elem);
            if (elem.matches("[-\\*/\\+\\^()]")) {
                try {
                    Ops.add(elem);
                } catch (Exception e) {
                    //System.out.println("Error");
                    System.out.println(e.getMessage());
                    return;
                }
            } else {
                addElem(elem);
                //System.out.println(mathExp);
            }
        }
        //System.out.println(mathExp);
            completeExpression();
        //System.out.println(mathExp);
        BigInteger res = BigInteger.ZERO;
            res = solution();
        //System.out.println(mathExp);
        //System.out.println(mathExp);
        System.out.println(res);
    }

    private static void addElem(String elem) throws Exception {
        int i = 0;
        for (; elem.charAt(i) == '('; i++) {
            Ops.add("(");
            //System.out.println("addElem ops = " + Ops.getOps());
        }
        //System.out.println(mathExp);
        elem = elem.substring(i);
        //System.out.println("elem = " + elem);
        for (i = 0; elem.charAt(elem.length() - i - 1) == ')'; i++) {}
        addMathExp(elem.substring(0, elem.length() - i));
        //System.out.println("I'm here");
        if (i > 0) {
            for (int j = 0; j < i; j++) {
                Ops.closeParentheses();
            }
        }
    }

    private static BigInteger solution() throws Exception {
        Deque<BigInteger> nums = new ArrayDeque<>();
        for (String elem : mathExp) {
            //System.out.println("solution elem = |" + elem + "|");
            if (elem.matches("\\d+")) {
                nums.addFirst(new BigInteger(elem));
            } else if (elem.matches("[a-zA-Z]+")) {
                BigInteger vars = Vars.getVars().get(elem);
                if (vars == null) {
                    throw new unknownVarsException();
                }
                nums.addFirst(vars);
            } else if (elem.matches("[-\\+\\*/\\^]")) {
                try {
                    executeOp(elem, nums);
                } catch (Exception e) {
                    throw e;
                }
            } else {
                throw new invalidExpression();
            }
            //System.out.println(nums.toString());
        }
        //System.out.println(nums.size());
        //System.out.println(nums.toString());
        if (nums.size() != 1) {
            throw new invalidExpression();
        }
        return nums.poll();
    }

    private static void executeOp(String op, Deque<BigInteger> nums) throws Exception {
        BigInteger num1;
        BigInteger num2;
        try {
            num2 = nums.poll();
            num1 = nums.poll();
        } catch (Exception e) {
            throw new invalidExpression();
        }
        switch (op) {
            case "+":
                nums.addFirst(num1.add(num2));
                break;
            case "-":
                nums.addFirst(num1.subtract(num2));
                break;
            case "*":
                nums.addFirst(num1.multiply(num2));
                break;
            case "/":
                if (num2.equals(BigInteger.ZERO)) {
                    throw new invalidExpression();
                }
                nums.addFirst(num1.divide(num2));
                break;
            /*case "^":
                nums.addFirst(pow(num1, num2));
                break;*/
        }
    }

    private static int pow(int num1, int num2) {
        int res = 1;
        for (int i = 0; i < num2; i++) {
            res *= num1;
        }
        return res;
    }

    private static void completeExpression() throws invalidExpression {
        for (; !Ops.getOps().isEmpty();) {
            String op = Ops.getOps().pollFirst();
            if (op.equals("(")) {
                throw new invalidExpression();
            }
            Result.addMathExp(op);
        }
    }
}
