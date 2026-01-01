package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_31834 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int S = Integer.parseInt(st.nextToken());
            int E = Integer.parseInt(st.nextToken());

            sb.append(getMinimumCost(N, S, E)).append("\n");
        }
        System.out.print(sb);
    }

    private static int getMinimumCost(int N, int S, int E) {
        int diff = Math.abs(S - E);
        if (diff == N - 1) {
            return 0;
        }

        if (diff == 1 || S == 1 || S == N) {
            return 1;
        }

        return 2;
    }

}
