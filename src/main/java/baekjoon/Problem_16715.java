package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_16715 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long n = Long.parseLong(br.readLine());
        long resultSum = 0;
        long resultBase = 0;
        for (long base = n; base >= 2; base--) {
            long sum = 0;
            long remain = n;
            while (remain > 0) {
                sum += remain % base;
                remain /= base;
            }
            if (sum >= resultSum) {
                resultSum = sum;
                resultBase = base;
            }
        }

        System.out.printf("%d %d", resultSum, resultBase);
    }

}
