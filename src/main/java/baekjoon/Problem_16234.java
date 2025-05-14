package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_16234 implements ProblemInterface {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int days = 0;
        while (true) {
            boolean[][] visited = new boolean[N][N];
            boolean movedFlag = false;

            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (visited[i][j]) {
                        continue;
                    }

                    Queue<Point> uniteQueue = new LinkedList<>();
                    LinkedList<Point> unite = new LinkedList<>();

                    uniteQueue.add(new Point(i, j));
                    unite.add(new Point(i, j));
                    visited[i][j] = true;

                    while (!uniteQueue.isEmpty()) {
                        Point p = uniteQueue.poll();
                        for (int[] dir : DIRECTIONS) {
                            int x = p.x + dir[0];
                            int y = p.y + dir[1];

                            if (x < 0 || x >= N || y < 0 || y >= N || visited[x][y]) {
                                continue;
                            }

                            int diff = Math.abs(map[x][y] - map[p.x][p.y]);
                            if (diff < L || diff > R) {
                                continue;
                            }

                            visited[x][y] = true;
                            uniteQueue.add(new Point(x, y));
                            unite.add(new Point(x, y));
                        }
                    }

                    if (unite.size() == 1) {
                        continue;
                    }

                    movedFlag = true;
                    int sum = 0;
                    for (Point p : unite) {
                        sum += map[p.x][p.y];
                    }
                    int avg = sum / unite.size();

                    for (Point p : unite) {
                        map[p.x][p.y] = avg;
                    }

                }
            }

            if (!movedFlag) {
                break;
            }

            days++;
        }

        System.out.print(days);
    }
}
