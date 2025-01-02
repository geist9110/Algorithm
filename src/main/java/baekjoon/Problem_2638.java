package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Problem_2638 implements ProblemInterface {

    // 상하좌우
    private static final int[][] DIRECTIONS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    private static final int INSIDE_AIR = 0, CHEESE = 1, OUTSIDE_AIR = 2;

    private static int N, M;
    private static int[][] cheeseMap;
    private static Queue<Point> cheeseQueue;
    private static Queue<Point> meltableCheeseQueue;

    private static class Point {

        int row, col;

        public Point(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        cheeseMap = new int[N][M];
        cheeseQueue = new LinkedList<>();
        meltableCheeseQueue = new LinkedList<>();

        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                cheeseMap[row][col] = Integer.parseInt(st.nextToken());
                if (cheeseMap[row][col] == CHEESE) {
                    cheeseQueue.add(new Point(row, col));
                }
            }
        }
        cheeseMap[0][0] = OUTSIDE_AIR;

        int time = 0;
        while (!cheeseQueue.isEmpty()) {
            time++;
            expandOutsideAir();
            checkMeltableCheese();
            meltCheese();
        }

        System.out.print(time);
    }

    private static void checkMeltableCheese() {
        for (
            int remainCheeseCount = cheeseQueue.size();
            remainCheeseCount > 0 && !cheeseQueue.isEmpty();
            remainCheeseCount--
        ) {
            Point cheese = cheeseQueue.poll();
            if (countNearOutsideAir(cheese.row, cheese.col) >= 2) {
                meltableCheeseQueue.add(cheese);
                continue;
            }
            cheeseQueue.add(cheese);
        }
    }

    private static void meltCheese() {
        while (!meltableCheeseQueue.isEmpty()) {
            Point cheese = meltableCheeseQueue.poll();
            cheeseMap[cheese.row][cheese.col] = OUTSIDE_AIR;
        }
    }

    private static void expandOutsideAir() {
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (cheeseMap[row][col] != INSIDE_AIR) {
                    continue;
                }

                if (!hasNearOutsideAir(row, col)) {
                    continue;
                }

                Queue<Point> queue = new LinkedList<>();
                queue.add(new Point(row, col));
                cheeseMap[row][col] = OUTSIDE_AIR;
                while (!queue.isEmpty()) {
                    Point p = queue.poll();
                    for (int[] direction : DIRECTIONS) {
                        int nextRow = p.row + direction[0];
                        int nextCol = p.col + direction[1];
                        if (isNotInBound(nextRow, nextCol)) {
                            continue;
                        }
                        if (cheeseMap[nextRow][nextCol] == INSIDE_AIR) {
                            queue.add(new Point(nextRow, nextCol));
                            cheeseMap[nextRow][nextCol] = OUTSIDE_AIR;
                        }
                    }
                }
            }
        }
    }

    private static boolean hasNearOutsideAir(int row, int col) {
        return countNearOutsideAir(row, col) > 0;
    }

    private static int countNearOutsideAir(int row, int col) {
        int count = 0;
        for (int[] direction : DIRECTIONS) {
            int nextRow = row + direction[0];
            int nextCol = col + direction[1];

            if (isNotInBound(nextRow, nextCol)) {
                continue;
            }

            if (cheeseMap[nextRow][nextCol] == OUTSIDE_AIR) {
                count++;
            }
        }
        return count;
    }

    private static boolean isNotInBound(int row, int col) {
        return row < 0 || row >= N || col < 0 || col >= M;
    }
}
