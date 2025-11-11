package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

import baekjoon.config.ProblemInterface;

public class Problem_1835 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());

        Deque<Integer> deque = new ArrayDeque<>();

        while (N > 0) {
            deque.addFirst(N);
            for (int i = N % deque.size(); i > 0; i--) {
                deque.addFirst(deque.pollLast());
            }
            N--;
        }

        while (!deque.isEmpty()) {
            sb.append(deque.pollFirst()).append(" ");
        }

        System.out.print(sb);
    }
}
