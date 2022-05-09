package cptc;
//	"BigInteger" is imported and solved, 0 point is processed

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Calculator {

    int N;//the number of test cases
    int B;//number system
    char S[];//first integer
    char D[];//second integer

    StringBuilder result = new StringBuilder();
    boolean signFist;
    boolean signSecond;
    String firstNum;
    String secondNum;
    int resultUnSignInDec;
    Scanner sc;

    void InputData() {
        B = sc.nextInt();
        S = sc.next().toCharArray();
        D = sc.next().toCharArray();
    }

    public static void main(String[] args) throws FileNotFoundException {
        Calculator m = new Calculator();
//        m.sc = new Scanner(System.in);
        m.sc = new Scanner(new FileInputStream("src/input_samples.txt"));

        m.N = m.sc.nextInt();
        for (int i = 0; i < m.N; i++) {
            m.InputData();                //	input function
            m.firstNum = String.valueOf(m.S);
            m.secondNum = String.valueOf(m.D);
            m.result.setLength(0);

            if (m.S[0] == '-') {
                m.signFist = true;
                m.firstNum = m.firstNum.replace("-", "");
            }
            if (m.D[0] == '-') {
                m.signSecond = true;
                m.secondNum = m.secondNum.replace("-", "");
            }
            if (m.signFist != m.signSecond) {
                m.result.append("-");
            }
            m.resultUnSignInDec = toDecimal(m.firstNum, m.B) * toDecimal(m.secondNum, m.B);
            if (m.resultUnSignInDec == 0) {
                m.result.setLength(0);
                m.result.append(0);
            } else {
                m.result.append(fromDec(m.B, m.resultUnSignInDec));

            }
            System.out.println(m.result);

        }
    }


    static int val(char c) {
        if (c >= '0' && c <= '9')
            return (int) c - '0';
        else
            return (int) c - 'A' + 10;
    }

    static int toDecimal(String str,
                         int base) {
        int len = str.length();
        int power = 1; // Initialize
        // power of base
        int num = 0; // Initialize result
        int i;
        for (i = len - 1; i >= 0; i--) {
            if (val(str.charAt(i)) >= base) {
                System.out.println("Invalid Number");
                return -1;
            }
            num += val(str.charAt(i)) * power;
            power = power * base;
        }

        return num;
    }

    static char reVal(int num) {
        if (num >= 0 && num <= 9)
            return (char) (num + 48);
        else
            return (char) (num - 10 + 65);
    }


    static String fromDec(int base1, int inputNum) {
        String s = "";
        while (inputNum > 0) {
            s += reVal(inputNum % base1);
            inputNum /= base1;
        }
        StringBuilder ix = new StringBuilder();
        ix.append(s);
        return new String(ix.reverse());
    }
}