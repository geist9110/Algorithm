package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_2118 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        long[] prefixSum = new long[N + 1];
        for (int i = 1; i <= N; i++) {
            prefixSum[i] = prefixSum[i - 1] + Long.parseLong(br.readLine());
        }

        long maxDistance = 0;
        int left = 0, right = 1;
        while (left < N - 1 && right < N) {
            long clockwiseSum = prefixSum[right] - prefixSum[left];
            long counterClockwiseSum = prefixSum[N] - clockwiseSum;
            long distance = Math.min(clockwiseSum, counterClockwiseSum);
            maxDistance = Math.max(maxDistance, distance);

            if (clockwiseSum < counterClockwiseSum) {
                right++;
                continue;
            }

            left++;
            if (left == right) {
                right++;
            }
        }

        System.out.print(maxDistance);
    }

}
