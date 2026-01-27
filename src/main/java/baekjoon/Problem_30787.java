package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_30787 implements ProblemInterface {

    private static final long MOD = 1_000_000_007;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        long N = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long result = 0;
        long nodeCount = 1;
        for (long level = 0; level <= N - K; level++) {
            result = (result + nodeCount) % MOD;

            if (level >= K) {
                result = (result + (nodeCount * 2) % MOD) % MOD;
            }

            nodeCount = (nodeCount * 2) % MOD;
        }

        System.out.print(result);

    }

}
