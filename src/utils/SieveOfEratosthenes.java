package utils;

import java.util.BitSet;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        int n = 100;
        BitSet primes = new BitSet(n + 1);
        for (int i = 2; i <= n; i++) {
            primes.set(i);
        }
        sieveOfEratosthenes(n, primes);
        for (int i = 0; i < primes.length(); i++) {
            if (primes.get(i)) {
                System.out.printf("%3d", i);
            }
        }
    }

    public static void sieveOfEratosthenes(int n, BitSet primes) {
        for (int p = 2; p * p <= n; p++) {
            if (primes.get(p)) {
                for (int i = p * p; i <= n; i += p) {
                    primes.clear(i);
                }
            }
        }
    }
}
