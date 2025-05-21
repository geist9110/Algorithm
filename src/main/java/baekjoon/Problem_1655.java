package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Problem_1655 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int mid = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> bigHeap = new PriorityQueue<>();
        PriorityQueue<Integer> smallHeap = new PriorityQueue<>((a, b) -> b - a);

        sb.append(mid).append("\n");
        for (int i = 1; i < N; i++) {
            int value = Integer.parseInt(br.readLine());

            if (value >= mid) {
                bigHeap.add(value);
            } else {
                smallHeap.add(value);
            }

            if (!bigHeap.isEmpty() && bigHeap.size() - 1 > smallHeap.size()) {
                smallHeap.add(mid);
                mid = bigHeap.poll();
            }
            if (!smallHeap.isEmpty() && smallHeap.size() - 1 >= bigHeap.size()) {
                bigHeap.add(mid);
                mid = smallHeap.poll();
            }

            sb.append(mid).append("\n");
        }

        System.out.print(sb);
    }
}
