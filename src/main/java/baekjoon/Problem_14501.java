package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_14501 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] dp = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int time = Integer.parseInt(st.nextToken());
            int profit = Integer.parseInt(st.nextToken());
            int endDate = i + time - 1;

            dp[i] = Math.max(dp[i], dp[i - 1]);

            if (endDate > N) {
                continue;
            }

            dp[endDate] = Math.max(dp[endDate], dp[i - 1] + profit);

        }

        System.out.println(dp[N]);
    }

}
