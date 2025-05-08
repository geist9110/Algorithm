package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_12919 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String S = br.readLine();
        StringBuilder T = new StringBuilder(br.readLine());
        boolean result = dfs(S, T);
        if (result) {
            System.out.print("1");
            return;
        }
        System.out.println("0");
    }

    private static boolean dfs(String S, StringBuilder T) {
        if (S.length() == T.length()) {
            return S.contentEquals(T);
        }

        boolean result = false;

        if (T.charAt(T.length() - 1) == 'A') {
            StringBuilder copy = new StringBuilder(T);
            result |= dfs(S, copy.deleteCharAt(T.length() - 1));
        }

        if (T.charAt(0) == 'B') {
            StringBuilder copy = new StringBuilder(T);
            result |= dfs(S, copy.deleteCharAt(0).reverse());
        }

        return result;
    }
}
