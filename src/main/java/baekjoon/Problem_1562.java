package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_1562 implements ProblemInterface {

    private static final int MAX_BIT = 1023;
    private static final long MOD = 1_000_000_000;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[][][] dp = new long[N][10][MAX_BIT + 1];

        for (int i = 1; i <= 9; i++) {
            dp[0][i][1 << i] = 1;
        }

        for (int i = 1; i < N; i++) {
            for (int j = 0; j <= 9; j++) {
                for (int k = 0; k <= MAX_BIT; k++) {
                    if (j > 0) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j - 1][k];
                    }
                    if (j < 9) {
                        dp[i][j][k | (1 << j)] += dp[i - 1][j + 1][k];
                    }
                    dp[i][j][k | (1 << j)] %= MOD;
                }
            }
        }

        long result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[N - 1][i][MAX_BIT];
            result %= MOD;
        }

        System.out.print(result);

    }
}
