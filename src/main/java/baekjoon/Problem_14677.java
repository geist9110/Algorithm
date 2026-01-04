package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Map;

import baekjoon.config.ProblemInterface;

public class Problem_14677 implements ProblemInterface {

    private static int N;
    private static int[] medicines;
    private static int[][] dp;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        String S = br.readLine();
        int length = 3 * N;

        medicines = new int[length];
        Map<Character, Integer> map = Map.of(
                'B', 0,
                'L', 1,
                'D', 2);
        for (int i = 0; i < length; i++) {
            medicines[i] = map.get(S.charAt(i));
        }

        dp = new int[length + 1][length + 1];
        for (int i = 0; i <= length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.print(dfs(0, 0));
    }

    private static int dfs(int left, int right) {
        if (left + right == 3 * N) {
            return 0;
        }

        if (dp[left][right] != -1) {
            return dp[left][right];
        }

        int currentTarget = (left + right) % 3;
        int max = 0;

        if (medicines[left] == currentTarget) {
            max = Math.max(max, dfs(left + 1, right) + 1);
        }

        int rightIndex = 3 * N - right - 1;
        if (medicines[rightIndex] == currentTarget) {
            max = Math.max(max, dfs(left, right + 1) + 1);
        }

        return dp[left][right] = max;
    }

}
