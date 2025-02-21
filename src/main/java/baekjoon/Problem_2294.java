package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2294 implements ProblemInterface {

    private static final int MAX_VALUE = 100_000_000;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int[] coin = new int[n];
        int[] dp = new int[k + 1];
        for (int i = 0; i < n; i++) {
            coin[i] = Integer.parseInt(br.readLine());
        }

        for (int value = 1; value <= k; value++) {
            dp[value] = MAX_VALUE;
            for (int coinIndex = 0; coinIndex < n; coinIndex++) {
                if (value - coin[coinIndex] < 0) {
                    continue;
                }
                dp[value] = Math.min(dp[value], dp[value - coin[coinIndex]] + 1);
            }
        }

        if (dp[k] == MAX_VALUE) {
            System.out.print(-1);
            return;
        }
        System.out.print(dp[k]);
    }

}
