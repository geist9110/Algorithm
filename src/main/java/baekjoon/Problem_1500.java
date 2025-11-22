package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_1500 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long S = Long.parseLong(st.nextToken());
        long K = Long.parseLong(st.nextToken());

        long quotient = S / K;
        long mod = S % K;

        long result = 1;
        for (long i = K - mod; i > 0; i--) {
            result *= quotient;
        }
        quotient++;
        for (long i = mod; i > 0; i--) {
            result *= quotient;
        }

        System.out.print(result);
    }

}
