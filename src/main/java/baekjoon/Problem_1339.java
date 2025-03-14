package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import baekjoon.config.ProblemInterface;

public class Problem_1339 implements ProblemInterface {

    private static final int ALPHABET_SIZE = 26;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] numbers = new int[ALPHABET_SIZE];
        for (int i = 0; i < N; i++) {
            String number = br.readLine();
            for (int j = 0, weight = (int) Math.pow(10, number.length() - 1); j < number
                    .length(); j++, weight /= 10) {
                numbers[number.charAt(j) - 'A'] += weight;
            }
        }

        Arrays.sort(numbers);

        int result = 0;
        for (int i = ALPHABET_SIZE - 1, j = 9; j > 0; i--, j--) {
            result += numbers[i] * j;
        }

        System.out.print(result);
    }

}
