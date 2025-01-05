package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2467 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] array = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        int start = 0, end = N - 1;
        long sum;
        int startResult = start, endResult = end;
        long absSumResult = Math.abs(array[startResult] + array[endResult]);

        while (start < end) {
            sum = array[start] + array[end];

            if (Math.abs(sum) <= absSumResult) {
                startResult = start;
                endResult = end;
                absSumResult = Math.abs(sum);
            }

            if (sum < 0) {
                start++;
            } else {
                end--;
            }
        }

        System.out.printf("%d %d", array[startResult], array[endResult]);
    }
}
