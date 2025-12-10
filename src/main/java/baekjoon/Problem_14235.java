package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collections;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_14235 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = Integer.parseInt(br.readLine()); i > 0; i--) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());

            if (a == 0) {
                if (pq.isEmpty()) {
                    sb.append("-1\n");
                    continue;
                }

                sb.append(pq.poll()).append("\n");
                continue;
            }

            for (int j = 0; j < a; j++) {
                pq.add(Integer.parseInt(st.nextToken()));
            }
        }

        System.out.print(sb);
    }

}
