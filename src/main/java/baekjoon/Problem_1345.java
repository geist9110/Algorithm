package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1345 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        double A0 = Double.parseDouble(st.nextToken());

        if (N == 0) {
            System.out.print(0);
            return;
        }

        st = new StringTokenizer(br.readLine());
        int[] S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        double max = 0.0;
        double min = Double.MAX_VALUE;

        for (int i = 0; i < N; i++) {
            max = Math.max(max, (S[i] - A0) / (i + 1));
            min = Math.min(min, (S[i] + 1 - A0) / (i + 1));
        }

        if (max < min) {
            System.out.printf("%.9f", max);
            return;
        }
        System.out.print(-1);
    }

}
