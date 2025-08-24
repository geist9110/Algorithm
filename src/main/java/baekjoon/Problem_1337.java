package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Problem_1337 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = (Integer.parseInt(br.readLine()));
        }
        Arrays.sort(array);

        int result = 4;
        for (int start = 0; start < N; start++) {
            for (int end = Math.min(N - 1, start + 5); end > start; end--) {
                if (array[end] - array[start] > 4) {
                    continue;
                }

                result = Math.min(result, 4 - (end - start));
            }
        }
        System.out.print(result);
    }
}
