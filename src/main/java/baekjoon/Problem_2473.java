package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2473 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        long[] liquidArray = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            liquidArray[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(liquidArray);

        long[] result = new long[3];
        long resultLiquidSum = Long.MAX_VALUE;

        for (int middle = 1; middle < N - 1; middle++) {
            int start = 0, end = N - 1;

            while (start < middle && middle < end) {
                long liquidSum = liquidArray[start] + liquidArray[middle] + liquidArray[end];
                if (Math.abs(liquidSum) < Math.abs(resultLiquidSum)) {
                    result[0] = liquidArray[start];
                    result[1] = liquidArray[middle];
                    result[2] = liquidArray[end];
                    resultLiquidSum = liquidSum;
                }

                if (liquidSum < 0) {
                    start++;
                    continue;
                }
                end--;

            }
        }

        System.out.printf("%d %d %d", result[0], result[1], result[2]);
    }
}
