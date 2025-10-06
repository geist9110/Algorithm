package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_29160 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        List<PriorityQueue<Integer>> list = new ArrayList<>(12);

        for (int i = 0; i <= 11; i++) {
            list.add(new PriorityQueue<>(Comparator.reverseOrder()));
        }

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int position = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            list.get(position).add(value);
        }

        for (int year = 0; year < K; year++) {
            for (int position = 1; position <= 11; position++) {
                if (list.get(position).isEmpty()) {
                    continue;
                }

                int value = list.get(position).poll();
                list.get(position).add(Math.max(value - 1, 0));
            }
        }

        int result = 0;
        for (int position = 1; position <= 11; position++) {
            PriorityQueue<Integer> pq = list.get(position);
            if (pq.isEmpty()) {
                continue;
            }

            result += pq.poll();
        }

        System.out.print(result);
    }
}
