package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_17626 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        topDown();
    }

    private static void downTop() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int maxSquareNumber = (int) Math.sqrt(n);

        int[] resultArray = new int[n + 1];
        Arrays.fill(resultArray, Integer.MAX_VALUE);
        resultArray[0] = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 1; j <= maxSquareNumber; j++) {
                int nextNumber = i + j * j;
                if (nextNumber <= n) {
                    resultArray[nextNumber] = Math.min(resultArray[i] + 1, resultArray[nextNumber]);
                    continue;
                }
                break;
            }
        }

        System.out.print(resultArray[n]);
    }

    private static void topDown() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] resultArray = new int[n + 1];
        Arrays.fill(resultArray, Integer.MAX_VALUE);

        int maxSquareNumber = (int) Math.sqrt(n);
        for (int i = 1; i <= maxSquareNumber; i++) {
            resultArray[i * i] = 1;
        }

        solve(n, resultArray);
        System.out.println(resultArray[n]);
    }

    private static void solve(int n, int[] resultArray) {
        for (
            int i = (int) Math.sqrt(n), next = n - i * i;
            i >= 1 && next > 0;
            i--, next = n - i * i
        ) {
            if (resultArray[next] == Integer.MAX_VALUE) {
                solve(next, resultArray);
            }
            resultArray[n] = Math.min(resultArray[n], 1 + resultArray[next]);
        }
    }
}
