package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_1495 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int S = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] volumes = new int[N + 1];
        boolean[][] dp = new boolean[N + 1][M + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            volumes[i] = Integer.parseInt(st.nextToken());
        }

        dp[0][S] = true;
        for (int volumeIndex = 1; volumeIndex <= N; volumeIndex++) {
            for (int currentVolume = 0; currentVolume <= M; currentVolume++) {
                if (!dp[volumeIndex - 1][currentVolume]) {
                    continue;
                }

                int change = currentVolume + volumes[volumeIndex];
                if (change <= M) {
                    dp[volumeIndex][change] = true;
                }

                change = currentVolume - volumes[volumeIndex];
                if (change >= 0) {
                    dp[volumeIndex][change] = true;
                }

            }
        }

        for (int i = M; i >= 0; i--) {
            if (dp[N][i]) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(-1);

    }

}
