package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_1389 implements ProblemInterface {

    private static final int INF = 5_001;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] dp = new int[N][N];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][i] = 0;
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());

            dp[A - 1][B - 1] = 1;
            dp[B - 1][A - 1] = 1;
        }

        for (int stopover = 0; stopover < N; stopover++) {
            for (int depart = 0; depart < N; depart++) {
                for (int arrive = depart + 1; arrive < N; arrive++) {
                    int min = Math.min(
                        dp[depart][arrive],
                        dp[depart][stopover] + dp[stopover][arrive]
                    );
                    dp[depart][arrive] = min;
                    dp[arrive][depart] = min;
                }
            }
        }

        int result = 0;
        int resultSum = Integer.MAX_VALUE;
        for (int i = 0; i < N; i++) {
            int sum = 0;
            for (int j = 0; j < N; j++) {
                sum += dp[i][j];
            }

            if (sum < resultSum) {
                resultSum = sum;
                result = i;
            }
        }

        System.out.println(result + 1);
    }
}
