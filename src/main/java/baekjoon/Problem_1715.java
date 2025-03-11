package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import baekjoon.config.ProblemInterface;

public class Problem_1715 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        for (int i = 0; i < N; i++) {
            queue.add(Integer.parseInt(br.readLine()));
        }

        long result = 0;
        while (queue.size() > 1) {
            int nextDeck = queue.poll() + queue.poll();
            result += nextDeck;
            queue.add(nextDeck);
        }

        System.out.print(result);
    }

}
