package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_25418 implements ProblemInterface {

    private static int MAX_VALUE = 1_000_000;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] dp = new int[K + 1];
        Arrays.fill(dp, MAX_VALUE);
        dp[A] = 0;
        for (int i = A + 1; i <= K; i++) {
            if (i % 2 == 0) {
                dp[i] = Math.min(dp[i], dp[i / 2] + 1);
            }

            dp[i] = Math.min(dp[i], dp[i - 1] + 1);
        }

        System.out.print(dp[K]);
    }
}
