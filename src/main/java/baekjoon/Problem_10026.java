package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10026 implements ProblemInterface {

    private static int N;
    private static int[][] map;
    private static final int[][] DIRECTION = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    private static final int RED = 0;
    private static final int BLUE = 1;
    private static final int GREEN = 2;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                char c = s.charAt(j);
                if (c == 'R') {
                    map[i][j] = RED;
                    continue;
                }
                if (c == 'G') {
                    map[i][j] = GREEN;
                    continue;
                }
                map[i][j] = BLUE;
            }
        }

        int normal_cnt = solve(3);
        int abnormal_cnt = solve(2);
        System.out.println(normal_cnt + " " + abnormal_cnt);

    }

    private static int solve(int divisor) {
        int count = 0;
        boolean[][] visit = new boolean[N][N];
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visit[i][j]) {
                    dfs(i, j, divisor, visit);
                    count++;
                }
            }
        }
        return count;
    }

    private static void dfs(int x, int y, int divisor, boolean[][] visit) {
        visit[x][y] = true;
        int color = map[x][y] % divisor;
        for (int[] direction : DIRECTION) {
            int nextX = x + direction[0];
            int nextY = y + direction[1];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) {
                continue;
            }

            if (!visit[nextX][nextY] && map[nextX][nextY] % divisor == color) {
                dfs(nextX, nextY, divisor, visit);
            }
        }
    }
}
