package Count;

import java.lang.reflect.Array;
import java.util.*;

public class Count {

    public static void count(HashMap<String, Integer> count, String line) {
        String[] chars = new String[]{
                "b","c","d","e","f","g","h","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"
        };
        List<String> letters = Arrays.asList(chars);
        String[] words = line.split(" ");
        for (String word : words) {
            if (word.trim().length()>0 && !letters.contains(word)){
                word = word.toLowerCase();
                if (count.containsKey(word)) {
                    count.put(word, count.get(word) + 1);
                } else {
                    count.put(word, 1);
                }
            }
        }
    }
}