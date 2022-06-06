package cptc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

class HackingCompetition_LL {
    String source;
    String commands;
    int cursorPosition = 0;
    //    char[] result;
    LinkedList<Character> linkedList = new LinkedList<>();

    private void input() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input_samples.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        source = br.readLine();
        cursorPosition = source.length();
        commands = br.readLine();

        for (int i = 0; i < source.length(); i++) {
            linkedList.add(source.charAt(i));
        }
    }

    private void solve() {
        char tmp;
        for (int i = 0; i < commands.length(); i++) {
            tmp = commands.charAt(i);
            switch (tmp) {
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
                    handleCaseAddLowerCase(tmp);
                    break;
            }
        }
    }

    private void handleCaseBackSpace() {
        if (cursorPosition > 0) {
            cursorPosition--;
            linkedList.remove(cursorPosition);
        }
    }

    private void handleCaseAddLowerCase(char c) {
        linkedList.add(cursorPosition, c);
        cursorPosition++;
    }

    public static void main(String[] args) throws IOException {
        HackingCompetition_LL m = new HackingCompetition_LL();
        m.input();
        m.solve();
//        StringBuilder stringBuilder = new StringBuilder();
        for (Character c : m.linkedList ) {
            System.out.print(c);
        }
        System.out.println();
    }
}