package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_30825 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        long sum = 0;
        long currentNum = 0;
        for (int i = 0; i < N; i++) {
            if (arr[i] > currentNum) {
                sum += (arr[i] - currentNum) * i;
                currentNum = arr[i] + K;
                continue;
            }

            sum += currentNum - arr[i];
            currentNum += K;
        }

        System.out.print(sum);
    }
}
