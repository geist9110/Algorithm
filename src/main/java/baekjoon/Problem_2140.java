package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_2140 implements ProblemInterface {

    private static final int CLOSE = '#' - '0';
    private static final int MINE = -9999;
    private static final int EMPTY = -9998;
    private static final int[][] DIRECTIONS = {
            { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 },
            { -1, -1 }, { -1, 1 }, { 1, -1 }, { 1, 1 } };

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (map[row][col] < 0) {
                    continue;
                }

                int mineCount = map[row][col];
                for (int[] direction : DIRECTIONS) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                        continue;
                    }

                    if (map[nextRow][nextCol] == MINE) {
                        mineCount--;
                    }
                }

                for (int[] direction : DIRECTIONS) {
                    int nextRow = row + direction[0];
                    int nextCol = col + direction[1];
                    if (nextRow < 0 || nextRow >= N || nextCol < 0 || nextCol >= N) {
                        continue;
                    }

                    if (mineCount > 0 && map[nextRow][nextCol] == CLOSE) {
                        map[nextRow][nextCol] = MINE;
                        mineCount--;
                    } else if (mineCount == 0 && map[nextRow][nextCol] == CLOSE) {
                        map[nextRow][nextCol] = EMPTY;
                    }
                }
            }
        }

        int result = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (map[row][col] == CLOSE || map[row][col] == MINE) {
                    result++;
                }
            }
        }

        System.out.print(result);
    }

}
