package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_5557 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        int[] array = new int[N - 1];
        for (int i = 0; i < N - 1; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }
        int lastNumber = Integer.parseInt(st.nextToken());

        long[][] dp = new long[N - 1][21];
        dp[0][array[0]] = 1;
        for (int i = 1; i < N - 1; i++) {
            for (int j = 0; j < 21; j++) {
                if (j + array[i] <= 20) {
                    dp[i][j + array[i]] += dp[i - 1][j];
                }
                if (j - array[i] >= 0) {
                    dp[i][j - array[i]] += dp[i - 1][j];
                }
            }

        }

        System.out.print(dp[N - 2][lastNumber]);
    }

}
