package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_13398 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] numbers = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            numbers[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][2];
        dp[0][0] = dp[0][1] = numbers[0];
        int result = numbers[0];
        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(numbers[i], numbers[i] + dp[i - 1][0]);
            dp[i][1] = Math.max(Math.max(dp[i - 1][0], dp[i][0]), dp[i - 1][1] + numbers[i]);

            result = Math.max(result, Math.max(dp[i][0], dp[i][1]));
        }

        System.out.print(result);
    }

}
