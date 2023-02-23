package utils;

public class Sinh {
    static int n = 9;
    static int k = 3;
    static int[] a = new int[n + 5];
    static int cnt = 0;
    static boolean[] used = new boolean[n + 5];

    public static void main(String[] args) {

//        hoanVi(1);
//        chinhHop(1);
        chinhHopLap(1);
//        toHop(1);
//        allNum(1);
        println("cnt = " + cnt);
    }

    static void allNum(int index) {
        if (index > n) {
            for (int i = 1; i <= n; i++) {
                print(a[i] + " ");
            }
            println("");
            cnt++;
        } else {
            for (int val = 1; val <= n; val++) {
                a[index] = val;
                allNum(index + 1);
            }
        }
    }

    static void hoanVi(int index) {
        if (index > n) {
            for (int i = 1; i <= n; i++) {
                print(a[i] + " ");
            }
            println("");
            cnt++;
        } else {
            for (int val = 1; val <= n; val++) {
                if (used[val]) continue;
                a[index] = val;
                used[val] = true;
                hoanVi(index + 1);
                used[val] = false;
            }
        }
    }


    static void chinhHop(int index) {
        if (index > k) {
            for (int i = 1; i <= k; i++) {
                print(a[i] + " ");
            }
            println("");
            cnt++;
        } else {
            for (int val = 1; val <= n; val++) {
                if (used[val]) continue;
                a[index] = val;
                used[val] = true;
                chinhHop(index + 1);
                used[val] = false;
            }

        }
    }

    static void chinhHopLap(int index) {
        if (index > k) {
            for (int i = 1; i <= k; i++) {
                print(a[i] + " ");
            }
            println("");
            cnt++;
        }
        else {
            for (int val = 1; val <= n ; val++) {
                a[index] = val;
                chinhHopLap(index + 1);
            }
        }
    }

    static void toHop(int index) {
        if (index > k) {
            for (int i = 1; i <= k; i++) {
                print(a[i] + " ");
            }
            println("");
            cnt++;
        } else {
            for (int val = 1; val <= n; val++) {
                if (used[val]) continue;
                if (index > 1 && val <= a[index - 1]) continue;
                a[index] = val;
                used[val] = true;
                toHop(index + 1);
                used[val] = false;
            }
        }
    }

    static <T> void println(T t) {
        System.out.println(t);
    }

    static <T> void print(T t) {
        System.out.print(t);
    }
}
