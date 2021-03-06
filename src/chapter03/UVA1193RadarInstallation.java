package chapter03;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class UVA1193RadarInstallation {
    public static void main(String[] args) throws Throwable {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter out = new PrintWriter(System.out);
        int cases = 1;
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken());
            if (n == 0)
                break;
            Interval[] arr = new Interval[n];
            boolean flag = true;
            out.append("Case " + cases++ + ": ");
            for (int i = 0; i < n; i++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                double beg = (double) x - Math.sqrt((double) d * d - y * y);
                double end = (double) x + Math.sqrt((double) d * d - y * y);
                arr[i] = new Interval(beg, end);
                if (y > d)
                    flag = false;
            }
            br.readLine();
            if (!flag) {
                out.append(-1 + "\n");
                continue;
            }
            Arrays.sort(arr);
            int ans = 0;
            for (int i = 0; i < arr.length; ) {
                double tmpEnd = arr[i].end;

                while (i < n) {
                    if (arr[i].beg > tmpEnd) break;
                    tmpEnd = Math.min(tmpEnd, arr[i].end);
                    i++;
                }
                ans++;
            }
            out.append(ans + "\n");
        }
        out.flush();
    }

    static class Interval implements Comparable<Interval> {
        double beg, end;

        public Interval(double x, double y) {
            this.beg = x;
            this.end = y;
        }

        public int compareTo(Interval o) {
            if (Double.compare(this.beg, o.beg) != 0)
                return Double.compare(this.beg, o.beg);
            return Double.compare(o.end, this.end);
        }

        public String toString() {
            return beg + " & " + end + " ";
        }
    }
}
