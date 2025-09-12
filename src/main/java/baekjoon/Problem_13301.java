package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_13301 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        long prev = 0;
        long current = 1;
        for (int i = 1; i < N; i++) {
            long temp = current;
            current += prev;
            prev = temp;
        }

        System.out.print(current * 4 + prev * 2);
    }
}
