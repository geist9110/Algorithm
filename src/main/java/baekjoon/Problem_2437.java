package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2437 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] weight = new int[N];
        for (int i = 0; i < N; i++) {
            weight[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(weight);

        int currentWeight = 0;
        for (int nextWeight : weight) {
            if (currentWeight + 1 < nextWeight) {
                break;
            }
            currentWeight += nextWeight;
        }

        System.out.print(currentWeight + 1);
    }

}
