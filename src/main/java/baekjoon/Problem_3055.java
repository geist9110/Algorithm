package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_3055 implements ProblemInterface {

    private static final int EMPTY = -1;
    private static final int VISIT = -2;
    private static final int STONE = -3;
    private static final int CAVE = -4;

    private static final int[][] DIRECTION = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    private static int R;
    private static int C;

    private static class Node {

        int row;
        int col;
        int time;

        public Node(int row, int col, int time) {
            this.row = row;
            this.col = col;
            this.time = time;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        Queue<Node> waterQueue = new LinkedList<>();
        Queue<Node> hedgeHogQueue = new LinkedList<>();
        int[][] map = new int[R][C];

        for (int r = 0; r < R; r++) {
            String s = br.readLine();
            for (int c = 0; c < C; c++) {
                char value = s.charAt(c);

                if (value == '*') {
                    waterQueue.add(new Node(r, c, 0));
                    continue;
                }

                if (value == 'S') {
                    hedgeHogQueue.add(new Node(r, c, 0));
                    map[r][c] = EMPTY;
                    continue;
                }

                if (value == '.') {
                    map[r][c] = EMPTY;
                    continue;
                }

                if (value == 'X') {
                    map[r][c] = STONE;
                    continue;
                }

                if (value == 'D') {
                    map[r][c] = CAVE;
                }
            }
        }

        while (!waterQueue.isEmpty()) {
            Node water = waterQueue.poll();
            map[water.row][water.col] = water.time;
            int nextTime = water.time + 1;

            for (int[] direction : DIRECTION) {
                int nextRow = water.row + direction[0];
                int nextCol = water.col + direction[1];

                if (!isInBoundary(nextRow, nextCol)) {
                    continue;
                }

                if (map[nextRow][nextCol] != EMPTY) {
                    continue;
                }

                map[nextRow][nextCol] = nextTime;
                waterQueue.add(new Node(nextRow, nextCol, nextTime));
            }
        }

        while (!hedgeHogQueue.isEmpty()) {
            Node hedgeHog = hedgeHogQueue.poll();
            int nextTime = hedgeHog.time + 1;

            for (int[] direction : DIRECTION) {
                int nextRow = hedgeHog.row + direction[0];
                int nextCol = hedgeHog.col + direction[1];

                if (!isInBoundary(nextRow, nextCol)) {
                    continue;
                }

                if (map[nextRow][nextCol] == VISIT) {
                    continue;
                }

                if (map[nextRow][nextCol] == CAVE) {
                    System.out.print(nextTime);
                    return;
                }

                if(map[nextRow][nextCol] == STONE){
                    continue;
                }

                if (0 <= map[nextRow][nextCol] && map[nextRow][nextCol] <= nextTime) {
                    continue;
                }

                map[nextRow][nextCol] = VISIT;
                hedgeHogQueue.add(new Node(nextRow, nextCol, nextTime));
            }
        }

        System.out.print("KAKTUS");
    }

    private static boolean isInBoundary(int row, int col) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }
}