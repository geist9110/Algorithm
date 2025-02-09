package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_11055 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N + 1];
        int[] sum = new int[N + 1];
        int maxSum = 0;
        for (int i = 1; i <= N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            for (int j = 0; j < i; j++) {
                if (array[i] > array[j]) {
                    sum[i] = Math.max(sum[i], sum[j] + array[i]);
                }
                maxSum = Math.max(maxSum, sum[i]);
            }
        }

        System.out.print(maxSum);
    }

}
