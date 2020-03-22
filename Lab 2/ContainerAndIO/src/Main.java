import FileCodingDetect.FileCodingDetect;
import MapSort.MapSort;
import ReadFileUseInputStream.ReadFileUseInputStream;
import ReadFileUseReader.ReadFileUseReader;
import ReadFileUseScanner.ReadFileUseScanner;
import WriteFileUseOutputStream.WriteFileUseOutputStream;
import WriteFileUsePrintWriter.WriteFileUsePrintWriter;
import WriteFileUseWriter.WriteFileUseWriter;
import org.w3c.dom.ls.LSOutput;

import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        File file = new File("了不起的盖茨比英文.txt");
        file.setReadable(true);
        File output = new File("output.txt");
        output.setWritable(true);
        HashMap<String,Integer> count = new HashMap<>();
        if (FileCodingDetect.detect(file) == "UTF-8"){

            ReadFileUseInputStream.statistics(count,file);

            List<Map.Entry<String, Integer>> list = MapSort.sortByValueIntegerDesc(count);

            output.delete();
            output.createNewFile();

            WriteFileUseOutputStream.output(list,output);

        }else{

//              ReadFileUseInputStream.statistics(count,file);
//              ReadFileUseReader.statistics(count,file);
            ReadFileUseScanner.statistics(count,file);

            List<Map.Entry<String, Integer>> list = MapSort.sortByValueIntegerDesc(count);

            output.delete();
            output.createNewFile();

//              WriteFileUseOutputStream.output(list,output);
//              WriteFileUsePrintWriter.output(list,output);
            WriteFileUseWriter.output(list,output);
        }

        System.out.println("统计成功");

    }

}
