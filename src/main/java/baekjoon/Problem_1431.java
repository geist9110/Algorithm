package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

import baekjoon.config.ProblemInterface;

public class Problem_1431 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String[] serials = new String[N];
        for (int i = 0; i < N; i++) {
            serials[i] = br.readLine();
        }
        Arrays.sort(serials, (s1, s2) -> {
            if (s1.length() != s2.length()) {
                return Integer.compare(s1.length(), s2.length());
            }
            int sum1 = getDigitSum(s1);
            int sum2 = getDigitSum(s2);
            if (sum1 != sum2) {
                return Integer.compare(sum1, sum2);
            }
            return s1.compareTo(s2);
        });

        StringBuilder sb = new StringBuilder();
        for (String serial : serials) {
            sb.append(serial).append('\n');
        }

        System.out.print(sb);
    }

    private static int getDigitSum(String s) {
        int sum = 0;

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (Character.isDigit(c)) {
                sum += c - '0';
            }
        }

        return sum;
    }

}
