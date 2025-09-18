package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_9047 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            String N = br.readLine();

            int count = 0;
            while (!N.equals("6174")) {
                char[] temp = N.toCharArray();
                Arrays.sort(temp);
                int big = Integer.parseInt(
                    new StringBuilder(new String(temp)).reverse().toString());
                int small = Integer.parseInt(new String(temp));

                N = String.valueOf(big - small);
                N = "0".repeat(4 - N.length()) + N;
                count++;
            }

            sb.append(count).append("\n");
        }
        System.out.println(sb);
    }
}
