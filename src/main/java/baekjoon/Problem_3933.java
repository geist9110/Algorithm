package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_3933 implements ProblemInterface {

    private static final int MAX = 32768;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[][] dp = new int[MAX + 1][5];
        dp[0][0] = 1;
        for (int i = 1; i * i <= MAX; i++) {
            for (int j = i * i; j <= MAX; j++) {
                for (int k = 1; k <= 4; k++) {
                    dp[j][k] += dp[j - i * i][k - 1];
                }
            }
        }

        int n = Integer.parseInt(br.readLine());
        while (n != 0) {
            int result = 0;
            for (int i = 1; i <= 4; i++) {
                result += dp[n][i];
            }
            sb.append(result).append('\n');
            n = Integer.parseInt(br.readLine());
        }
        System.out.print(sb);
    }

}
