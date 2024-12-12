package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14500 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int max = fixHorizontalTwoPoint(N, M, map);
        max = Math.max(max, fixHorizontalThreePoint(N, M, map));
        max = Math.max(max, fixVerticalThreePoint(N, M, map));

        System.out.print(max);
    }

    private static int fixHorizontalTwoPoint(int N, int M, int[][] map) {
        int max = 0;
        for (int row = 0; row < N; row++) {
            int sum = map[row][0];

            for (int col = 0; col < M - 1; col++) {
                sum += map[row][col + 1];

                if (row - 1 >= 0 && row + 1 < N) {
                    max = Math.max(max, sum + map[row - 1][col] + map[row + 1][col + 1]);
                }

                if (row + 1 < N && row - 1 >= 0) {
                    max = Math.max(max, sum + map[row - 1][col + 1] + map[row + 1][col]);
                }

                if (row + 1 < N) {
                    max = Math.max(max, sum + map[row + 1][col] + map[row + 1][col + 1]);
                }

                if (row + 1 < N && col - 1 >= 0) {
                    max = Math.max(max, sum + map[row + 1][col] + map[row + 1][col - 1]);
                }

                if (row + 1 < N && col + 2 < M) {
                    max = Math.max(max, sum + map[row + 1][col + 1] + map[row + 1][col + 2]);
                }

                sum -= map[row][col];
            }
        }

        return max;
    }

    private static int fixHorizontalThreePoint(int N, int M, int[][] map) {
        int max = 0;

        for (int row = 0; row < N; row++) {
            int sum = map[row][0] + map[row][1];

            for (int col = 0; col < M - 2; col++) {
                sum += map[row][col + 2];

                if (row - 1 >= 0) {
                    max = Math.max(max, sum + map[row - 1][col]);
                    max = Math.max(max, sum + map[row - 1][col + 1]);
                    max = Math.max(max, sum + map[row - 1][col + 2]);
                }

                if (row + 1 < N) {
                    max = Math.max(max, sum + map[row + 1][col]);
                    max = Math.max(max, sum + map[row + 1][col + 1]);
                    max = Math.max(max, sum + map[row + 1][col + 2]);
                }

                if (col + 3 < M) {
                    max = Math.max(max, sum + map[row][col + 3]);
                }

                sum -= map[row][col];
            }
        }
        return max;
    }

    private static int fixVerticalThreePoint(int N, int M, int[][] map) {
        int max = 0;

        for (int col = 0; col < M; col++) {
            int sum = map[0][col] + map[1][col];

            for (int row = 0; row < N - 2; row++) {
                sum += map[row + 2][col];

                if (col - 1 >= 0) {
                    max = Math.max(max, sum + map[row][col - 1]);
                    max = Math.max(max, sum + map[row + 1][col - 1]);
                    max = Math.max(max, sum + map[row + 2][col - 1]);
                }

                if (col + 1 < M) {
                    max = Math.max(max, sum + map[row][col + 1]);
                    max = Math.max(max, sum + map[row + 1][col + 1]);
                    max = Math.max(max, sum + map[row + 2][col + 1]);
                }

                if (row + 3 < N) {
                    max = Math.max(max, sum + map[row + 3][col]);
                }

                sum -= map[row][col];
            }
        }

        return max;
    }
}