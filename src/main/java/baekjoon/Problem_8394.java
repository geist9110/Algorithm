package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_8394 implements ProblemInterface {

    private static final int MOD = 10;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int temp;
        int current = 1;
        int prev = 1;

        for (int i = 2; i <= n; i++) {
            temp = current;
            current += prev;
            current %= MOD;
            prev = temp;
        }

        System.out.print(current);
    }
}
