package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_14254 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String password = br.readLine();
        int K = Integer.parseInt(br.readLine());

        int result = 0;
        int diff = password.length() - K;

        for (int i = 0; i < diff; i++) {
            int[] charCount = new int[26];
            int totalCount = 0;
            for (int j = i; j < password.length(); j += diff) {
                charCount[password.charAt(j) - 'a']++;
                totalCount++;
            }

            int max = 0;
            for (int count : charCount) {
                max = Math.max(max, count);
            }
            result += totalCount - max;
        }

        System.out.print(result);
    }

}
