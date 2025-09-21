package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_14381 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());

        for (int t = 1; t <= T; t++) {
            int N = Integer.parseInt(br.readLine());
            sb.append("Case #").append(t).append(": ");
            if (N == 0) {
                sb.append("INSOMNIA\n");
                continue;
            }

            int multiply = 1;
            boolean[] check = new boolean[10];
            int checkCount = 0;
            while (true) {
                String n = String.valueOf(N * multiply);
                for (int i = 0; i < n.length(); i++) {
                    int num = n.charAt(i) - '0';
                    if(!check[num]) {
                        check[num] = true;
                        checkCount++;
                    }
                }

                if (checkCount == 10) {
                    sb.append(n).append("\n");
                    break;
                }

                multiply++;
            }
        }

        System.out.print(sb);
    }
}
