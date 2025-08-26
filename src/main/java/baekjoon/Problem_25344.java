package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_25344 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        long lcm = Long.parseLong(st.nextToken());

        for (int i = 0; i < N - 3; i++) {
            long nextCycle = Long.parseLong(st.nextToken());
            lcm = lcm * nextCycle / getGCD(lcm, nextCycle);
        }

        System.out.print(lcm);
    }

    private static long getGCD(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGCD(b, a % b);
    }
}
