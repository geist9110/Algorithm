package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_31799 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        String s = br.readLine();

        char[] degree = new char[N];
        char[] scale = new char[N];

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            degree[index] = s.charAt(i);
            scale[index] = '0';

            if (i + 1 >= s.length()) {
                continue;
            }

            if (s.charAt(i + 1) == '+'
                || s.charAt(i + 1) == '-'
                || s.charAt(i + 1) == '0') {
                scale[index] = s.charAt(i + 1);
                i++;
            }
            index++;
        }

        for (int i = 0; i < N; i++) {
            if (degree[i] == 'C') {
                sb.append("B");
                continue;
            }

            if (degree[i] == 'B' && (scale[i] == '0' || scale[i] == '-')) {
                if (i == 0 || (degree[i - 1] == 'C')) {
                    sb.append("D");
                } else {
                    sb.append("B");
                }
                continue;
            }

            if ((degree[i] == 'A' && scale[i] == '-') || (degree[i] == 'B' && scale[i] == '+')) {
                if (i == 0 || degree[i - 1] == 'C' || (degree[i - 1] == 'B' && (scale[i - 1] == '-'
                    || scale[i - 1] == '0'))) {
                    sb.append("P");
                } else {
                    sb.append("D");

                }
                continue;
            }

            if (degree[i] == 'A' && scale[i] == '0') {
                if (i == 0 || degree[i - 1] == 'C' || degree[i - 1] == 'B' || (degree[i - 1] == 'A'
                    && scale[i - 1] == '-')) {
                    sb.append("E");
                } else {
                    sb.append("P");
                }
                continue;
            }

            sb.append("E");
        }

        System.out.print(sb);
    }
}
