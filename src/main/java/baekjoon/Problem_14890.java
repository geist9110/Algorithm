package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14890 implements ProblemInterface {

    private static int[][] map;
    private static int N;
    private static int L;

    private static final int ROW = 1;
    private static final int COL = 2;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());

        map = new int[N][N];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int result = 0;

        for (int i = 0; i < N; i++) {
            if (isArrive(ROW, i)) {
                result++;
            }

            if (isArrive(COL, i)) {
                result++;
            }
        }

        System.out.print(result);
    }

    private static boolean isArrive(int direction, int n) {
        int[] path = new int[N];

        if (direction == ROW) {
            for (int i = 0; i < N; i++) {
                path[i] = map[n][i];
            }
        } else {
            for (int i = 0; i < N; i++) {
                path[i] = map[i][n];
            }
        }

        int height = path[0];
        int heightCount = 1;
        for (int i = 1; i < N; i++) {
            if (path[i] == height) {
                heightCount++;
                continue;
            }

            if (path[i] == height + 1 && heightCount >= L) {
                height++;
                heightCount = 1;
                continue;
            }

            if (path[i] == height - 1 && i + L <= N) {
                for (int l = 1; l < L; l++) {
                    if (path[i] != path[i + l]) {
                        return false;
                    }
                }

                i += L - 1;
                height--;
                heightCount = 0;
                continue;
            }

            return false;
        }

        return true;
    }
}
