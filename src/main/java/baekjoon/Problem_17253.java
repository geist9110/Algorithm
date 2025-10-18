package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_17253 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        long N = Long.parseLong(br.readLine());

        if (N == 0) {
            System.out.print("NO");
            return;
        }

        while (N > 1) {
            if (N % 3 > 1) {
                System.out.print("NO");
                return;
            }

            N /= 3;
        }

        System.out.print("YES");
    }
}
