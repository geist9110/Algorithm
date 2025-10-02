package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_27919 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String s = br.readLine();

        int ucCount = 0;
        int dpCount = 0;

        for (char c : s.toCharArray()) {
            if (c == 'U' || c == 'C') {
                ucCount++;
                continue;
            }
            dpCount++;
        }

        if (ucCount > dpCount - dpCount / 2) {
            sb.append("U");
        }

        if (dpCount > 0) {
            sb.append("DP");
        }

        System.out.print(sb);
    }
}
