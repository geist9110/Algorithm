package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_14936 implements ProblemInterface {

    private static final int MAX_VALUE = 1_000_000;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int r = Integer.parseInt(st.nextToken());

        int[] items = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            items[i] = Integer.parseInt(st.nextToken());
        }

        int[][] map = new int[n][n];
        for (int row = 0; row < n; row++) {
            Arrays.fill(map[row], MAX_VALUE);
            map[row][row] = 0;
        }

        for (int i = 0; i < r; i++) {
            st = new StringTokenizer(br.readLine());
            int depart = Integer.parseInt(st.nextToken()) - 1;
            int arrive = Integer.parseInt(st.nextToken()) - 1;
            int distance = Integer.parseInt(st.nextToken());
            map[depart][arrive] = distance;
            map[arrive][depart] = distance;
        }

        // 워셜 플로이드
        for (int via = 0; via < n; via++) {
            for (int depart = 0; depart < n; depart++) {
                for (int arrive = 0; arrive < n; arrive++) {
                    map[depart][arrive] = Math.min(
                        map[depart][arrive],
                        map[depart][via] + map[via][arrive]
                    );
                }
            }
        }

        int result = 0;
        for (int dropPoint = 0; dropPoint < n; dropPoint++) {
            boolean[] reachablePointList = new boolean[n];
            for (int i = 0; i < n; i++) {
                if (map[dropPoint][i] <= m) {
                    reachablePointList[i] = true;
                }
            }

            int itemCount = 0;
            for (int i = 0; i < n; i++) {
                if (reachablePointList[i]) {
                    itemCount += items[i];
                }
            }
            result = Math.max(result, itemCount);
        }

        System.out.print(result);
    }
}
