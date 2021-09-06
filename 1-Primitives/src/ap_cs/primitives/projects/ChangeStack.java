package ap_cs.primitives.projects;

import java.util.HashMap;
import java.util.Map;

public class ChangeStack {
    private Map<String, Integer> counts;

    public ChangeStack() {
        counts = new HashMap<>();
    }

    public void putCount(String billType, int count) {
        counts.put(billType, count);
    }

    public int getCount(String billType) {
        return counts.get(billType);
    }

    public boolean hasCount(String billType) {
        return counts.containsKey(billType);
    }
}
