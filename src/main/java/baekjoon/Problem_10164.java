package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_10164 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N][M];

        for (int i = 0; i < N; i++) {
            dp[i][0] = 1;
        }

        for (int i = 0; i < M; i++) {
            dp[0][i] = 1;
        }

        for (int row = 1; row < N; row++) {
            for (int col = 1; col < M; col++) {
                dp[row][col] = dp[row - 1][col] + dp[row][col - 1];
            }
        }

        if (K == 0) {
            System.out.print(dp[N - 1][M - 1]);
            return;
        }

        int KRow = (K - 1) / M, KCol = (K - 1) % M;
        System.out.print(dp[KRow][KCol] * dp[N - KRow - 1][M - KCol - 1]);
    }
}
