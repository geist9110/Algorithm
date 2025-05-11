package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_7490 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            int N = Integer.parseInt(br.readLine());
            char[] operator = new char[N + 1];
            operator[1] = '+';
            dfs(2, operator);
            System.out.println();
        }
    }

    private static void dfs(int depth, char[] operator) {
        if (depth == operator.length) {
            int sum = 0;
            boolean flag = false;
            for (int i = 1; i < operator.length; ) {
                int n = i;
                int j = i + 1;
                while (j < operator.length) {
                    if (operator[j] != ' ') {
                        break;
                    }

                    n *= 10;
                    n += j++;
                }

                if (operator[i] == '+') {
                    sum += n;
                    flag = true;
                }

                if (operator[i] == '-') {
                    sum -= n;
                    flag = true;
                }

                i = j;
            }

            if (sum == 0 && flag) {
                StringBuilder sb = new StringBuilder("1");
                for (int i = 2; i < operator.length; i++) {
                    sb.append(operator[i]).append(i);
                }

                System.out.println(sb.toString());
            }
            return;
        }

        operator[depth] = ' ';
        dfs(depth + 1, operator);

        operator[depth] = '+';
        dfs(depth + 1, operator);

        operator[depth] = '-';
        dfs(depth + 1, operator);

    }
}
