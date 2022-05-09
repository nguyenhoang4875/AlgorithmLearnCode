package chapter01.suppereasy;

import java.util.Scanner;

public class LanguageDetection {
    public static void languageDetection() {
        Scanner scanner = new Scanner(System.in);
        StringBuilder result = new StringBuilder();
        String line;
        int i = 0;
        while ((line = scanner.nextLine()).compareTo("#") != 0) {
            i++;
            result.append("Case " + i + ": ");
            if (line.equals("HELLO"))
                result.append("ENGLISH\n");
            else if (line.equals("HOLA"))
                result.append("SPANISH\n");
            else if (line.equals("HALLO"))
                result.append("GERMAN\n");
            else if (line.equals("BONJOUR"))
                result.append("FRENCH\n");
            else if (line.equals("CIAO"))
                result.append("ITALIAN\n");
            else if (line.equals("ZDRAVSTVUJTE"))
                result.append("RUSSIAN\n");
            else
                result.append("UNKNOWN\n");

        }
        result.replace(result.length() - 1, result.length(), "");
        System.out.println(result);
    }
}
