package baekjoon;

import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_3109 implements ProblemInterface {

    private static final int[] DIRECTION = { 1, 0, -1 };

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        boolean[][] map = new boolean[R][C];
        for (int row = 0; row < R; row++) {
            String r = br.readLine();
            for (int col = 0; col < C; col++) {
                if (r.charAt(col) == '.') {
                    map[row][col] = true;
                }
            }
        }

        int result = 0;
        for (int row = 0; row < R; row++) {
            Stack<Point> stack = new Stack<>();
            stack.push(new Point(row, 0));
            dfs: while (!stack.isEmpty()) {
                Point currentLocation = stack.pop();
                map[currentLocation.x][currentLocation.y] = false;

                for (int direction : DIRECTION) {
                    int nextRow = currentLocation.x + direction;
                    int nextCol = currentLocation.y + 1;

                    if (nextRow >= 0 && nextRow < R && nextCol < C && map[nextRow][nextCol]) {
                        stack.push(new Point(nextRow, nextCol));
                    }

                    if (nextCol == C) {
                        result++;
                        break dfs;
                    }
                }
            }
        }

        System.out.print(result);
    }

}
