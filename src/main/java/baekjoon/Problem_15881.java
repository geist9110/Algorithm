package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_15881 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String s = br.readLine();

        int result = 0;
        for (int i = 0; i < n - 3; i++) {
            if (s.charAt(i) == 'p'
                && s.charAt(i + 1) == 'P'
                && s.charAt(i + 2) == 'A'
                && s.charAt(i + 3) == 'p') {
                result++;
                i += 3;
            }
        }

        System.out.print(result);
    }
}
