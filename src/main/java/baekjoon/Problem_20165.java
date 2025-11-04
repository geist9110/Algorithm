package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_20165 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] domino = new int[N][M];
        boolean[][] fallen = new boolean[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                domino[row][col] = Integer.parseInt(st.nextToken()) - 1;
            }
        }

        int attackerScore = 0;
        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());
            int row = Integer.parseInt(st.nextToken()) - 1;
            int col = Integer.parseInt(st.nextToken()) - 1;
            char direction = st.nextToken().charAt(0);
            int lastRow = row;
            int lastCol = col;

            while (row >= 0 && row < N && col >= 0 && col < M) {

                if (!fallen[row][col]) {
                    attackerScore++;
                    fallen[row][col] = true;

                    if (direction == 'E') {
                        lastCol = Math.max(lastCol, col + domino[row][col]);
                    } else if (direction == 'W') {
                        lastCol = Math.min(lastCol, col - domino[row][col]);
                    } else if (direction == 'S') {
                        lastRow = Math.max(lastRow, row + domino[row][col]);
                    } else {
                        lastRow = Math.min(lastRow, row - domino[row][col]);
                    }
                }

                if (direction == 'E') {
                    col++;
                    if (col > lastCol) {
                        break;
                    }
                } else if (direction == 'W') {
                    col--;
                    if (col < lastCol) {
                        break;
                    }
                } else if (direction == 'S') {
                    row++;
                    if (row > lastRow) {
                        break;
                    }
                } else {
                    row--;
                    if (row < lastRow) {
                        break;
                    }
                }
            }

            st = new StringTokenizer(br.readLine());
            row = Integer.parseInt(st.nextToken()) - 1;
            col = Integer.parseInt(st.nextToken()) - 1;
            fallen[row][col] = false;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(attackerScore).append("\n");

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (fallen[row][col]) {
                    sb.append("F ");
                    continue;
                }
                sb.append("S ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
