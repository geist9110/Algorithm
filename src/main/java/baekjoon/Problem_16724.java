package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_16724 implements ProblemInterface {

    private static int cycleIndex, safeZoneCount;
    private static char[][] map;
    private static int[][] visit;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        map = new char[N][M];
        visit = new int[N][M];
        for (int row = 0; row < N; row++) {
            map[row] = br.readLine().toCharArray();
        }

        safeZoneCount = 0;
        cycleIndex = 0;
        for (int row = 0; row < N; row++) {
            for (int col = 0; col < M; col++) {
                if (visit[row][col] == 0) {
                    cycleIndex++;
                    dfs(row, col);
                }
            }
        }

        System.out.print(safeZoneCount);
    }

    private static void dfs(int row, int col) {
        visit[row][col] = cycleIndex;

        if (map[row][col] == 'U') {
            row--;
        }

        if (map[row][col] == 'D') {
            row++;
        }

        if (map[row][col] == 'L') {
            col--;
        }

        if (map[row][col] == 'R') {
            col++;
        }

        if (visit[row][col] == cycleIndex) {
            safeZoneCount++;
            return;
        }

        if (visit[row][col] == 0) {
            dfs(row, col);
        }
    }
}
