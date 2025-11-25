package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_14926 implements ProblemInterface {

    private static int N;
    private static boolean[][] visit;
    private static int[] degree;
    private static StringBuilder sb;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();

        N = Integer.parseInt(br.readLine());
        visit = new boolean[N + 1][N + 1];
        degree = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            degree[i] = N - 1;
        }
        dfs(1);
        sb.append("a1");
        System.out.print(sb);
    }

    private static void dfs(int currentIndex) {
        sb.append("a").append(currentIndex).append(" ");
        for (int i = 1; i <= N; i++) {
            if (i == currentIndex || visit[currentIndex][i] || degree[i] == 1) {
                continue;
            }

            visit[currentIndex][i] = true;
            visit[i][currentIndex] = true;
            degree[i]--;
            degree[currentIndex]--;

            dfs(i);
            return;
        }
    }

}
