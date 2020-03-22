package WriteFileUsePrintWriter;

import java.io.*;
import java.util.*;

public class WriteFileUsePrintWriter {

    public static void output(List<Map.Entry<String, Integer>> list, File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        PrintWriter pw = new PrintWriter(fw);

        for (Map.Entry<String,Integer> e : list){
            pw.println(e.getKey()+" "+e.getValue());
        }

        pw.close();

    }

}
