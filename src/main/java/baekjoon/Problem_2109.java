package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_2109 implements ProblemInterface {

    private static class Talk {

        int pay;
        int day;

        public Talk(int pay, int day) {
            this.pay = pay;
            this.day = day;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new java.io.InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        List<Talk> talks = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            talks.add(new Talk(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        talks.sort(Comparator.comparingInt(talk -> talk.day));
        PriorityQueue<Talk> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt(talk -> talk.pay));

        for (Talk talk : talks) {
            if (priorityQueue.size() < talk.day) {
                priorityQueue.add(talk);
                continue;
            }

            if (priorityQueue.peek().pay < talk.pay) {
                priorityQueue.poll();
                priorityQueue.add(talk);
            }
        }

        int result = 0;
        for (Talk talk : priorityQueue) {
            result += talk.pay;
        }
        System.out.print(result);
    }
}
