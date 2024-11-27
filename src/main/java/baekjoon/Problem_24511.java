package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_24511 implements ProblemInterface {

    private static final String QUEUE = "0";

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        String[] A = br.readLine().split(" ");
        String[] B = br.readLine().split(" ");
        int M = Integer.parseInt(br.readLine());
        StringTokenizer C = new StringTokenizer(br.readLine());

        for (int i = N - 1; i >= 0 && M > 0; i--) {
            if (A[i].equals(QUEUE)) {
                sb.append(B[i]).append(" ");
                M--;
            }
        }

        for (; M > 0; M--) {
            sb.append(C.nextToken()).append(" ");
        }

        System.out.print(sb.toString().trim());
    }
}
