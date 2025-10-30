package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_24725 implements ProblemInterface {

    private static final int[][] DIRECTIONS = {
        {1, 1}, {1, 0}, {1, -1}, {0, 1}, {0, -1}, {-1, 1}, {-1, 0}, {-1, -1}
    };
    private static final char[][] MBTI = {{'E', 'I'}, {'N', 'S'}, {'F', 'T'}, {'P', 'J'}};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        char[][] map = new char[N][M];

        for (int row = 0; row < N; row++) {
            String s = br.readLine();

            for (int col = 0; col < M; col++) {
                map[row][col] = s.charAt(col);
            }
        }

        int result = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                for (int[] direction : DIRECTIONS) {
                    int lastRow = row + direction[0] * 3;
                    int lastCol = col + direction[1] * 3;

                    if (lastRow < 0 || lastRow >= N || lastCol < 0 || lastCol >= M) {
                        continue;
                    }

                    int nextRow = row;
                    int nextCol = col;
                    boolean flag = true;
                    for (int mbtiIndex = 0; mbtiIndex < 4; mbtiIndex++) {
                        if (map[nextRow][nextCol] != MBTI[mbtiIndex][0]
                                && map[nextRow][nextCol] != MBTI[mbtiIndex][1]) {
                            flag = false;
                            break;
                        }
                        nextRow += direction[0];
                        nextCol += direction[1];
                    }

                    if (flag) {
                        result++;
                    }
                }
            }
        }

        System.out.print(result);
    }
}
