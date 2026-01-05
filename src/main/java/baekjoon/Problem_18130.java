package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_18130 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        long Q = Integer.parseInt(st.nextToken());

        int index = 0;
        long minCost = Long.MAX_VALUE;
        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            long P = Long.parseLong(st.nextToken());
            long K = Long.parseLong(st.nextToken());
            long C = Long.parseLong(st.nextToken());

            long cost = calculateCost(P, K, C, Q);
            if (cost < minCost) {
                minCost = cost;
                index = i;
            }
        }

        System.out.println(index + " " + minCost);
    }

    private static long calculateCost(long P, long K, long C, long Q) {
        long n = (Q - 1) / K;
        long cost = n * (n + 1) / 2;

        return P + C * cost;
    }

}
