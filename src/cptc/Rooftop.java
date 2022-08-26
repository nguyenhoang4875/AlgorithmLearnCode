import java.util.Scanner;

public class Main {
	static int N;//Number of buildings
	static int H[] = new int [80010];//Height of buildings
	static int next[] = new int [80010];
	static int oo = 1000000000;

	static public void inputData()  {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		for (int i = 1; i <= N; i++) {
			H[i] = sc.nextInt();
		}
	}

	public static void main(String[] args){
		long ans = 0;

		inputData();				//	Input function

		//	Write the code
		H[N + 1] = oo;
		for (int i = N; i >= 1; i--) {
			int j = i + 1;
			while (H[i] > H[j]) j = next[j];
			next[i] = j;
			
			ans += next[i] - i - 1;
		}
	
		System.out.println(ans);	//	Output right answer
	}
}
