package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_4963 implements ProblemInterface {

    private static final int LAND = 1;
    private static final int SEA = 0;

    private static final int[][] DIRECTION =
            {{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {-1, 1}, {-1, -1}};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int w = Integer.parseInt(st.nextToken());
            int h = Integer.parseInt(st.nextToken());
            if (w == 0 && h == 0) {
                break;
            }

            int[][] map = new int[h][w];
            for (int i = 0; i < h; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < w; j++) {
                    map[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            int count = 0;
            for (int row = 0; row < h; row++) {
                for (int col = 0; col < w; col++) {
                    if (map[row][col] == SEA) {
                        continue;
                    }

                    Queue<Point> queue = new LinkedList<>();
                    queue.add(new Point(row, col));
                    while (!queue.isEmpty()) {
                        Point p = queue.poll();

                        for (int[] direction : DIRECTION) {
                            int nextRow = p.x + direction[0];
                            int nextCol = p.y + direction[1];
                            if (nextRow < 0 || nextRow >= h || nextCol < 0 || nextCol >= w) {
                                continue;
                            }

                            if (map[nextRow][nextCol] == SEA) {
                                continue;
                            }

                            map[nextRow][nextCol] = SEA;
                            queue.add(new Point(nextRow, nextCol));
                        }
                    }
                    count++;
                }
            }
            sb.append(count).append("\n");
        }
        System.out.print(sb);
    }

}
