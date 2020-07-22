package Book.Map;
import java.util.HashMap;

public class EntrySet {
    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("Yura", 182);
        map.put("Sanya", 179);
        map.put("Alex", 172);
        int height = map.get("Sanya");
        System.out.println(height);
        for (HashMap.Entry<String, Integer> set: map.entrySet()) {
            System.out.println(set.getKey() + "    " + set.getValue());
        }

    }
}
