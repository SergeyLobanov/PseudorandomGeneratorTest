package kpi.util;

import java.io.*;

public class FileWork {

    public static String readFile(String file) {

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)))) {//, "Cp1251"

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
