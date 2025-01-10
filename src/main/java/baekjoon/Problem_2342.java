package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2342 implements ProblemInterface {

    private static List<Integer> moveList;
    private static int[][][] dp;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        moveList = new ArrayList<>();
        for (int nextMove = Integer.parseInt(st.nextToken()); st.hasMoreTokens()
                && nextMove != 0; nextMove = Integer.parseInt(st.nextToken())) {
            moveList.add(nextMove);
        }

        dp = new int[5][5][moveList.size()];
        for (int[][] innerDp : dp) {
            for (int[] innerInnerDp : innerDp) {
                Arrays.fill(innerInnerDp, -1);
            }
        }

        System.out.print(dfs(0, 0, 0));
    }

    private static int dfs(int left, int right, int index) {
        if (index == moveList.size()) {
            return 0;
        }

        if (dp[left][right][index] != -1) {
            return dp[left][right][index];
        }

        int leftMovePower = dfs(moveList.get(index), right, index + 1)
                + caculateMovePower(left, moveList.get(index));
        int rightMovePower = dfs(left, moveList.get(index), index + 1)
                + caculateMovePower(right, moveList.get(index));

        return dp[left][right][index] = Math.min(leftMovePower, rightMovePower);
    }

    private static int caculateMovePower(int depart, int arrive) {
        if (depart == arrive) {
            return 1;
        }

        if (depart == 0) {
            return 2;
        }

        // Counter Clockwise, Clockwise
        if ((depart + 3) % 4 == arrive % 4 || depart % 4 == (arrive - 1) % 4) {
            return 3;
        }

        return 4;
    }

}
