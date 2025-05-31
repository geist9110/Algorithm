package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_15684 implements ProblemInterface {

    private static boolean[][] map;
    private static int N;
    private static int H;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new boolean[H][N];
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            map[a][b] = true;
        }

        for (int i = 0; i <= 3; i++) {
            if (dfs(i, -1)) {
                System.out.print(i);
                return;
            }
        }

        System.out.print(-1);
    }

    private static boolean isSatisfy() {
        for (int col = 0; col < N; col++) {
            int current = col;
            for (int row = 0; row < H; row++) {
                if (map[row][current]) {
                    current++;
                    continue;
                }

                if (current > 0 && map[row][current - 1]) {
                    current--;
                }
            }
            if (current != col) {
                return false;
            }
        }
        return true;
    }

    private static boolean dfs(int selectedCount, int lastSelectedIndex) {
        if (selectedCount == 0) {
            return isSatisfy();
        }

        for (int i = lastSelectedIndex + 1; i < (N - 1) * H; i++) {
            int row = i / (N - 1);
            int col = i % (N - 1);

            if (map[row][col]) {
                continue;
            }

            if (col + 1 < N && map[row][col + 1]) {
                continue;
            }

            if (col - 1 >= 0 && map[row][col - 1]) {
                continue;
            }

            map[row][col] = true;
            if (dfs(selectedCount - 1, i)) {
                return true;
            }
            map[row][col] = false;
        }

        return false;
    }
}
