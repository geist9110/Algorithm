package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_11048 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] candyMap = new int[N + 1][M + 1];
        for (int row = 1; row <= N; row++) {
            st = new StringTokenizer(br.readLine(), " ");
            for (int col = 1; col <= M; col++) {
                candyMap[row][col] = Math.max(candyMap[row - 1][col], candyMap[row][col - 1])
                        + Integer.parseInt(st.nextToken());
            }
        }

        System.out.print(candyMap[N][M]);
    }
}
