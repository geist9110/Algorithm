package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_25180 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        for (int num = 9; num >= 1; num--) {
            int count = N / num;
            int mod = N % num;

            if (count % 2 == 0 || mod == 0) {
                result += count;
                N = mod;
            } else {
                result += count - 1;
                N -= (count - 1) * num;
            }
        }
        System.out.print(result);
    }
}
