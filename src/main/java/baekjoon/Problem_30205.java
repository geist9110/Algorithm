package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

import baekjoon.config.ProblemInterface;

public class Problem_30205 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        long P = Long.parseLong(st.nextToken());

        PriorityQueue<Long> pq = new PriorityQueue<>();
        int item = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                long s = Long.parseLong(st.nextToken());
                if (s == -1) {
                    item++;
                    continue;
                }
                pq.add(s);
            }

            while (!pq.isEmpty()) {
                while (P < pq.peek() && item > 0) {
                    P *= 2;
                    item--;
                }

                if (P < pq.peek()) {
                    System.out.print(0);
                    return;
                }

                P += pq.poll();
            }

            while (item > 0) {
                P *= 2;
                item--;
            }

        }
        System.out.print(1);
    }

}
