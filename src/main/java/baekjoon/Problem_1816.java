package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_1816 implements ProblemInterface {

    private static final int MAX_RANGE = 1_000_001;
    private static boolean[] isNotPrime;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        isNotPrime = new boolean[MAX_RANGE];
        for (int i = 2; i * i < MAX_RANGE; i++) {
            for (int j = i * i; j < MAX_RANGE; j += i) {
                isNotPrime[j] = true;
            }
        }

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            long S = Long.parseLong(br.readLine());

            if (isSafetyPrime(S)) {
                sb.append("YES");
            } else {
                sb.append("NO");
            }

            sb.append("\n");
        }

        System.out.print(sb);
    }

    private static boolean isSafetyPrime(long n) {
        int range = Math.min((int) Math.sqrt(n) + 1, MAX_RANGE);
        for (int i = 2; i < range; i++) {
            if (!isNotPrime[i] && n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
