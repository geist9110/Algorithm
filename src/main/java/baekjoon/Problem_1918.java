package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.function.Predicate;

public class Problem_1918 implements ProblemInterface {

    private static Stack<Character> stack;
    private static StringBuilder sb;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        char[] infixNotation = br.readLine().toCharArray();
        stack = new Stack<>();

        Predicate<Character> condition = c -> !isOpenParenthesis(c);
        for (char infix : infixNotation) {
            if (isCloseParenthesis(infix)) {
                popStack(condition);
                stack.pop();
                continue;
            }

            if (isAddOperator(infix)) {
                popStack(condition);
            }

            if (isMultiplyOperator(infix)) {
                popStack(c -> condition.test(c) && !isAddOperator(c));
            }

            stack.push(infix);
        }

        popStack(c -> true);

        System.out.print(sb);
    }

    private static void popStack(Predicate<Character> condition) {
        while (!stack.isEmpty() && condition.test(stack.peek())) {
            sb.append(stack.pop());
        }
    }

    private static boolean isMultiplyOperator(char c) {
        return c == '*' || c == '/';
    }

    private static boolean isAddOperator(char c) {
        return c == '+' || c == '-';
    }

    private static boolean isOpenParenthesis(char c) {
        return c == '(';
    }

    private static boolean isCloseParenthesis(char c) {
        return c == ')';
    }
}

