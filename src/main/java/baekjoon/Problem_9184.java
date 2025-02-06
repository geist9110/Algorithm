package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_9184 implements ProblemInterface {

    private static int[][][] dp;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        dp = new int[21][21][21];
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        StringBuilder sb = new StringBuilder();
        while (a != -1 || b != -1 || c != -1) {
            sb.append("w(").append(a).append(", ")
                    .append(b).append(", ")
                    .append(c).append(") = ")
                    .append(dfs(a, b, c))
                    .append("\n");

            st = new StringTokenizer(br.readLine());
            a = Integer.parseInt(st.nextToken());
            b = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());
        }

        System.out.print(sb);
    }

    private static int dfs(int a, int b, int c) {
        if (a <= 0 || b <= 0 || c <= 0) {
            return dp[0][0][0] = 1;
        }

        if (a > 20 || b > 20 || c > 20) {
            return dp[20][20][20] = dfs(20, 20, 20);
        }

        if (dp[a][b][c] != 0) {
            return dp[a][b][c];
        }

        if (a < b && b < c) {
            return dp[a][b][c] = dfs(a, b, c - 1) + dfs(a, b - 1, c - 1) - dfs(a, b - 1, c);
        }

        return dp[a][b][c] = dfs(a - 1, b, c) + dfs(a - 1, b - 1, c) + dfs(a - 1, b, c - 1)
                - dfs(a - 1, b - 1, c - 1);
    }

}
