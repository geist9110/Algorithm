package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Problem_30088 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] array = new long[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int worker = Integer.parseInt(st.nextToken());
            for (int j = 0; j < worker; j++) {
                array[i] += Long.parseLong(st.nextToken());
            }
        }

        Arrays.sort(array);
        long sum = array[0];
        for (int i = 1; i < N; i++) {
            array[i] += array[i - 1];
            sum += array[i];
        }

        System.out.print(sum);
    }
}
