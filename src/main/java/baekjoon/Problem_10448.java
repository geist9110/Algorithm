package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10448 implements ProblemInterface {

    private static final int MAX_INDEX = 46;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] triangleNumbers = new int[MAX_INDEX];
        for (int i = 1; i < MAX_INDEX; i++) {
            triangleNumbers[i] = triangleNumbers[i - 1] + i;
        }

        boolean[] isEurekaNumber = new boolean[1001];
        for (int i = 1; i < MAX_INDEX; i++) {
            for (int j = i; j < MAX_INDEX; j++) {
                for (int k = j; k < MAX_INDEX; k++) {
                    int sum = triangleNumbers[i] + triangleNumbers[j] + triangleNumbers[k];
                    if (sum <= 1000) {
                        isEurekaNumber[sum] = true;
                    }
                }
            }
        }

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            int n = Integer.parseInt(br.readLine());
            if (isEurekaNumber[n]) {
                sb.append(1).append("\n");
                continue;
            }
            sb.append(0).append("\n");
        }
        System.out.print(sb);
    }
}
