package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2446 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        StringBuilder sb = new StringBuilder();
        for (int i = N; i >= -N; i--) {
            if (i == 0 || i == -1) {
                continue;
            }

            for (int j = Math.abs(i); j < N; j++) {
                sb.append(" ");
            }

            for (int j = 0; j < 2 * Math.abs(i) - 1; j++) {
                sb.append("*");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
