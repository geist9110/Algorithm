package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_1788 implements ProblemInterface {

    private static final int MOD = 1_000_000_000;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.print("0\n0");
            return;
        }

        int absoluteN = Math.abs(n);
        int[] fibonacci = new int[absoluteN + 1];
        fibonacci[1] = 1;

        for (int i = 2; i <= absoluteN; i++) {
            fibonacci[i] = (fibonacci[i - 1] + fibonacci[i - 2]) % MOD;
        }

        if (n < 0 && absoluteN % 2 == 0) {
            System.out.printf("%d\n%d", -1, fibonacci[absoluteN]);
            return;
        }

        System.out.printf("%d\n%d", 1, fibonacci[absoluteN]);
    }
}
