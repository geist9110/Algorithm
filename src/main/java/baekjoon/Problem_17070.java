package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17070 implements ProblemInterface {

    private static final String EMPTY = "0";

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()) + 1;
        boolean[][] home = new boolean[N][N];

        int[][] horizontalDP = new int[N][N];
        int[][] verticalDP = new int[N][N];
        int[][] diagonalDP = new int[N][N];

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < N; j++) {
                if (st.nextToken().equals(EMPTY)) {
                    home[i][j] = true;
                }
            }
        }

        horizontalDP[1][2] = 1;
        for (int row = 1; row < N; row++) {
            for (int col = 1; col < N; col++) {
                if (!home[row][col]) {
                    continue;
                }

                horizontalDP[row][col] += horizontalDP[row][col - 1] + diagonalDP[row][col - 1];
                verticalDP[row][col] += verticalDP[row - 1][col] + diagonalDP[row - 1][col];

                if (home[row - 1][col] && home[row][col - 1]) {
                    diagonalDP[row][col] +=
                        horizontalDP[row - 1][col - 1]
                            + verticalDP[row - 1][col - 1]
                            + diagonalDP[row - 1][col - 1];
                }
            }
        }

        System.out.println(
            horizontalDP[N - 1][N - 1] + verticalDP[N - 1][N - 1] + diagonalDP[N - 1][N - 1]
        );
    }
}
