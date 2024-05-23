import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;

public class Coding {

    public static void main(String[] args) {
        List<String> objects = Collections.synchronizedList(new ArrayList<>());
        objects.add("abc");
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        Set<Object> objects1 = Collections.synchronizedSet(new HashSet<>());
        ConcurrentSkipListSet<String> cs = new ConcurrentSkipListSet<>();
    }
}
