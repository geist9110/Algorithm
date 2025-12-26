package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_9765 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long[] c = new long[7];
        for (int i = 1; i <= 6; i++) {
            c[i] = Long.parseLong(st.nextToken());
        }
        long x2 = getGCD(c[1], c[5]);
        long x6 = getGCD(c[3], c[6]);

        StringBuilder sb = new StringBuilder();
        sb.append(c[1] / x2).append(" ")
                .append(x2).append(" ")
                .append(c[5] / x2).append(" ")
                .append(c[6] / x6).append(" ")
                .append(x6).append(" ")
                .append(c[3] / x6);

        System.out.print(sb);
    }

    private static long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }

}
