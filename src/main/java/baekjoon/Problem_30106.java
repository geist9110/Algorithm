package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_30106 implements ProblemInterface {

    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static int N, M, K;
    private static int[][] map;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        boolean[][] visited = new boolean[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (visited[row][col]) {
                    continue;
                }

                count++;
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(row, col));
                visited[row][col] = true;
                while (!queue.isEmpty()) {
                    Point current = queue.poll();
                    for (int[] DIRECTION : DIRECTIONS) {
                        Point nextPoint = new Point(
                            current.x + DIRECTION[0],
                            current.y + DIRECTION[1]
                        );

                        if (!isInRange(nextPoint.x, nextPoint.y)
                            || visited[nextPoint.x][nextPoint.y]
                            || !isMovable(current, nextPoint)
                        ) {
                            continue;
                        }

                        queue.add(new Point(nextPoint.x, nextPoint.y));
                        visited[nextPoint.x][nextPoint.y] = true;
                    }
                }
            }
        }
        System.out.print(count);
    }

    private static boolean isInRange(int x, int y) {
        return x >= 0 && x < N && y >= 0 && y < M;
    }

    private static boolean isMovable(Point currentPoint, Point nextPoint) {
        return Math.abs(map[currentPoint.x][currentPoint.y] - map[nextPoint.x][nextPoint.y]) <= K;
    }
}
