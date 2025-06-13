package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Problem_17143 implements ProblemInterface {

    private static final int UP = 0;
    private static final int DOWN = 1;
    private static final int RIGHT = 2;
    private static final int LEFT = 3;

    private static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, 1}, {0, -1}};

    private static int R;
    private static int C;

    private static class Shark {

        int row;
        int col;
        int speed;
        int direction;
        int size;

        public Shark(int row, int col, int speed, int direction, int size) {
            this.row = row;
            this.col = col;
            this.speed = speed;
            this.direction = direction;
            this.size = size;
        }

        public void move() {
            for (int s = 0; s < speed; s++) {
                nextMove();
            }
        }

        private void nextMove() {
            if (direction == UP && row == 0) {
                direction = DOWN;
            }

            if (direction == DOWN && row == R - 1) {
                direction = UP;
            }

            if (direction == LEFT && col == 0) {
                direction = RIGHT;
            }

            if (direction == RIGHT && col == C - 1) {
                direction = LEFT;
            }

            row += DIRECTION[direction][0];
            col += DIRECTION[direction][1];
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        Shark[][] board = new Shark[R][C];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            int s = Integer.parseInt(st.nextToken());
            int d = Integer.parseInt(st.nextToken()) - 1;
            int z = Integer.parseInt(st.nextToken());

            if (d == UP || d == DOWN) {
                s %= (2 * (R - 1));
            }

            if (d == RIGHT || d == LEFT) {
                s %= (2 * (C - 1));
            }

            board[r][c] = new Shark(r, c, s, d, z);
        }

        int totalSize = 0;
        for (int fisher = 0; fisher < C; fisher++) {
            for (int row = 0; row < R; row++) {
                if (board[row][fisher] == null) {
                    continue;
                }

                totalSize += board[row][fisher].size;
                board[row][fisher] = null;
                break;
            }

            ArrayList<Shark> sharks = new ArrayList<>();
            for (int row = 0; row < R; row++) {
                for (int col = 0; col < C; col++) {
                    if (board[row][col] == null) {
                        continue;
                    }
                    sharks.add(board[row][col]);
                    board[row][col] = null;
                }
            }

            for (Shark shark : sharks) {
                shark.move();
            }

            for (Shark shark : sharks) {
                if (board[shark.row][shark.col] == null) {
                    board[shark.row][shark.col] = shark;
                    continue;
                }

                if (board[shark.row][shark.col].size < shark.size) {
                    board[shark.row][shark.col] = shark;
                }
            }
        }

        System.out.print(totalSize);
    }
}
