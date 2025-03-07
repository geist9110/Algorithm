package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_14503 implements ProblemInterface {

    // 북 동 남 서
    private static final int[][] DIRECTION = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    private static final int DIRTY = 0, CLEAN = -1, WALL = 1;

    private static int[][] map;
    private static int N, M;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int r = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());

        map = new int[N][M];
        for (int row = 0; row < N; row++) {
            st = new StringTokenizer(br.readLine());
            for (int col = 0; col < M; col++) {
                map[row][col] = Integer.parseInt(st.nextToken());;
            }
        }

        int result = 0;
        while (true) {
            if (map[r][c] == DIRTY) {
                map[r][c] = CLEAN;
                result++;
            }

            boolean hasDirtyRoom = false;
            for (int[] direction : DIRECTION) {
                int nextRow = r + direction[0];
                int nextCol = c + direction[1];
                if (isInBound(nextRow, nextCol) && map[nextRow][nextCol] == DIRTY) {
                    hasDirtyRoom = true;
                    break;
                }
            }

            if (!hasDirtyRoom) {
                int[] backwardDirection = DIRECTION[(d + 2) % 4];
                int backwardRow = r + backwardDirection[0];
                int backwardCol = c + backwardDirection[1];
                if (isInBound(backwardRow, backwardCol)) {
                    r = backwardRow;
                    c = backwardCol;
                    continue;
                }
                break;
            }

            d = (d + 3) % 4;
            int[] nextDirection = DIRECTION[d];
            int nextRow = r + nextDirection[0];
            int nextCol = c + nextDirection[1];
            if (isInBound(nextRow, nextCol) && map[nextRow][nextCol] == DIRTY) {
                r = nextRow;
                c = nextCol;
            }
        }
        System.out.print(result);
    }

    private static boolean isInBound(int row, int col) {
        return row >= 0 && row < N && col >= 0 && col < M && map[row][col] != WALL;
    }
}
