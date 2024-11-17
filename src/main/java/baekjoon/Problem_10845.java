package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_10845 implements ProblemInterface {

    static int[] queue = new int[10_000];
    static int head = 0;
    static int tail = 0;
    static final int EMPTY = 1;
    static final int NOT_EMPTY = 0;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String command = br.readLine();
            if (command.equals("pop")) {
                sb.append(pop()).append("\n");
                continue;
            }
            if (command.equals("size")) {
                sb.append(size()).append("\n");
                continue;
            }
            if (command.equals("empty")) {
                sb.append(empty()).append("\n");
                continue;
            }
            if (command.equals("front")) {
                sb.append(front()).append("\n");
                continue;
            }
            if (command.equals("back")) {
                sb.append(back()).append("\n");
                continue;
            }
            if (command.contains("push")) {
                push(Integer.parseInt(command.split(" ")[1]));
            }
        }
        System.out.print(sb.toString().trim());
    }

    private static void push(int x) {
        queue[tail++] = x;
    }

    private static int pop() {
        if (empty() == EMPTY) {
            return -1;
        }
        return queue[head++];
    }

    private static int empty() {
        return head == tail ? EMPTY : NOT_EMPTY;
    }

    private static int size() {
        return tail - head;
    }

    private static int front() {
        if (empty() == EMPTY) {
            return -1;
        }
        return queue[head];
    }

    private static int back() {
        if (empty() == EMPTY) {
            return -1;
        }
        return queue[tail - 1];
    }
}
