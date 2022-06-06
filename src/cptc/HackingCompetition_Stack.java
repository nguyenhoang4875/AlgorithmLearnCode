package cptc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

class HackingCompetition_Stack {
    String source;
    String commands;
    int cursorPosition = 0;
    //    char[] result;
    Stack<Character> first = new Stack<>();
    Stack<Character> second = new Stack<>();

    private void input() throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream("src/input_samples.txt")));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        source = br.readLine();
        cursorPosition = source.length();
        commands = br.readLine();

        for (int i = 0; i < source.length(); i++) {
         first.push(source.charAt(i));
        }
    }

    private void solve() {
        char tmp;
        for (int i = 0; i < commands.length(); i++) {
            tmp = commands.charAt(i);
            switch (tmp) {
                case 'L':
                    if (first.isEmpty()) break;
                     tmp = first.pop();
                     second.push(tmp);
                    break;
                case 'R':
                    if (second.isEmpty()) break;
                    tmp = second.pop();
                    first.push(tmp);
                    break;
                case 'B':
                    if (first.isEmpty()) break;
                    first.pop();
                    break;
                default:
                    first.push(tmp);
                    break;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        HackingCompetition_Stack m = new HackingCompetition_Stack();
        m.input();
        m.solve();
        StringBuilder result = new StringBuilder();
        while (!m.first.isEmpty()) {
            result.append(m.first.pop());
        }
        result.reverse();
        while (!m.second.isEmpty()) {
            result.append(m.second.pop());
        }
        System.out.println(result);

    }
}