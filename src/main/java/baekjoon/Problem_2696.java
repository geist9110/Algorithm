package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2696 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int T = Integer.parseInt(br.readLine());
        for (int i = 0; i < T; i++) {
            PriorityQueue<Integer> leftSide = new PriorityQueue<>(Collections.reverseOrder());
            PriorityQueue<Integer> rightSide = new PriorityQueue<>();

            int M = Integer.parseInt(br.readLine());
            sb.append(M / 2 + 1).append("\n");
            StringTokenizer st = new StringTokenizer(br.readLine());

            leftSide.add(Integer.parseInt(st.nextToken()));
            sb.append(leftSide.peek()).append(" ");

            for (int j = 2; j <= M; j++) {
                int num = Integer.parseInt(st.nextToken());

                if (leftSide.peek() < num) {
                    rightSide.add(num);
                } else {
                    leftSide.add(num);
                }

                if (leftSide.size() > rightSide.size() + 1) {
                    rightSide.add(leftSide.poll());
                }

                if (leftSide.size() < rightSide.size()) {
                    leftSide.add(rightSide.poll());
                }

                if (j % 2 == 1) {
                    sb.append(leftSide.peek()).append(" ");
                }

                if (j % 10 == 0 && j != M) {
                    st = new StringTokenizer(br.readLine());

                    if (j % 20 == 0) {
                        sb.append("\n");
                    }
                }
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
