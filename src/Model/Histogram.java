package Model;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Histogram<T> {
    private final Map<T,Integer> map = new HashMap<T,Integer>();
    
    public Integer get(T key) {
        return map.get(key);
    }
    
    public Set<T> KeySet() {
        return map.keySet();
    }
    
    public void increment(T key) {
        map.put(key, (map.containsKey(key)) ? map.get(key) + 1:1);
    }
}
