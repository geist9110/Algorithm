package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2143 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        long T = Long.parseLong(br.readLine());

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        long[] firstArray = new long[n];
        for (int i = 0; i < n; i++) {
            firstArray[i] = Long.parseLong(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine(), " ");
        long[] secondArray = new long[m];
        for (int i = 0; i < m; i++) {
            secondArray[i] = Long.parseLong(st.nextToken());
        }

        Map<Long, Long> firstSubSumMap = new HashMap<>();
        for (int i = 0; i < firstArray.length; i++) {
            long sum = 0;
            for (int j = i; j < firstArray.length; j++) {
                sum += firstArray[j];
                firstSubSumMap.put(sum, firstSubSumMap.getOrDefault(sum, 0L) + 1);
            }
        }

        long count = 0;
        for (int i = 0; i < secondArray.length; i++) {
            long sum = 0;
            for (int j = i; j < secondArray.length; j++) {
                sum += secondArray[j];
                count += firstSubSumMap.getOrDefault(T - sum, 0L);
            }
        }

        System.out.print(count);
    }
}
