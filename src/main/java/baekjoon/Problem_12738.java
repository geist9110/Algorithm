package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_12738 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[N];
        dp[0] = A[0];
        int lastIndex = 1;

        for (int i = 1; i < N; i++) {
            int left = 0;
            int right = lastIndex;
            while (left < right) {
                int mid = (left + right) / 2;
                if (dp[mid] < A[i]) {
                    left = mid + 1;
                    continue;
                }
                right = mid;
            }

            dp[right] = A[i];
            if (right == lastIndex) {
                lastIndex++;
            }
        }

        System.out.print(lastIndex);
    }
}
