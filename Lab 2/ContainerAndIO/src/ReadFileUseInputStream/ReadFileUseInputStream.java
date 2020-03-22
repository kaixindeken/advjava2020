package ReadFileUseInputStream;

import java.util.*;
import java.io.*;
import Count.Count;

public class ReadFileUseInputStream {

    public static void statistics(HashMap<String, Integer> count, File file) throws IOException {
        FileInputStream fis = new FileInputStream(file);
        InputStreamReader isr = new InputStreamReader(fis);
        BufferedReader br = new BufferedReader(isr);

        String line;
        while ((line = br.readLine()) != null) {
            Count.count(count, line);
        }

        fis.close();
        isr.close();
        br.close();
    }

}