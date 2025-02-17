package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_1890 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        long[][] dp = new long[N][N];
        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][0] = 1;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (row == N - 1 && col == N - 1) {
                    continue;
                }

                if (row + map[row][col] < N) {
                    dp[row + map[row][col]][col] += dp[row][col];
                }

                if (col + map[row][col] < N) {
                    dp[row][col + map[row][col]] += dp[row][col];
                }
            }
        }

        System.out.print(dp[N - 1][N - 1]);
    }

}
