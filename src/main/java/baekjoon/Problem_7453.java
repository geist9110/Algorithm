package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_7453 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] A = new long[n];
        long[] B = new long[n];
        long[] C = new long[n];
        long[] D = new long[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            A[i] = Integer.parseInt(st.nextToken());
            B[i] = Integer.parseInt(st.nextToken());
            C[i] = Integer.parseInt(st.nextToken());
            D[i] = Integer.parseInt(st.nextToken());
        }

        long[] AB = new long[n * n];
        long[] CD = new long[n * n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                AB[i * n + j] = A[i] + B[j];
                CD[i * n + j] = C[i] + D[j];
            }
        }

        Arrays.sort(AB);
        Arrays.sort(CD);

        int left = 0, right = n * n - 1;

        long result = 0;
        while (left < n * n && right >= 0) {
            long sum = AB[left] + CD[right];
            if (sum == 0) {
                long leftCount = 1;
                long rightCount = 1;

                while (left + 1 < n * n && AB[left] == AB[left + 1]) {
                    left++;
                    leftCount++;
                }

                while (right > 0 && CD[right] == CD[right - 1]) {
                    right--;
                    rightCount++;
                }

                result += leftCount * rightCount;
                left++;
                continue;
            }

            if (sum > 0) {
                right--;
                continue;
            }

            left++;
        }

        System.out.print(result);

    }
}
