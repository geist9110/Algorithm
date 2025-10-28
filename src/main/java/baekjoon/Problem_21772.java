package baekjoon;

import baekjoon.config.ProblemInterface;
import java.awt.Point;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_21772 implements ProblemInterface {

    private static final int[][] DIRECTIONS = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    private static char[][] map;
    private static int T;
    private static int result;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());

        map = new char[R][C];
        Point start = new Point();
        for (int r = 0; r < R; r++) {
            String s = br.readLine();
            for (int c = 0; c < C; c++) {
                map[r][c] = s.charAt(c);

                if (map[r][c] == 'G') {
                    start = new Point(r, c);
                }
            }
        }
        result = 0;
        dfs(start, 0, 0);
        System.out.print(result);
    }

    private static void dfs(Point current, int depth, int sweetPotato) {
        if (depth == T) {
            result = Math.max(result, sweetPotato);
            return;
        }

        for (int[] direction : DIRECTIONS) {
            Point next = new Point(current.x + direction[0], current.y + direction[1]);
            if (next.x < 0 || next.x >= map.length || next.y < 0 || next.y >= map[0].length) {
                continue;
            }

            if (map[next.x][next.y] == '#') {
                continue;
            }

            if (map[next.x][next.y] == 'S') {
                map[next.x][next.y] = '.';
                dfs(next, depth + 1, sweetPotato + 1);
                map[next.x][next.y] = 'S';
                continue;
            }
            dfs(next, depth + 1, sweetPotato);
        }
    }
}
