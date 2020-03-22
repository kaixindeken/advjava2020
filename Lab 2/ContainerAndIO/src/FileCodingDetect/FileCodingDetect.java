package FileCodingDetect;

import java.io.*;

public class FileCodingDetect {

    public static String detect(File file) throws IOException {
        InputStream inputStream = new FileInputStream(file);
        byte[] b = new byte[3];
        inputStream.read(b);
        inputStream.close();
        if (b[0] == -17 && b[1] == -69 && b[2] == -65)
            return "UTF-8";
        else
            return "others";
    }

}
