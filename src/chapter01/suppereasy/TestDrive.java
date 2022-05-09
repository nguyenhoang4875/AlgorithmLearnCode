package chapter01.suppereasy;

import utils.Utils;

public class TestDrive {
    public static void main(String[] args) {
        String source = Utils.readFileStream("src/input_sample.txt");
        String result = TexQuotes.texQuotes(source);
        Utils.writeFileStream(result, "src/output_sample.txt");
    }
}
