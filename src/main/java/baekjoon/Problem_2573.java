package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2573 implements ProblemInterface {

    private static int[][] map;
    private static final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static class Ice {

        Point location;
        int nearSeaCount;
        int index;

        public Ice(Point location, int nearSeaCount, int index) {
            this.location = location;
            this.nearSeaCount = nearSeaCount;
            this.index = index;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        Queue<Ice> meltIce = new LinkedList<>();
        while (true) {
            int index = 1;
            boolean[][] visited = new boolean[N][M];
            for (int i = 1; i < N - 1; i++) {
                for (int j = 1; j < M - 1; j++) {
                    if (visited[i][j] || map[i][j] == 0) {
                        continue;
                    }

                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(i, j));
                    meltIce.add(new Ice(queue.peek(), getNearSeaCount(queue.peek()), index));
                    visited[i][j] = true;
                    while (!queue.isEmpty()) {
                        Point point = queue.poll();

                        for (int[] direction : DIRECTION) {
                            int x = point.x + direction[0];
                            int y = point.y + direction[1];

                            if (visited[x][y] || map[x][y] == 0) {
                                continue;
                            }

                            Point p = new Point(x, y);
                            queue.add(p);
                            meltIce.add(new Ice(p, getNearSeaCount(p), index));
                            visited[x][y] = true;
                        }
                    }
                    index++;
                }
            }

            if (index > 2) {
                System.out.print(time);
                break;
            }

            if (meltIce.isEmpty()) {
                System.out.print(0);
                break;
            }

            time++;
            while (!meltIce.isEmpty()) {
                Ice ice = meltIce.poll();
                map[ice.location.x][ice.location.y] = Math.max(0,
                    map[ice.location.x][ice.location.y] - ice.nearSeaCount);
            }
        }

    }

    private static int getNearSeaCount(Point location) {
        int count = 0;
        for (int[] direction : DIRECTION) {
            if (map[location.x + direction[0]][location.y + direction[1]] == 0) {
                count++;
            }
        }
        return count;
    }
}
