package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_13172 implements ProblemInterface {

    private static final long PRIME_NUMBER = 1_000_000_007;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        StringTokenizer st;

        long result = 0;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            long N = Long.parseLong(st.nextToken());
            long S = Long.parseLong(st.nextToken());
            long NInverse = calculateNInverse(N, PRIME_NUMBER - 2);
            result += (S * NInverse) % PRIME_NUMBER;
            result %= PRIME_NUMBER;
        }

        System.out.print(result);
    }

    private static long calculateNInverse(long N, long exponential) {
        if (exponential == 1) {
            return N;
        }

        long result = calculateNInverse(N, exponential / 2);
        result = result * result % PRIME_NUMBER;

        if (exponential % 2 == 1) {
            result = N * result % PRIME_NUMBER;
        }

        return result;
    }

}
