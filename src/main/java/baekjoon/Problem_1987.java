package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_1987 implements ProblemInterface {

    private static int[][] board;
    private static boolean[] visit;
    private static int result;
    private static int R, C;
    private static final int[][] direction = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        board = new int[R][C];
        visit = new boolean[26];

        for (int row = 0; row < R; row++) {
            char[] line = br.readLine().toCharArray();
            for (int col = 0; col < C; col++) {
                board[row][col] = line[col] - 'A';
            }
        }

        result = 0;
        dfs(0, 0, 1);
        System.out.print(result);
    }

    private static void dfs(int row, int col, int depth) {
        visit[board[row][col]] = true;
        result = Math.max(result, depth);
        for (int[] dir : direction) {
            int nextRow = row + dir[0];
            int nextCol = col + dir[1];

            if (nextRow < 0 || nextRow >= R
                || nextCol < 0 || nextCol >= C
                || visit[board[nextRow][nextCol]]
            ) {
                continue;
            }

            dfs(nextRow, nextCol, depth + 1);
        }

        visit[board[row][col]] = false;
    }
}
