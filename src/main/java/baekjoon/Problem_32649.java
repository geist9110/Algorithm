package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_32649 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        if (B % A != 0 || B / A < K) {
            System.out.print(-1);
            return;
        }

        int count = 0;
        for (int a = A; a < B; a += A) {
            if (B % a == 0) {
                sb.append(a).append(" ");
                count++;
            }

            if (count == K - 1) {
                sb.append(B);
                count++;
                break;
            }
        }

        if (count != K) {
            System.out.print(-1);
            return;
        }

        System.out.print(sb);
    }
}
