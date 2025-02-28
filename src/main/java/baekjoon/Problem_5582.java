package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_5582 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String first = br.readLine();
        String second = br.readLine();
        int[][] dp = new int[first.length() + 1][second.length() + 1];
        int max = 0;
        for (int row = 1; row <= first.length(); row++) {
            for (int col = 1; col <= second.length(); col++) {
                if (first.charAt(row - 1) == second.charAt(col - 1)) {
                    dp[row][col] = dp[row - 1][col - 1] + 1;
                    max = Math.max(max, dp[row][col]);
                }
            }
        }

        System.out.print(max);
    }

}
