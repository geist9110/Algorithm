package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Problem_28279 implements ProblemInterface {

    private static final String PUSH_FRONT = "1";
    private static final String PUSH_BACK = "2";
    private static final String POP_FRONT = "3";
    private static final String POP_BACK = "4";
    private static final String SIZE = "5";
    private static final String IS_EMPTY = "6";
    private static final String PEEK_FRONT = "7";
    private static final String PEEK_BACK = "8";

    private static final int EMPTY = 1;
    private static final int NOT_EMPTY = 0;

    private static final int DEQUE_INDEX_EXCEPTION = -1;

    private static final int DEQUE_MAX_INDEX = 1_000_000;
    private static final int[] deque = new int[DEQUE_MAX_INDEX];
    private static int head = 0;
    private static int tail = 0;

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            String[] operation = br.readLine().split(" ");
            if (operation[0].equals(PUSH_FRONT)) {
                pushFront(Integer.parseInt(operation[1]));
                continue;
            }
            if (operation[0].equals(PUSH_BACK)) {
                pushBack(Integer.parseInt(operation[1]));
                continue;
            }
            if (operation[0].equals(POP_FRONT)) {
                sb.append(popFront()).append("\n");
                continue;
            }
            if (operation[0].equals(POP_BACK)) {
                sb.append(popBack()).append("\n");
                continue;
            }
            if (operation[0].equals(SIZE)) {
                sb.append(size()).append("\n");
                continue;
            }
            if (operation[0].equals(IS_EMPTY)) {
                sb.append(isEmpty()).append("\n");
                continue;
            }
            if (operation[0].equals(PEEK_FRONT)) {
                sb.append(peekFront()).append("\n");
                continue;
            }
            if (operation[0].equals(PEEK_BACK)) {
                sb.append(peekBack()).append("\n");
            }
        }
        System.out.print(sb.toString().trim());
    }

    private static void pushFront(int X) {
        head = (head - 1 + DEQUE_MAX_INDEX) % DEQUE_MAX_INDEX;
        deque[head] = X;
    }

    private static void pushBack(int X) {
        deque[tail] = X;
        tail = (tail + 1) % DEQUE_MAX_INDEX;
    }

    private static int popFront() {
        if (isEmpty() == EMPTY) {
            return DEQUE_INDEX_EXCEPTION;
        }
        int value = deque[head];
        head = (head + 1) % DEQUE_MAX_INDEX;
        return value;
    }

    private static int popBack() {
        if (isEmpty() == EMPTY) {
            return DEQUE_INDEX_EXCEPTION;
        }

        tail = (tail - 1 + DEQUE_MAX_INDEX) % DEQUE_MAX_INDEX;
        return deque[tail];
    }

    private static int size() {
        if (tail >= head) {
            return tail - head;
        }
        return DEQUE_MAX_INDEX - head + tail;
    }

    private static int isEmpty() {
        if (head == tail) {
            return EMPTY;
        }
        return NOT_EMPTY;
    }

    private static int peekFront() {
        if (isEmpty() == EMPTY) {
            return DEQUE_INDEX_EXCEPTION;
        }
        return deque[head];
    }

    private static int peekBack() {
        if (isEmpty() == EMPTY) {
            return DEQUE_INDEX_EXCEPTION;
        }
        int tailIndex = tail - 1;
        if (tailIndex < 0) {
            return deque[DEQUE_MAX_INDEX - 1];
        }
        return deque[tailIndex];
    }
}
