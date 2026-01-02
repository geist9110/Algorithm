package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_2591 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String cards = br.readLine();
        int[] numbers = new int[cards.length() + 1];
        for (int i = 1; i <= cards.length(); i++) {
            numbers[i] = cards.charAt(i - 1) - '0';
        }

        int[] dp = new int[cards.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= cards.length(); i++) {
            if (numbers[i] != 0) {
                dp[i] += dp[i - 1];
            }

            int twoDigit = numbers[i - 1] * 10 + numbers[i];
            if (10 <= twoDigit && twoDigit <= 34) {
                dp[i] += dp[i - 2];
            }
        }

        System.out.print(dp[cards.length()]);
    }

}
