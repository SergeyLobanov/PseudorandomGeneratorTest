package kpi.util;

import java.io.*;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.List;

public class FileWork {

    public static String readFile(String file) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {

            StringBuilder sb = new StringBuilder();
            String line = br.readLine();

            while (line != null) {
                sb.append(line);
                sb.append("\n");
                line = br.readLine();
            }
            return sb.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static List<Integer> readBytesFromFile(String file) {

        try (InputStream inputStream = new FileInputStream(file)){
            List<Integer> byteList = new ArrayList<>();
            int oneByte = inputStream.read();

            while (oneByte != -1) {
                byteList.add(oneByte);
                oneByte = inputStream.read();
            }
            return byteList;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    public void writeFile(String fileName, String text) {
        File file = new File(fileName);
        try {
            if(!file.exists()){
                file.createNewFile();
            }

            try (PrintWriter out = new PrintWriter(file.getAbsoluteFile())) {
                out.print(text);
            }
        } catch(IOException e) {
            throw new RuntimeException(e);
        }
    }
}
