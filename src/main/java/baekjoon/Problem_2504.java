package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Problem_2504 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s = br.readLine();

        int result = 0;
        int multiply = 1;
        Stack<Character> operator = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char op = s.charAt(i);

            if (op == '(' || op == '[') {
                operator.add(op);
                if (op == '(') {
                    multiply *= 2;
                    continue;
                }
                multiply *= 3;
                continue;
            }

            if (operator.isEmpty()) {
                result = 0;
                break;
            }

            char prevOp = operator.pop();
            if (prevOp == '(' && op == ')') {
                if (s.charAt(i - 1) == prevOp) {
                    result += multiply;
                }
                multiply /= 2;
                continue;
            }

            if (prevOp == '[' && op == ']') {
                if (s.charAt(i - 1) == prevOp) {
                    result += multiply;
                }
                multiply /= 3;
                continue;
            }

            result = 0;
            break;
        }

        if (operator.isEmpty()) {
            System.out.print(result);
            return;
        }
        System.out.print(0);
    }
}
