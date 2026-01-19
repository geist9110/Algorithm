package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_1206 implements ProblemInterface {

    private static int[] averages;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        averages = new int[N];
        for (int i = 0; i < N; i++) {
            averages[i] = getAverage(br.readLine());
        }

        for (int personCount = 1; personCount <= 1000; personCount++) {
            if (canPossible(personCount)) {
                System.out.print(personCount);
                return;
            }
        }
    }

    private static int getAverage(String str) {
        String[] parts = str.split("\\.");
        return Integer.parseInt(parts[0]) * 1000 + Integer.parseInt(parts[1]);
    }

    private static boolean canPossible(int personCount) {
        for (int avg : averages) {
            int minSum = 0;
            int maxSum = personCount * 10;
            boolean isPossible = false;

            while (minSum <= maxSum) {
                int midSum = (minSum + maxSum) / 2;
                int currentAvg = (midSum * 1000) / personCount;

                if (currentAvg == avg) {
                    isPossible = true;
                    break;
                }

                if (currentAvg > avg) {
                    maxSum = midSum - 1;
                    continue;
                }

                minSum = midSum + 1;
            }

            if (!isPossible) {
                return false;
            }
        }

        return true;
    }

}
