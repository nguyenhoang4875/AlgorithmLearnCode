import java.io.*;
import java.util.*;

/**
* https://codepro.lge.com/exam/19/overseas-questions-for-previous-test/quiz/12
*/
class Clearance2 {
	static Scanner sc = new Scanner(System.in);
	static int n, m;
	static int[] a = new int[100005];
	static int[][] cnt = new int[15][100005];
	static int ans = 1000000000;
	static boolean[] check = new boolean[15];
	static int[] genRes = new int[15];
	
	static void gen(int i) {
		if (i > m) {
			int start = 1, end;
			int res = 0;
			for (int j = 1; j <= m; j++) {
				int id = genRes[j];
				end = start + cnt[id][n] - 1;
				int num = cnt[id][end] - cnt[id][start - 1];
				res += cnt[id][n] - num;
				start = end + 1;
			}
			if (ans > res) ans = res;
			return;
		}
		
		for (int val = 1; val <= m; val++) {
			if (check[val]) continue;
			genRes[i] = val;
			check[val] = true;
			gen(i + 1);
			check[val] = false;
		}
	}
	
	public static void main(String[] args) throws Exception {
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			a[i] = sc.nextInt();
			for (int id = 1; id <= m; id++) {
				cnt[id][i] = cnt[id][i - 1];
				if (id == a[i]) cnt[id][i]++;
			}
		}
		gen(1);
		System.out.println(ans);
	}
}
