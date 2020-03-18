import java.io.*;

public class FileCopy {

    public static void CopyFileByStream(File source, File dest) throws IOException {
        InputStream inputStream = new FileInputStream(source);
        if (!dest.exists()) {
            dest.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(dest);
        byte[] buffer = new byte[1024];
        while (inputStream.read(buffer) > 0) {
            outputStream.write(buffer, 0, buffer.length);
        }
        inputStream.close();
        outputStream.close();

    }

    public static void main(String[] args) throws IOException {
        File source = new File("SourceFolder" + File.separator + "chest.txt");
        File dest = new File("DestinationFolder" + File.separator + "chestCopy.txt");
        System.out.println("starting copy from " + source.getPath() + " to " + dest.getPath());
        CopyFileByStream(source, dest);
        System.out.println("copy succeed from " + source.getPath() + " to " + dest.getPath());
    }
}