package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_9527 implements ProblemInterface {

    private static long[] prefixSumArray;
    private static long[] powArray;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long start = Long.parseLong(st.nextToken());
        long end = Long.parseLong(st.nextToken());

        prefixSumArray = new long[log2Floor(end) + 1];
        powArray = new long[log2Floor(end) + 1];

        powArray[0] = 1L;
        for (int i = 1; i < prefixSumArray.length; i++) {
            prefixSumArray[i] = (prefixSumArray[i - 1] << 1) + powArray[i - 1];
            powArray[i] = powArray[i - 1] << 1;
        }

        System.out.print(countOneBitSum(end) - countOneBitSum(start - 1));
    }

    private static int log2Floor(long number) {
        return Long.SIZE - Long.numberOfLeadingZeros(number) - 1;
    }

    private static long countOneBitSum(long number) {
        long count = 0;
        while (number != 0) {
            int log2 = log2Floor(number);
            count += prefixSumArray[log2];
            number -= powArray[log2];
            count += (number + 1);
        }

        return count;
    }
}
