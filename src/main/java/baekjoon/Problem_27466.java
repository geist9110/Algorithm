package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_27466 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        String S = br.readLine();

        Stack<Character> stack = new Stack<>();
        for (int i = S.length() - 1; i >= 0; i--) {
            char c = S.charAt(i);

            if (stack.isEmpty()) {
                if (isConsonant(c)) {
                    stack.add(c);
                }
                continue;
            }

            if (stack.size() < 3) {
                if (c == 'A') {
                    stack.add(c);
                }
                continue;
            }

            stack.add(c);
        }

        if (stack.size() < M) {
            System.out.print("NO");
            return;
        }
        sb.append("YES\n");

        while (stack.size() > M) {
            stack.pop();
        }

        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        System.out.print(sb);
    }

    private static boolean isConsonant(char c) {
        return c != 'A' && c != 'E' && c != 'I' && c != 'O' && c != 'U';
    }
}
