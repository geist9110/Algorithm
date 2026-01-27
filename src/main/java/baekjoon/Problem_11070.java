package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_11070 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            int M = Integer.parseInt(st.nextToken());

            long[] score = new long[N + 1];
            long[] concede = new long[N + 1];

            for (int i = 0; i < M; i++) {
                st = new StringTokenizer(br.readLine());

                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());

                long p = Long.parseLong(st.nextToken());
                long q = Long.parseLong(st.nextToken());

                score[a] += p;
                concede[b] += p;
                score[b] += q;
                concede[a] += q;
            }

            long minExpectation = Long.MAX_VALUE;
            long maxExpectation = Long.MIN_VALUE;

            for (int i = 1; i <= N; i++) {
                long expectation;
                if (score[i] == 0 && concede[i] == 0) {
                    expectation = 0;
                } else {
                    expectation = calculateExpectation(score[i], concede[i]);
                }

                minExpectation = Math.min(minExpectation, expectation);
                maxExpectation = Math.max(maxExpectation, expectation);
            }

            sb.append(maxExpectation).append('\n')
                    .append(minExpectation).append('\n');
        }

        System.out.print(sb);
    }

    private static long calculateExpectation(long score, long concede) {
        return (score * score * 1000) / (score * score + concede * concede);
    }

}
