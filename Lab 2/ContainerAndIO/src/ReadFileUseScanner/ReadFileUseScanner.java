package ReadFileUseScanner;

import java.io.*;
import java.util.*;
import Count.Count;

public class ReadFileUseScanner {

    public static void statistics(HashMap<String, Integer> count, File file) throws FileNotFoundException {
        Scanner sc = new Scanner(file);
        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            Count.count(count, line);
        }
    }
}