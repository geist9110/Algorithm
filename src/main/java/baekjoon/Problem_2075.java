package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;
import baekjoon.config.ProblemInterface;

public class Problem_2075 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int next = Integer.parseInt(st.nextToken());
                if (pq.size() < n) {
                    pq.add(next);
                    continue;
                }
                if (pq.peek() < next) {
                    pq.poll();
                    pq.add(next);
                }
            }
        }

        System.out.println(pq.peek());
    }
}
