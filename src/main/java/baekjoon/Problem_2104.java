package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Problem_2104 implements ProblemInterface {

    private static long[] array;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        array = new long[N];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        System.out.print(getMaxScore(0, N - 1));
    }

    private static long getMaxScore(int start, int end) {
        if (start == end) {
            return array[start] * array[start];
        }

        int mid = (start + end) / 2;
        long result = Math.max(getMaxScore(start, mid), getMaxScore(mid + 1, end));

        int left = mid;
        int right = mid + 1;

        long minValue = Math.min(array[left], array[right]);
        long sum = array[left] + array[right];
        result = Math.max(result, minValue * sum);

        while (left > start || right < end) {
            if (right < end && (left == start || array[left - 1] < array[right + 1])) {
                right++;
                minValue = Math.min(minValue, array[right]);
                sum += array[right];
            } else {
                left--;
                minValue = Math.min(minValue, array[left]);
                sum += array[left];
            }
            result = Math.max(result, minValue * sum);
        }

        return result;
    }
}
