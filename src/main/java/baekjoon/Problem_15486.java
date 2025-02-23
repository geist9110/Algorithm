package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_15486 implements ProblemInterface {

    private static final int TIME = 0, EARN = 1;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[][] counsil = new int[2][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            counsil[TIME][i] = Integer.parseInt(st.nextToken());
            counsil[EARN][i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N + 1];
        for (int i = N - 1; i >= 0; i--) {
            dp[i] = dp[i + 1];
            int time = counsil[TIME][i] + i;
            if (time > N) {
                continue;
            }
            dp[i] = Math.max(dp[i], dp[time] + counsil[EARN][i]);
        }

        System.out.print(dp[0]);
    }

}
