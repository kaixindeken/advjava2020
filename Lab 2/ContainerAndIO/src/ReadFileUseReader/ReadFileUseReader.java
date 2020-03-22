package ReadFileUseReader;

import java.util.*;
import java.io.*;
import Count.Count;

public class ReadFileUseReader {

    public static void statistics(HashMap<String, Integer> count, File file) throws FileNotFoundException, IOException {
        FileReader fr = new FileReader(file);
        BufferedReader br = new BufferedReader(fr);

        String line;
        while ((line = br.readLine()) != null) {
            Count.count(count, line);
        }

        fr.close();
        br.close();
    }

}