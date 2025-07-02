package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2636 implements ProblemInterface {

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    private static final int CHEESE = 1;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[][] map = new int[H][W];
        int cheeseCount = 0;
        for (int i = 0; i < H; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < W; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] == 1) {
                    cheeseCount++;
                }
            }
        }

        int time = 0;
        while (true) {
            time++;
            Queue<Point> queue = new LinkedList<>();
            queue.add(new Point(0, 0));
            int deletedCheeseCount = 0;
            while (!queue.isEmpty()) {
                Point p = queue.poll();
                for (int[] direction : DIRECTIONS) {
                    int nextRow = p.x + direction[0];
                    int nextCol = p.y + direction[1];

                    if (nextRow < 0 || nextRow >= H || nextCol < 0 || nextCol >= W) {
                        continue;
                    }

                    if (map[nextRow][nextCol] == -time) {
                        continue;
                    }

                    if (map[nextRow][nextCol] == CHEESE) {
                        map[nextRow][nextCol] = -time;
                        deletedCheeseCount++;
                        continue;
                    }
                    queue.add(new Point(nextRow, nextCol));
                    map[nextRow][nextCol] = -time;
                }
            }

            if (cheeseCount == deletedCheeseCount) {
                break;
            }
            cheeseCount -= deletedCheeseCount;
        }

        StringBuilder sb = new StringBuilder();
        sb.append(time).append("\n").append(cheeseCount);
        System.out.println(sb);
    }

}
