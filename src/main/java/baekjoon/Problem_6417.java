package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_6417 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            int N = Integer.parseInt(br.readLine());
            if (N == -1) {
                break;
            }

            boolean flag = false;
            int k = (int) Math.sqrt(N) + 1;
            while (k > 1) {
                int tempN = N;
                int count = 0;
                for (int i = 0; i < k && tempN % k == 1; i++, count++) {
                    tempN -= 1;
                    tempN -= tempN / k;
                }

                if (count == k && tempN % k == 0) {
                    flag = true;
                    break;
                }

                k--;
            }

            sb.append(N).append(" coconuts, ");
            if (flag) {
                sb.append(k).append(" people and 1 monkey\n");
            } else {
                sb.append("no solution\n");
            }
        }

        System.out.print(sb);
    }
}
