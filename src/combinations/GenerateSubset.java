package combinations;

public class GenerateSubset {
    public static void main(String[] args) {
        int N = 5;
        int[] p = new int[N];
        for (int i = 0; i < N; i++) p[i] = i;

        int count = 0;
        for (int i = 0; i < (1 << N); i++) {

            for (int j = 0; j < N; j++)
                if ((i & (1 << j)) > 0) // if bit j is on
                    System.out.printf("%d ", p[j]); // this is part of set
            System.out.println();
            count++;
        }
        System.out.println("count: " + count);
    }
}
