package chapter01.suppereasy;

public class TexQuotes {

    public static String texQuotes(String source) {
        int total = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < source.length(); i++) {
            if (source.charAt(i) == '"') {
                total++;
                if (total % 2 != 0) {
                    stringBuilder.append("``");
                } else {
                    stringBuilder.append("''");
                }
            } else {
                stringBuilder.append(source.charAt(i));
            }

        }
        System.out.println(stringBuilder);
        return stringBuilder.toString();
    }

}
