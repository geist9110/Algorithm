package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2146 implements ProblemInterface {

    private static int N;
    private static int ISLAND_INDEX = 0;

    private static final int OCEAN = -2;
    private static final int UNKNOWN_ISLAND = -1;
    private static final int[][] DIRECTION = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[][] map = new int[N][N];
        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken()) - 2;
            }
        }

        List<List<Point>> islands = new ArrayList<>();

        for (int row = 0; row < N; row++) {
            for (int col = 0; col < N; col++) {
                if (map[row][col] != UNKNOWN_ISLAND || map[row][col] == OCEAN) {
                    continue;
                }

                List<Point> currentIsland = new ArrayList<>();
                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(row, col));
                while (!queue.isEmpty()) {
                    boolean oceanFound = false;
                    Point current = queue.poll();

                    for (int[] direction : DIRECTION) {
                        int nextX = current.x + direction[0];
                        int nextY = current.y + direction[1];

                        if (!isInBoundary(nextX, nextY)) {
                            continue;
                        }

                        if (map[nextX][nextY] == OCEAN) {
                            oceanFound = true;
                            continue;
                        }

                        if (map[nextX][nextY] != UNKNOWN_ISLAND) {
                            continue;
                        }

                        queue.add(new Point(nextX, nextY));
                        map[nextX][nextY] = ISLAND_INDEX;
                    }

                    if (oceanFound) {
                        currentIsland.add(current);
                    }

                }
                ISLAND_INDEX++;
                islands.add(currentIsland);
            }
        }

        int result = Integer.MAX_VALUE;
        for (int i = 0; i < islands.size(); i++) {
            for (int j = i + 1; j < islands.size(); j++) {
                for (Point point : islands.get(i)) {
                    for (Point point2 : islands.get(j)) {
                        result = Math.min(result,
                            Math.abs(point.x - point2.x) + Math.abs(point.y - point2.y) - 1);
                    }
                }
            }
        }

        System.out.println(result);
    }

    private static boolean isInBoundary(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }
}
