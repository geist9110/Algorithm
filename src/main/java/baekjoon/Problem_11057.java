package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_11057 implements ProblemInterface {

    private static final int MOD = 10_007;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[][] dp = new int[10][N + 1];

        for (int i = 1; i <= N; i++) {
            dp[9][i] = 1;
            for (int j = 8; j >= 0; j--) {
                dp[j][i] = (dp[j + 1][i] + dp[j][i - 1]) % MOD;
            }
        }

        int result = 0;
        for (int i = 0; i <= 9; i++) {
            result += dp[i][N];
            result %= MOD;
        }
        System.out.print(result);
    }

}
