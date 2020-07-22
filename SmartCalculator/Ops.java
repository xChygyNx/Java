import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import Exceptions.*;

public class Ops {
    private static Deque<String> opsTemp = new ArrayDeque<>();
    private final static Map<String, Integer>  priority = Map.of(
            "+", 1,
            "-", 1,
            "*", 2,
            "/", 2,
            "^", 3,
            "(", 4
    );

    public static Deque<String> getOps() {
        return opsTemp;
    }

    public static void add (String ops) throws Exception {
        ops = ops.trim();
        //System.out.println("ops = " + ops);
        //System.out.println("opstemp = " + opsTemp.toString());
        if (opsTemp.isEmpty()) {
            opsTemp.addFirst(ops);
        } else if (ops.equals(")")) {
            try {
                closeParentheses();
            } catch (invalidExpression ie) {
                throw ie;
            }
        } else if (priority.get(ops) > priority.get(opsTemp.peek())) {
            opsTemp.addFirst(ops);
        } else {
            if (!opsTemp.peek().equals("(")) {
                Result.addMathExp(opsTemp.remove());
            }
            opsTemp.addFirst(ops);
        }
    }

    static void closeParentheses() throws invalidExpression {
        //System.out.println("opsTemp = " + opsTemp);
        if (opsTemp.isEmpty()) {
            throw new invalidExpression();
        }
        for (String op = opsTemp.pop(); !op.equals("("); op = opsTemp.pop()) {
            Result.addMathExp(op);
            if (opsTemp.isEmpty()) {
                throw new invalidExpression();
            }
        }
    }
}
