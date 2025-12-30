package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1359 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] combination = new int[N + 1][N + 1];
        combination[0][0] = 1;
        for (int i = 0; i <= N; i++) {
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    combination[i][j] = 1;
                } else {
                    combination[i][j] = combination[i - 1][j - 1] + combination[i - 1][j];
                }
            }
        }

        int totalCount = 0;
        for (int i = K; i <= M; i++) {
            totalCount += combination[M][i] * combination[N - M][M - i];
        }

        System.out.print((double) totalCount / combination[N][M]);
    }

}
