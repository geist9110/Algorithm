package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_15624 implements ProblemInterface {

    private static final int MOD = 1_000_000_007;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        if (n == 0) {
            System.out.print(0);
            return;
        }

        if (n == 1) {
            System.out.print(1);
            return;
        }

        int prev = 0;
        int current = 1;
        for (int i = 2; i <= n; i++) {
            int temp = current;
            current = (current + prev) % MOD;
            prev = temp;
        }

        System.out.print(current);
    }
}
