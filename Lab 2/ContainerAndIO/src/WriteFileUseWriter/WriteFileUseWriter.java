package WriteFileUseWriter;

import java.io.*;
import java.util.*;

public class WriteFileUseWriter {

    public static void output(List<Map.Entry<String, Integer>> list, File file) throws IOException {
        FileWriter fw = new FileWriter(file);
        BufferedWriter bw = new BufferedWriter(fw);

        for (Map.Entry<String,Integer> e : list){
            bw.append(e.getKey()+" "+e.getValue()+"\n");
        }

        bw.close();

    }

}
