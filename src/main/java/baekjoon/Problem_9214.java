package baekjoon;

import baekjoon.config.ProblemInterface;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_9214 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String n = br.readLine();
        int index = 1;
        while (!n.equals("0")) {
            sb.append("Test ").append(index++).append(": ").append(getFirstTerm(n)).append("\n");
            n = br.readLine();
        }
        System.out.print(sb);
    }

    private static String getFirstTerm(String s) {
        String prevTerm = getPrevTerm(s);

        if (s.equals(prevTerm)) {
            return s;
        }

        String prevNextTerm = getNextTerm(prevTerm);
        if (!s.equals(prevNextTerm)) {
            return s;
        }

        return getFirstTerm(prevTerm);
    }

    private static String getPrevTerm(String s) {
        if (s.length() % 2 != 0) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i += 2) {
            for (int j = 0; j < s.charAt(i) - '0'; j++) {
                sb.append(s.charAt(i + 1));
            }
        }
        return sb.toString();
    }

    private static String getNextTerm(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            int count = 0;
            char currentChar = s.charAt(i);

            for (; i < s.length(); i++) {
                if (s.charAt(i) != currentChar) {
                    i--;
                    break;
                }

                count++;
            }

            sb.append(count).append(currentChar);
        }
        return sb.toString();
    }
}
