package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_15990 implements ProblemInterface {

    private static final int MOD = 1_000_000_009;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[100_001][4];
        dp[1][1] = 1;
        dp[2][2] = 1;
        dp[3][1] = 1;
        dp[3][2] = 1;
        dp[3][3] = 1;

        for (int i = 4; i <= 100_000; i++) {
            dp[i][1] = (dp[i - 1][2] + dp[i - 1][3]) % MOD;
            dp[i][2] = (dp[i - 2][1] + dp[i - 2][3]) % MOD;
            dp[i][3] = (dp[i - 3][1] + dp[i - 3][2]) % MOD;
        }

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            int n = Integer.parseInt(br.readLine());
            int sum = (dp[n][1] + dp[n][2]) % MOD;
            sum = (sum + dp[n][3]) % MOD;
            sb.append(sum).append("\n");
        }

        System.out.print(sb);
    }

}
