package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_3359 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[] heights = new int[n];
        int[] widths = new int[n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            heights[i] = Integer.parseInt(st.nextToken());
            widths[i] = Integer.parseInt(st.nextToken());
        }

        int[][] dp = new int[n][2];
        dp[0][0] = widths[0];
        dp[0][1] = heights[0];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.max(
                    dp[i - 1][0] + Math.abs(heights[i - 1] - heights[i]) + widths[i],
                    dp[i - 1][1] + Math.abs(widths[i - 1] - heights[i]) + widths[i]);

            dp[i][1] = Math.max(
                    dp[i - 1][0] + Math.abs(heights[i - 1] - widths[i]) + heights[i],
                    dp[i - 1][1] + Math.abs(widths[i - 1] - widths[i]) + heights[i]);
        }

        System.out.print(Math.max(dp[n - 1][0], dp[n - 1][1]));
    }

}
