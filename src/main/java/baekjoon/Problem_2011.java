package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_2011 implements ProblemInterface {

    private static final int MOD = 1_000_000;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String password = br.readLine();

        int[] dp = new int[password.length() + 1];
        dp[0] = 1;
        dp[1] = password.charAt(0) - '0' == 0 ? 0 : 1;

        for (int i = 2; i <= password.length(); i++) {
            int current = password.charAt(i - 1) - '0';
            if (current >= 1 && current <= 9) {
                dp[i] += dp[i - 1];
            }

            int value = (password.charAt(i - 2) - '0') * 10 + current;
            if (value >= 10 && value <= 26) {
                dp[i] += dp[i - 2];
                dp[i] %= MOD;
            }
        }

        System.out.print(dp[password.length()]);
    }
}
