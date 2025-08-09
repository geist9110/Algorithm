package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_5904 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int k = 0;
        int lengthPerK = 3;

        while (lengthPerK < N) {
            k++;
            lengthPerK *= 2;
            lengthPerK += k + 3;
        }

        System.out.print(getNChar(N, k, lengthPerK));
    }

    private static char getNChar(int n, int k, int lengthPerK) {
        if (k == 0) {
            if (n == 1) {
                return 'm';
            }
            return 'o';
        }

        int nextLengthPerK = (lengthPerK - (k + 3)) / 2;
        if (n <= nextLengthPerK) {
            return getNChar(n, k - 1, nextLengthPerK);
        }

        if (lengthPerK - nextLengthPerK <= n) {
            return getNChar(n - (lengthPerK - nextLengthPerK), k - 1, nextLengthPerK);
        }

        if (n - nextLengthPerK == 1) {
            return 'm';
        }
        return 'o';
    }
}
