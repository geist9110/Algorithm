package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_18124 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if (N == 1) {
            System.out.print(0);
            return;
        }

        long result = 1;
        while (result * 2 < N) {
            result = result << 1;
        }
        System.out.print(result - 1 + (N + 1) / 2);
    }
}
