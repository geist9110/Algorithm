package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2468 implements ProblemInterface {

    private static int N;

    private static final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        int maxHeight = 0;
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                maxHeight = Math.max(maxHeight, map[i][j]);
            }
        }

        int result = 1;
        for (int height = 1; height <= maxHeight; height++) {
            boolean[][] visited = new boolean[N][N];

            Queue<Point> queue = new LinkedList<>();
            int heightPerResult = 0;

            for (int row = 0; row < N; row++) {
                for (int col = 0; col < N; col++) {
                    if (visited[row][col] || map[row][col] <= height) {
                        continue;
                    }

                    heightPerResult++;

                    queue.add(new Point(row, col));
                    visited[row][col] = true;

                    while (!queue.isEmpty()) {
                        Point point = queue.poll();

                        for (int[] direction : DIRECTION) {
                            Point nextPoint = new Point(point.x + direction[0],
                                point.y + direction[1]);

                            if (!isInBoundary(nextPoint) || visited[nextPoint.x][nextPoint.y]) {
                                continue;
                            }

                            if (map[nextPoint.x][nextPoint.y] <= height) {
                                continue;
                            }

                            queue.add(nextPoint);
                            visited[nextPoint.x][nextPoint.y] = true;
                        }
                    }

                    result = Math.max(result, heightPerResult);
                }
            }

        }
        System.out.print(result);
    }

    private static boolean isInBoundary(Point p) {
        return p.x >= 0 && p.x < N && p.y >= 0 && p.y < N;
    }
}
