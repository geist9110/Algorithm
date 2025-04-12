package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;

public class Problem_17413 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String s = br.readLine();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == ' ') {
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
                bw.write(c);
            } else if (c == '<') {
                while (!stack.isEmpty()) {
                    bw.write(stack.pop());
                }
                while (c != '>') {
                    bw.write(c);
                    c = s.charAt(++i);
                }
                bw.write(c);
            } else {
                stack.add(c);
            }
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop());
        }

        bw.flush();
    }
}
