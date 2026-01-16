package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_28138 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        long N = Long.parseLong(st.nextToken());
        long R = Long.parseLong(st.nextToken());

        Set<Long> candidates = getDivisor(N - R);

        long result = 0;
        for (Long num : candidates) {
            if (N % num == R) {
                result += num;
            }
        }
        System.out.print(result);
    }

    private static Set<Long> getDivisor(long num) {
        Set<Long> divisorSet = new HashSet<>();
        for (long i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                divisorSet.add(i);
                divisorSet.add(num / i);
            }
        }
        return divisorSet;
    }

}
