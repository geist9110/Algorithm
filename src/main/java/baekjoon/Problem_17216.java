package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_17216 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        int[] sum = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
            sum[i] = array[i];
            for (int j = i - 1; j >= 0; j--) {
                if (array[i] < array[j]) {
                    sum[i] = Math.max(sum[i], sum[j] + array[i]);
                }
            }
        }

        int result = 0;
        for (int num : sum) {
            result = Math.max(result, num);
        }
        System.out.print(result);
    }
}
