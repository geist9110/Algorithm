package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_28278 implements ProblemInterface {

    private static int[] stack = new int[1_000_000];
    private static int top = 0;

    private static final String PUSH = "1";
    private static final String POP = "2";
    private static final String SIZE = "3";
    private static final String IS_EMPTY = "4";
    private static final String PEEK = "5";
    private static final int EMPTY = 1;
    private static final int NOT_EMPTY = 0;
    private static final int STACK_EMPTY_EXCEPTION = -1;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String[] command = br.readLine().split(" ");
            if (command[0].equals(PUSH)) {
                int X = Integer.parseInt(command[1]);
                push(X);
                continue;
            }
            if (command[0].equals(POP)) {
                sb.append(pop()).append("\n");
                continue;
            }
            if (command[0].equals(SIZE)) {
                sb.append(size()).append("\n");
                continue;
            }
            if (command[0].equals(IS_EMPTY)) {
                sb.append(isEmpty()).append("\n");
                continue;
            }
            if (command[0].equals(PEEK)) {
                sb.append(peek()).append("\n");
            }
        }
        System.out.print(sb.toString().trim());
    }

    private static void push(int n) {
        stack[top++] = n;
    }

    private static int pop() {
        if (isEmpty() == EMPTY) {
            return STACK_EMPTY_EXCEPTION;
        }
        return stack[--top];
    }

    private static int size() {
        return top;
    }

    private static int isEmpty() {
        if (top == 0) {
            return EMPTY;
        }
        return NOT_EMPTY;
    }

    private static int peek() {
        if (isEmpty() == EMPTY) {
            return STACK_EMPTY_EXCEPTION;
        }
        return stack[top - 1];
    }
}
