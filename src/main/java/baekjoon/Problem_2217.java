package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import baekjoon.config.ProblemInterface;

public class Problem_2217 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] weightCount = new int[10_001];
        int maxWeight = 0;
        for (int i = 0; i < N; i++) {
            int weight = Integer.parseInt(br.readLine());
            weightCount[weight]++;
            maxWeight = Math.max(maxWeight, weight);
        }

        for (int weight = maxWeight, count = 0; weight > 0; weight--) {
            count += weightCount[weight];
            maxWeight = Math.max(maxWeight, weight * count);
        }

        System.out.print(maxWeight);
    }

}
