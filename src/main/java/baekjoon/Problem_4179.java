package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_4179 implements ProblemInterface {

    private static int R;
    private static int C;

    private static final int WALL = -1;
    private static final int EMPTY = -2;
    private static final int[][] DIRECTION = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

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

        int[][] map = new int[R][C];
        Queue<Node> fireQueue = new LinkedList<>();
        Queue<Node> jQueue = new LinkedList<>();

        for (int row = 0; row < R; row++) {
            String s = br.readLine();
            for (int col = 0; col < C; col++) {
                char c = s.charAt(col);
                if (c == '#') {
                    map[row][col] = WALL;
                    continue;
                }

                if (c == 'F') {
                    fireQueue.add(new Node(row, col, 0));
                    continue;
                }

                if (c == 'J') {
                    jQueue.add(new Node(row, col, 0));
                }

                map[row][col] = EMPTY;
            }
        }

        while (!fireQueue.isEmpty()) {
            Node fire = fireQueue.poll();

            for (int[] direction : DIRECTION) {
                int nextRow = fire.row + direction[0];
                int nextCol = fire.col + direction[1];

                if (!isInBoundary(nextRow, nextCol) || map[nextRow][nextCol] != EMPTY) {
                    continue;
                }

                map[nextRow][nextCol] = fire.time + 1;
                fireQueue.add(new Node(nextRow, nextCol, map[nextRow][nextCol]));
            }
        }

        boolean[][] visit = new boolean[R][C];
        visit[jQueue.peek().row][jQueue.peek().col] = true;

        while (!jQueue.isEmpty()) {
            Node j = jQueue.poll();

            for (int[] direction : DIRECTION) {
                int nextRow = j.row + direction[0];
                int nextCol = j.col + direction[1];
                int nextTime = j.time + 1;

                if (!isInBoundary(nextRow, nextCol)) {
                    System.out.print(nextTime);
                    return;
                }

                if (visit[nextRow][nextCol] || map[nextRow][nextCol] == WALL) {
                    continue;
                }

                if (0 <= map[nextRow][nextCol] && map[nextRow][nextCol] <= nextTime) {
                    continue;
                }

                visit[nextRow][nextCol] = true;
                jQueue.add(new Node(nextRow, nextCol, nextTime));
            }
        }

        System.out.println("IMPOSSIBLE");
    }

    private static boolean isInBoundary(int row, int col) {
        return row >= 0 && row < R && col >= 0 && col < C;
    }
}
