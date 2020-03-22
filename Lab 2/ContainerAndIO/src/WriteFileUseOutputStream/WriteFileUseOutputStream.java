package WriteFileUseOutputStream;

import java.io.*;
import java.util.*;

public class WriteFileUseOutputStream {

    public static void output(List<Map.Entry<String, Integer>> list, File file) throws IOException{
        FileOutputStream fos = new FileOutputStream(file);
        for (Map.Entry<String, Integer> e: list) {
            String string = e.getKey()+" "+e.getValue()+"\n";
            byte[] strToByte = string.getBytes();
            fos.write(strToByte);
        }
        fos.close();
    }

}
