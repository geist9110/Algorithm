package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_6549 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());

            if (n == 0) {
                break;
            }

            long[] height = new long[n];
            for (int i = 0; i < n; i++) {
                height[i] = Long.parseLong(st.nextToken());
            }

            long area = 0;
            Stack<Integer> stack = new Stack<>();
            int index = 0;

            while (index < n) {
                if (stack.isEmpty() || height[stack.peek()] <= height[index]) {
                    stack.push(index++);
                    continue;
                }

                int top = stack.pop();
                area = Math.max(area,
                    height[top] * (stack.isEmpty() ? index : index - stack.peek() - 1));
            }

            while (!stack.isEmpty()) {
                int top = stack.pop();
                area = Math.max(area,
                    height[top] * (stack.isEmpty() ? index : index - stack.peek() - 1));
            }

            sb.append(area).append("\n");
        }
        System.out.print(sb);
    }
}
