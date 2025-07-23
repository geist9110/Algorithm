package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class Problem_30923 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        long result = 2 * N;
        long prevHeight = Long.parseLong(st.nextToken());
        result += 3 * prevHeight;
        for (int i = 1; i < N; i++) {
            long currentHeight = Long.parseLong(st.nextToken());
            result += Math.abs(prevHeight - currentHeight);
            result += 2 * currentHeight;
            prevHeight = currentHeight;
        }

        result += prevHeight;
        System.out.print(result);
    }
}
