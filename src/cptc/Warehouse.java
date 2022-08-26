import java.io.*;
import java.util.*;
import static java.lang.Math.*;

class Main {
	static Scanner sc = new Scanner(System.in);
	static int n, m, u, v, w;
	static int[][] graph = new int[105][105];
	static int[] d = new int[105];
	static boolean[] visited = new boolean[105];
	static final int oo = 1000000000;
	
	static int dijktra(int s) {
		for (int i = 1; i <= n; i++) {
			d[i] = oo;
			visited[i] = false;
		}
		d[s] = 0;
		while (true) {
			// chon u lam chuan
			int u = -1;
			for (int i = 1; i <= n; i++) {
				if (!visited[i]) {
					if (u == -1 || d[u] > d[i]) u = i;
				}
			}
			if (u == -1) break;
			visited[u] = true;
			// cap nhat dinh lan can
			for (int v = 1; v <= n; v++) {
				if (!visited[v] && graph[u][v] != oo && d[v] > d[u] + graph[u][v]) {
					d[v] = d[u] + graph[u][v];
				}
			}
		}
		int res = 0;
		for (int i = 1; i <= n; i++) res = max(res, d[i]);
		return res;
	}
	
	public static void main(String[] args) throws Exception {
		n = sc.nextInt();
		m = sc.nextInt();
		for (int i = 1; i <= n; i++) {
			for (int j = 1; j <= n; j++) {
				graph[i][j] = oo;
			}
		}
		
		for (int i = 1; i <= m; i++) {
			u = sc.nextInt();
			v = sc.nextInt();
			w = sc.nextInt();
			graph[u][v] = graph[v][u] = w;
		}
		
		int ans = oo;
		for (int i = 1; i <= n; i++) {
			ans = min(ans, dijktra(i));
		}
		System.out.println(ans);
	}
} 
