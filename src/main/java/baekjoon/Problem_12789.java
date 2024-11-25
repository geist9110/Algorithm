package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_12789 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int head = 1;
        Stack<Integer> stack = new Stack<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int index = Integer.parseInt(st.nextToken());
            st.hasMoreTokens();
            index = Integer.parseInt(st.nextToken())
        ) {
            while (!stack.isEmpty() && stack.peek() == head) {
                stack.pop();
                head++;
            }

            if (index == head) {
                head++;
                continue;
            }

            if (!stack.isEmpty() && stack.peek() < index) {
                System.out.print("Sad");
                return;
            }

            stack.push(index);
        }
        System.out.print("Nice");
    }
}
