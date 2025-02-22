package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2225 implements ProblemInterface {

    private static final int MOD = 1_000_000_000;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[N + 1];
        dp[0] = 1;

        for (int row = 0; row < K; row++) {
            for (int col = 1; col <= N; col++) {
                dp[col] += dp[col - 1];
                dp[col] %= MOD;
            }
        }

        System.out.print(dp[N]);
    }

}
