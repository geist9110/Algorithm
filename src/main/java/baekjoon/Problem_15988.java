package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_15988 implements ProblemInterface {

    private static final int MOD = 1_000_000_009;
    private static final int MAX_VALUE = 1_000_000;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] dp = new int[MAX_VALUE + 1];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;

        for (int i = 4; i <= MAX_VALUE; i++) {
            dp[i] = ((dp[i - 1] + dp[i - 2]) % MOD + dp[i - 3]) % MOD;
        }

        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
            sb.append(dp[Integer.parseInt(br.readLine())]).append("\n");
        }
        System.out.print(sb);
    }

}
