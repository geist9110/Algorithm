package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1937 implements ProblemInterface {

    private static final int[][] DIRECTION = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
    private static int[][] map;
    private static int[][] dp;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        map = new int[n][n];
        dp = new int[n][n];

        for (int row = 0; row < n; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < n; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                result = Math.max(result, dfs(row, col));
            }
        }

        System.out.print(result);
    }

    private static int dfs(int row, int col) {
        if (dp[row][col] != 0) {
            return dp[row][col];
        }

        dp[row][col] = 1;
        for (int[] direction : DIRECTION) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (nextRow < 0 || nextRow >= map.length || nextCol < 0 || nextCol >= map.length) {
                continue;
            }

            if (map[row][col] < map[nextRow][nextCol]) {
                dp[row][col] = Math.max(dp[row][col], dfs(nextRow, nextCol) + 1);
            }
        }

        return dp[row][col];
    }
}
