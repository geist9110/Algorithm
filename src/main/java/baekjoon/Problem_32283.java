package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_32283 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[][] combination = new int[N + 1][N + 1];

        for (int n = 0; n <= N; n++) {
            combination[n][0] = 1;
            combination[n][n] = 1;
            for (int k = 1; k < n; k++) {
                combination[n][k] = combination[n - 1][k] + combination[n - 1][k - 1];
            }
        }

        String binaryNumber = br.readLine();
        int oneCount = Integer.bitCount(Integer.parseInt(binaryNumber, 2));

        int result = 0;
        for (int i = 0; i < oneCount; i++) {
            result += combination[N][i];
        }

        for (int i = N - 1; i >= oneCount; i--) {
            if (binaryNumber.charAt(i) == '1') {
                result += combination[i][oneCount--];
            }
        }

        System.out.print(result);

    }
}
