package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_25373 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long N = Long.parseLong(br.readLine());

        if (N == 1) {
            System.out.print("1");
            return;
        }

        if (N <= 3) {
            System.out.print("2");
            return;
        }

        if (N <= 6) {
            System.out.println("3");
            return;
        }

        if (N <= 10) {
            System.out.print("4");
            return;
        }

        if (N <= 15) {
            System.out.print("5");
            return;
        }

        if (N <= 21) {
            System.out.print("6");
            return;
        }

        if (N <= 28) {
            System.out.print("7");
            return;
        }

        if (N % 7 == 0) {
            System.out.print(N / 7 + 3);
            return;
        }

        System.out.print(N / 7 + 4);
    }
}
