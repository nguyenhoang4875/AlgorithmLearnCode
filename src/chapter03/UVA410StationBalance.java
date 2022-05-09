package chapter03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA410StationBalance {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int cases = 1;
        DecimalFormat f = new DecimalFormat("0.00000");
        while (br.ready()) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int c = Integer.parseInt(st.nextToken());
            int s = Integer.parseInt(st.nextToken());
            int[] arr = new int[2 * c];
            st = new StringTokenizer(br.readLine());
            int sum = 0;
            double imbalance = 0;

            for (int i = 0; i < s; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
                sum += arr[i];
            }
            arr = arr.clone();
            Arrays.sort(arr);
            out.append("Set #" + cases++ + "\n");
            double a = sum * 1.0 / c;
            for (int i = 0; i < c; i++) {
                int x = arr[i];
                int y = arr[2 * c - 1 - i];
                out.append(" " + i + ":");
                if (x == 0 || y == 0) {
                    if (x != 0) out.append(" " + x);
                    if (y != 0) out.append(" " + y);
                } else
                    out.append(" " + x + " " + y);
                imbalance += Math.abs((x + y) - a);
                out.append("\n");
            }
            out.append("IMBALANCE = " + f.format(imbalance) + "\n\n");
        }
        out.flush();
    }
}
