package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_14719 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int H = Integer.parseInt(st.nextToken());
        int W = Integer.parseInt(st.nextToken());

        int[] map = new int[W];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < W; i++) {
            map[i] = Integer.parseInt(st.nextToken());
        }

        int[] leftMax = new int[W];
        int[] rightMax = new int[W];

        for (int i = 1; i < W; i++) {
            if (map[i] <= map[i - 1] || map[i] <= leftMax[i - 1]) {
                leftMax[i] = Math.max(leftMax[i - 1], map[i - 1]);
            }
        }

        for (int i = W - 2; i >= 0; i--) {
            if (map[i] <= map[i + 1] || map[i] <= rightMax[i + 1]) {
                rightMax[i] = Math.max(rightMax[i + 1], map[i + 1]);
            }
        }

        int result = 0;
        for (int i = 0; i < W; i++) {
            if (leftMax[i] == 0 || rightMax[i] == 0) {
                continue;
            }
            result += Math.min(leftMax[i], rightMax[i]) - map[i];
        }

        System.out.print(result);
    }
}
