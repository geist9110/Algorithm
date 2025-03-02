package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_2133 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        if (N % 2 != 0) {
            System.out.print(0);
            return;
        }

        int[] dp = new int[N / 2 + 1];
        dp[0] = 1;
        dp[1] = 3;

        for (int i = 2; i <= N / 2; i++) {
            dp[i] = dp[i - 1] * 4 - dp[i - 2];
        }

        System.out.print(dp[N / 2]);
    }

}
