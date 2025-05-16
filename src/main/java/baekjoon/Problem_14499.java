package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14499 implements ProblemInterface {

    private static class Dice {

        int top;
        int bottom;
        int east;
        int west;
        int north;
        int south;

        public Dice(int top, int bottom, int east, int west, int north, int south) {
            this.top = top;
            this.bottom = bottom;
            this.east = east;
            this.west = west;
            this.north = north;
            this.south = south;
        }
    }

    private static final int EAST = 1, WEST = 2, NORTH = 3, SOUTH = 4;
    private static final int[][] DIRECTION = {{}, {0, 1}, {0, -1}, {-1, 0}, {1, 0}};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        Dice dice = new Dice(0, 0, 0, 0, 0, 0);
        for (int i = 0; i < K; i++) {
            int nextDirection = Integer.parseInt(st.nextToken());
            int nextX = x + DIRECTION[nextDirection][0];
            int nextY = y + DIRECTION[nextDirection][1];

            if (nextX < 0 || nextX >= N || nextY < 0 || nextY >= M) {
                continue;
            }

            x = nextX;
            y = nextY;

            rollDice(dice, nextDirection);
            sb.append(dice.top).append("\n");

            if (map[x][y] == 0) {
                map[x][y] = dice.bottom;
                continue;
            }

            dice.bottom = map[x][y];
            map[x][y] = 0;
        }

        System.out.print(sb);
    }

    private static void rollDice(Dice dice, int direction) {
        int top = dice.top;
        int bottom = dice.bottom;
        int east = dice.east;
        int west = dice.west;
        int north = dice.north;
        int south = dice.south;

        if (direction == EAST) {
            dice.top = west;
            dice.west = bottom;
            dice.bottom = east;
            dice.east = top;
            return;
        }

        if (direction == WEST) {
            dice.top = east;
            dice.east = bottom;
            dice.bottom = west;
            dice.west = top;
            return;
        }

        if (direction == NORTH) {
            dice.top = south;
            dice.south = bottom;
            dice.bottom = north;
            dice.north = top;
            return;
        }

        if (direction == SOUTH) {
            dice.top = north;
            dice.north = bottom;
            dice.bottom = south;
            dice.south = top;
            return;
        }
    }
}
