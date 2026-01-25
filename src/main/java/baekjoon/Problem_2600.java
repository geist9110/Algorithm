package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_2600 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] b = {
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
        };

        boolean[][] dp = new boolean[501][501];
        for (int i = 0; i <= 500; i++) {
            for (int j = 0; j <= 500; j++) {
                for (int count : b) {
                    if (i - count >= 0 && !dp[i - count][j]) {
                        dp[i][j] = true;
                    }

                    if (j - count >= 0 && !dp[i][j - count]) {
                        dp[i][j] = true;
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            if (dp[x][y]) {
                sb.append("A\n");
            } else {
                sb.append("B\n");
            }
        }
        System.out.print(sb);
    }

}
