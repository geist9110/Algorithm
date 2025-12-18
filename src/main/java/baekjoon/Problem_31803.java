package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_31803 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());
        if (N % 2 == 0) {
            N--;
        }

        long result = 1;
        for (long i = 1; i <= N; i += 2) {
            result *= i;
        }
        System.out.print(result);
    }

}
