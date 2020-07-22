import java.math.BigInteger;
import java.util.HashMap;
import Exceptions.*;

public class Vars {
    private static HashMap<String, BigInteger> vars = new HashMap<>();

    public static HashMap<String, BigInteger> setVar (String str) throws Exception{
        String[] strArray = str.split("=");
        String var;
        if (strArray.length > 2) {
            throw new invalidExpression();
        }
        if (!strArray[0].trim().matches("[a-zA-Z]+")){
            throw new invalidAssignmentException();
        } else {var = strArray[0].trim();}
        if (!strArray[1].trim().matches("[a-zA-Z]+") &&
                !strArray[1].trim().matches("[\\+-]?\\d+")) {
            throw new invalidAssignmentException();
        }
        if(strArray[1].trim().matches("[a-zA-Z]+") &&
                !vars.containsKey(strArray[1].trim())) {
            throw new unknownVarsException();
        }
        if (strArray[1].trim().matches("[\\+-]?\\d+")) {
            vars.put(var, new BigInteger(strArray[1].trim()));
        } else {
            vars.put(var, vars.get(strArray[1].trim()));
        }
        return vars;
    }

    public static HashMap<String, BigInteger> getVars() {
        return vars;
    }
}
