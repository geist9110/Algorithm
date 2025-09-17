package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.StringTokenizer;

public class Problem_21394 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        for (int T = Integer.parseInt(br.readLine()); T > 0; T--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int[] array = new int[10];
            for (int i = 1; i <= 9; i++) {
                array[i] = Integer.parseInt(st.nextToken());
            }
            array[9] += array[6];
            array[6] = 0;

            Queue<Integer> queue = new LinkedList<>();
            Stack<Integer> stack = new Stack<>();
            for (int i = 9; i >= 1; i--) {
                while (array[i] > 0) {
                    if (array[i] >= 2) {
                        queue.add(i);
                        stack.add(i);
                        array[i] -= 2;
                        continue;
                    }

                    if (array[i] == 1) {
                        if (queue.size() == stack.size()) {
                            queue.add(i);
                            array[i] -= 1;
                        } else if (queue.size() > stack.size()) {
                            stack.add(i);
                            array[i] -= 1;
                        }
                    }
                }
            }

            while (!queue.isEmpty()) {
                sb.append(queue.poll()).append(" ");
            }
            while (!stack.isEmpty()) {
                sb.append(stack.pop()).append(" ");
            }
            sb.append("\n");
        }

        System.out.print(sb);
    }
}
