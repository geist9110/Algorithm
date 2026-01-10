package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import baekjoon.config.ProblemInterface;

public class Problem_35030 implements ProblemInterface {

    private static final int MAX = 100_001;
    private static boolean[] isNotPrime = new boolean[MAX + 1];

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isNotPrime = new boolean[MAX + 1];
        isNotPrime[0] = true;
        isNotPrime[1] = true;
        for (int i = 2; i * i <= MAX; i++) {
            for (int j = i * i; j <= MAX; j += i) {
                isNotPrime[j] = true;
            }
        }

        int[] specialNumberCount = new int[MAX + 1];
        for (int i = 1; i < MAX; i++) {
            specialNumberCount[i] = specialNumberCount[i - 1];
            if (isSpecialNumber(i)) {
                specialNumberCount[i]++;
            }
        }

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            int N = Integer.parseInt(br.readLine());
            sb.append(specialNumberCount[N]).append('\n');
        }
        System.out.print(sb);
    }

    private static boolean isSpecialNumber(int number) {
        if (isNotPrime[number + 1]) {
            return false;
        }

        for (int i = 10; i <= number; i *= 10) {
            int front = number / i;
            int back = number % i;
            if (isNotPrime[front * back + 1]) {
                return false;
            }
        }

        return true;
    }

}
