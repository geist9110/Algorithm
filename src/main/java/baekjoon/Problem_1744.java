package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import baekjoon.config.ProblemInterface;

public class Problem_1744 implements ProblemInterface {

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int result = 0;
        PriorityQueue<Integer> positiveQueue = new PriorityQueue<>((o1, o2) -> o2 - o1);
        PriorityQueue<Integer> negativeQueue = new PriorityQueue<>();

        for (int i = 0; i < N; i++) {
            int nextValue = Integer.parseInt(br.readLine());

            if (nextValue == 1) {
                result += nextValue;
                continue;
            }

            if (nextValue > 0) {
                positiveQueue.add(nextValue);
                continue;
            }

            negativeQueue.add(nextValue);
        }

        System.out.print(result + sumQueue(positiveQueue) + sumQueue(negativeQueue));
    }

    private static int sumQueue(PriorityQueue<Integer> queue) {
        int result = 0;
        while (!queue.isEmpty()) {
            if (queue.size() > 1) {
                result += queue.poll() * queue.poll();
                continue;
            }

            if (queue.size() == 1) {
                result += queue.poll();
            }
        }
        return result;
    }
}
