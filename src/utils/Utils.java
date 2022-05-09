package utils;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class Utils {

    public static String readFile(String path) {
        FileReader fileReader;
        BufferedReader bufferedReader;
        StringBuilder stringBuilder = new StringBuilder();
        try {
            fileReader = new FileReader(path);
            bufferedReader = new BufferedReader(fileReader);
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line);
                stringBuilder.append(System.lineSeparator());
            }
            fileReader.close();
            bufferedReader.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static String readFileStream(String path) {

        StringBuilder stringBuilder = new StringBuilder();
        try {
            InputStream inputStream = new FileInputStream(path);
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            int i;
            while ((i = bufferedInputStream.read()) != -1) {
                stringBuilder.append((char) i);
            }
            bufferedInputStream.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }

    public static void writeFile(String source, String path) {
        FileWriter fileWriter;
        BufferedWriter bufferedWriter;
        try {
            fileWriter = new FileWriter(path);
            bufferedWriter = new BufferedWriter(fileWriter);
            System.out.println("source : " + source);
            bufferedWriter.write(source);
            bufferedWriter.flush();
            fileWriter.close();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void writeFileStream(String source, String path) {
        try {
            OutputStream outputStream = new FileOutputStream(path);
            BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(outputStream);
            bufferedOutputStream.write(source.getBytes(StandardCharsets.UTF_8));
            bufferedOutputStream.flush();
            outputStream.close();
            bufferedOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
