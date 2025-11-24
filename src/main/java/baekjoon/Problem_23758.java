package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_23758 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(array);
        int result = 1;
        for (int i = (N + 1) / 2 - 1; i >= 0; i--) {
            result += log2Decimal(array[i]);
        }

        System.out.print(result);
    }

    public static int log2Decimal(int n) {
        return 31 - Integer.numberOfLeadingZeros(n);
    }

}
