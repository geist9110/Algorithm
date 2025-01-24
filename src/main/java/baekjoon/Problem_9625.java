package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_9625 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int K = Integer.parseInt(br.readLine());

        int[] A = new int[K + 1];
        int[] B = new int[K + 1];

        A[0] = 1;

        for (int i = 1; i <= K; i++) {
            B[i] = A[i - 1] + B[i - 1];
            A[i] = B[i - 1];
        }

        System.out.printf("%d %d", A[K], B[K]);
    }

}
