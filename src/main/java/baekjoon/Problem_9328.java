package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_9328 implements ProblemInterface {

    private static final int EMPTY = '.';
    private static final int WALL = '*';
    private static final int DOCUMENT = '$';

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    private static int h;
    private static int w;
    private static int[][] map;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            h = Integer.parseInt(st.nextToken());
            w = Integer.parseInt(st.nextToken());

            map = new int[h + 2][w + 2];

            Arrays.fill(map[0], EMPTY);
            Arrays.fill(map[h + 1], EMPTY);
            for (int row = 1; row <= h; row++) {
                String line = br.readLine();
                Arrays.fill(map[row], EMPTY);
                for (int col = 0; col < w; col++) {
                    map[row][col + 1] = line.charAt(col);
                }
            }

            boolean[] key = new boolean[26];
            String s = br.readLine();

            if (!s.equals("0")) {
                for (int i = 0; i < s.length(); i++) {
                    key[s.charAt(i) - 'a'] = true;
                }
            }

            Queue<Point> queue = new LinkedList<>();
            Map<Integer, LinkedList<Point>> door = new HashMap<>();
            for (int i = 'A'; i <= 'Z'; i++) {
                door.put(i, new LinkedList<>());
            }

            queue.add(new Point(0, 0));
            map[0][0] = WALL;

            int result = 0;

            while (!queue.isEmpty()) {
                Point p = queue.poll();

                for (int[] direction : DIRECTIONS) {
                    int nextX = p.x + direction[0];
                    int nextY = p.y + direction[1];

                    if (!isInBoundary(new Point(nextX, nextY))) {
                        continue;
                    }

                    if (map[nextX][nextY] == WALL) {
                        continue;
                    }

                    if (map[nextX][nextY] == DOCUMENT) {
                        result++;
                    }

                    if (isDoor(map[nextX][nextY]) && !key[map[nextX][nextY] - 'A']) {
                        door.get(map[nextX][nextY]).add(new Point(nextX, nextY));
                        continue;
                    }

                    if (isKey(map[nextX][nextY])) {
                        key[map[nextX][nextY] - 'a'] = true;
                        for (Point doorPoint : door.get(map[nextX][nextY] - 32)) {
                            queue.add(doorPoint);
                            map[doorPoint.x][doorPoint.y] = WALL;
                        }
                    }

                    map[nextX][nextY] = WALL;
                    queue.add(new Point(nextX, nextY));
                }
            }

            System.out.println(result);
        }
    }

    private static boolean isInBoundary(Point p) {
        return p.x >= 0 && p.x < map.length && p.y >= 0 && p.y < map[0].length;
    }

    private static boolean isDoor(int value) {
        return value >= 'A' && value <= 'Z';
    }

    private static boolean isKey(int value) {
        return value >= 'a' && value <= 'z';
    }
}
