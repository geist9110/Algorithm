package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_26090 implements ProblemInterface {

    private static final int MAX = 1000001;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        boolean[] isNotPrime = new boolean[MAX];
        isNotPrime[0] = isNotPrime[1] = true;
        for (int i = 2; i * i < MAX; i++) {
            if (!isNotPrime[i]) {
                for (int j = i * i; j < MAX; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] prefixSum = new int[N + 1];
        for (int i = 1; i <= N; i++) {
            int num = Integer.parseInt(st.nextToken());
            prefixSum[i] = prefixSum[i - 1] + num;
        }

        int result = 0;
        for (int i = 2; i < MAX; i++) {
            if (isNotPrime[i]) {
                continue;
            }
            for (int j = 0; j + i <= N; j++) {
                int sum = prefixSum[j + i] - prefixSum[j];
                if (!isNotPrime[sum]) {
                    result++;
                }
            }
        }

        System.out.print(result);
    }

}
