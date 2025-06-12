package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1106 implements ProblemInterface {

    private static final int MAX_VALUE = 1_000 * 100 + 1;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int C = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        int[] dp = new int[C + 1];
        int[] costs = new int[101];

        Arrays.fill(costs, MAX_VALUE);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int cost = Integer.parseInt(st.nextToken());
            int person = Integer.parseInt(st.nextToken());
            costs[person] = Math.min(costs[person], cost);
        }

        for (int i = 1; i <= C; i++) {
            dp[i] = MAX_VALUE;
            for (int j = 0; j <= 100; j++) {
                dp[i] = Math.min(dp[i], dp[Math.max(i - j, 0)] + costs[j]);
            }
        }

        System.out.print(dp[C]);
    }
}
