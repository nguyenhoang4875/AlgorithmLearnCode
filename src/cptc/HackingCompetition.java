package cptc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HackingCompetition {
    String source;
    String commands;
    int cursorPosition = 0;
    char[] result;

    private void input() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input_samples.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        source = br.readLine();
        cursorPosition = source.length();
        commands = br.readLine();
        result = new char[source.length() + commands.length()];
        for (int i = 0; i < source.length(); i++) {
            result[i] = source.charAt(i);
        }
    }

    private void solve() {
        for (int i = 0; i < commands.length(); i++) {
            switch (commands.charAt(i)) {
                case 'L':
                    cursorPosition--;
                    break;
                case 'R':
                    cursorPosition++;
                    break;
                case 'B':
                    handleCaseBackSpace();
                    break;
                default:
                    handleCaseAddLowerCase(commands.charAt(i));
                    break;
            }
        }
    }

    private void handleCaseBackSpace() {
        if (cursorPosition > 0) {
            int index = cursorPosition;
            for (int i = index - 1; i < result.length - 1; i++) {
                result[i] = result[i + 1];
            }
            cursorPosition--;
        }
    }

    private void handleCaseAddLowerCase(char c) {
        int index = cursorPosition;
        for (int i = result.length - 1; i > index; i--) {
            result[i] = result[i - 1];
        }
        result[index] = c;
        cursorPosition++;
    }

    public static void main(String[] args) throws IOException {
        HackingCompetition m = new HackingCompetition();
        m.input();
        m.solve();
        String answer = new String(m.result);
        System.out.println(answer.trim());

    }
}
