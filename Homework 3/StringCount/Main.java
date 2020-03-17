import java.io.IOException;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String s : args) {
            if (map.containsKey(s)) {
                Integer sval = map.get(s);
                map.put(s, sval + 1);
            } else {
                map.put(s, 1);
            }
        }
        System.out.println(map);
    }
}