package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_2847 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] array = new int[N];
        for (int i = 0; i < N; i++) {
            array[i] = Integer.parseInt(br.readLine());
        }

        int result = 0;
        for (int i = N - 1, j = N - 2; j >= 0; i--, j--) {
            if (array[i] > array[j]) {
                continue;
            }

            result += array[j] - (array[i] - 1);
            array[j] = array[i] - 1;
        }

        System.out.print(result);
    }
}
