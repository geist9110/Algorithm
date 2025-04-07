package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_2493 implements ProblemInterface {

    private static class Node {

        int value;
        int index;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Stack<Node> stack = new Stack<>();
        for (int i = 1; i <= N; i++) {
            int nextNumber = Integer.parseInt(st.nextToken());

            while (!stack.isEmpty() && stack.peek().value < nextNumber) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                sb.append(0).append(" ");
                stack.push(new Node(nextNumber, i));
                continue;
            }

            sb.append(stack.peek().index).append(" ");
            stack.push(new Node(nextNumber, i));
        }

        System.out.print(sb);

    }
}
