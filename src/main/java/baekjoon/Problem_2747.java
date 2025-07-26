package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2747 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long prev = 0;
        long result = 1;
        for (int i = 1; i < n; i++) {
            long temp = result;
            result = result + prev;
            prev = temp;
        }

        System.out.print(result);
    }
}
