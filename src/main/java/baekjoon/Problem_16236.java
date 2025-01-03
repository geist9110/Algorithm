package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_16236 implements ProblemInterface {

    private static final int BABY_SHARK = 9;
    private static final int[][] DIRECTIONS = {{-1, 0}, {0, -1}, {0, 1}, {1, 0}};

    private static int N;
    private static int[][] map;

    private static class Point {

        int row, col;
        int distance;

        public Point(int row, int col, int distance) {
            this.row = row;
            this.col = col;
            this.distance = distance;
        }

        public Point[] nextPoints() {
            return Arrays.stream(DIRECTIONS)
                .map(direction -> new Point(row + direction[0], col + direction[1], distance + 1))
                .toArray(Point[]::new);
        }

        public boolean compare(Point p) {
            return Comparator
                .comparingInt((Point point) -> point.distance)
                .thenComparingInt(point -> point.row)
                .thenComparingInt(point -> point.col)
                .compare(this, p) < 0;
        }
    }

    private static class Shark extends Point {

        int eatFishCount, size;

        public Shark(int row, int col, int eatFishCount, int size) {
            super(row, col, 0);
            this.eatFishCount = eatFishCount;
            this.size = size;
        }

        public void eatFish(Point fishPoint) {
            eatFishCount++;
            if (eatFishCount == size) {
                size++;
                eatFishCount = 0;
            }
            map[fishPoint.row][fishPoint.col] = 0;
            row = fishPoint.row;
            col = fishPoint.col;
        }

        public Point findCatchableFishes() {
            Queue<Point> queue = new LinkedList<>();
            Point fishPoint = null;
            boolean[][] visit = new boolean[N][N];
            queue.add(this);
            visit[row][col] = true;

            while (!queue.isEmpty()) {
                for (Point nextPoint : queue.poll().nextPoints()) {
                    if (isMovable(nextPoint, visit)) {
                        continue;
                    }

                    visit[nextPoint.row][nextPoint.col] = true;
                    queue.add(nextPoint);

                    if (!isCatchable(nextPoint)) {
                        continue;
                    }

                    if (fishPoint == null || nextPoint.compare(fishPoint)) {
                        fishPoint = nextPoint;
                    }
                }
            }

            return fishPoint;
        }

        private boolean isMovable(Point point, boolean[][] visit) {
            return !isInBound(point.row, point.col)
                || visit[point.row][point.col]
                || map[point.row][point.col] > size;
        }

        private boolean isCatchable(Point point) {
            return map[point.row][point.col] < size
                && map[point.row][point.col] != 0;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        Shark babyShark = new Shark(0, 0, 0, 2);

        for (int row = 0; row < N; row++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int col = 0; col < N; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());

                if (map[row][col] == BABY_SHARK) {
                    babyShark.row = row;
                    babyShark.col = col;
                    map[row][col] = 0;
                }
            }
        }

        int time = 0;
        while (true) {
            Point fish = babyShark.findCatchableFishes();

            if (fish == null) {
                break;
            }

            babyShark.eatFish(fish);
            time += fish.distance;
        }

        System.out.print(time);
    }

    private static boolean isInBound(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < N;
    }

}
