package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_14940 implements ProblemInterface {

    private static final int TARGET = 2;
    private static final int LAND_CAN_GO = 1;
    private static final int LAND_CAN_NOT_GO = 0;

    private static final int VISITED = 0;
    private static final int NOT_VISITED = -1;

    private static class Point {

        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }


    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] map = new int[n][m];
        for (int i = 0; i < n; i++) {
            Arrays.fill(map[i], NOT_VISITED);
        }

        Queue<Point> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                int land = Integer.parseInt(st.nextToken());

                if (land == LAND_CAN_GO) {
                    map[i][j] = NOT_VISITED;
                    continue;
                }

                if (land == LAND_CAN_NOT_GO) {
                    map[i][j] = VISITED;
                    continue;
                }

                if (land == TARGET) {
                    map[i][j] = VISITED;
                    queue.add(new Point(i, j));
                }
            }
        }

        while (!queue.isEmpty()) {
            Point p = queue.poll();

            if (p.x - 1 >= 0 && map[p.x - 1][p.y] == NOT_VISITED) {
                map[p.x - 1][p.y] = map[p.x][p.y] + 1;
                queue.add(new Point(p.x - 1, p.y));
            }

            if (p.x + 1 < n && map[p.x + 1][p.y] == NOT_VISITED) {
                map[p.x + 1][p.y] = map[p.x][p.y] + 1;
                queue.add(new Point(p.x + 1, p.y));
            }

            if (p.y - 1 >= 0 && map[p.x][p.y - 1] == NOT_VISITED) {
                map[p.x][p.y - 1] = map[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y - 1));
            }

            if (p.y + 1 < m && map[p.x][p.y + 1] == NOT_VISITED) {
                map[p.x][p.y + 1] = map[p.x][p.y] + 1;
                queue.add(new Point(p.x, p.y + 1));
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sb.append(map[i][j]).append(" ");
            }
            bw.write(sb.toString().trim() + "\n");
            sb.setLength(0);
        }
        bw.flush();
    }
}
