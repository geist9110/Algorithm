package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_20003 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        long[] denominators = new long[N];
        long[] numerator = new long[N];

        long commonDenominator = 1;

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            long A = Long.parseLong(st.nextToken());
            long B = Long.parseLong(st.nextToken());

            long gcd = getGcd(A, B);
            A /= gcd;
            B /= gcd;

            commonDenominator = getLcm(commonDenominator, B);
            numerator[i] = A;
            denominators[i] = B;
        }

        long commonNumerator = 0;
        for (int i = 0; i < N; i++) {
            numerator[i] *= commonDenominator / denominators[i];
            commonNumerator = getGcd(numerator[i], commonNumerator);
        }

        long gcd = getGcd(commonNumerator, commonDenominator);
        System.out.printf("%d %d", commonNumerator / gcd, commonDenominator / gcd);
    }

    private static long getGcd(long a, long b) {
        if (b == 0) {
            return a;
        }
        return getGcd(b, a % b);
    }

    private static long getLcm(long a, long b) {
        return a / getGcd(a, b) * b;
    }
}
