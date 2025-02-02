package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_14494 implements ProblemInterface {

    private static final int MOD = 1_000_000_007;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n][m];
        for (int i = 0; i < n; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < m; i++) {
            dp[0][i] = 1;
        }

        for (int row = 1; row < n; row++) {
            for (int col = 1; col < m; col++) {
                dp[row][col] =
                        ((dp[row - 1][col] + dp[row][col - 1]) % MOD + dp[row - 1][col - 1]) % MOD;
            }
        }

        System.out.print(dp[n - 1][m - 1]);
    }

}
