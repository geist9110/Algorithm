package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_16948 implements ProblemInterface {

    private static final int[][] DIRECTIONS = { { -2, -1 }, { -2, 1 }, { 0, -2 }, { 0, 2 }, { 2, -1 }, { 2, 1 } };

    private static int N;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Point depart = new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        Point arrive = new Point(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken()));

        int[][] map = new int[N][N];
        boolean[][] visit = new boolean[N][N];
        Queue<Point> queue = new LinkedList<>();
        queue.add(depart);
        visit[depart.x][depart.y] = true;

        while (!queue.isEmpty()) {
            Point currentPoint = queue.poll();
            for (int[] direction : DIRECTIONS) {
                Point nextPoint = new Point(
                        currentPoint.x + direction[0],
                        currentPoint.y + direction[1]);

                if (!isInBoundary(nextPoint) || visit[nextPoint.x][nextPoint.y]) {
                    continue;
                }

                visit[nextPoint.x][nextPoint.y] = true;
                map[nextPoint.x][nextPoint.y] = map[currentPoint.x][currentPoint.y] + 1;
                queue.add(nextPoint);
            }
        }

        if (visit[arrive.x][arrive.y]) {
            System.out.print(map[arrive.x][arrive.y]);
            return;
        }
        System.out.print(-1);
    }

    private static boolean isInBoundary(Point p) {
        return p.x >= 0 && p.x < N && p.y >= 0 && p.y < N;
    }
}
