package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1202 implements ProblemInterface {

    private static class Jewel {

        int weight;
        int price;

        Jewel(int weight, int price) {
            this.weight = weight;
            this.price = price;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        PriorityQueue<Jewel> jewelArray = new PriorityQueue<>(N, (o1, o2) -> {
            if (o1.weight == o2.weight) {
                return o2.price - o1.price;
            }
            return o1.weight - o2.weight;
        });

        List<Integer> backPackCapacityArray = new ArrayList<>(K);

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelArray.add(new Jewel(
                Integer.parseInt(st.nextToken()),
                Integer.parseInt(st.nextToken())
            ));
        }

        for (int i = 0; i < K; i++) {
            backPackCapacityArray.add(Integer.parseInt(br.readLine()));
        }

        backPackCapacityArray.sort(Integer::compareTo);

        PriorityQueue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        long result = 0;
        for (Integer backPackCapacity : backPackCapacityArray) {

            while (!jewelArray.isEmpty() && jewelArray.peek().weight <= backPackCapacity) {
                queue.add(jewelArray.poll().price);
            }

            if (!queue.isEmpty()) {
                result += queue.poll();
            }
        }
        bw.write(String.valueOf(result));
        bw.flush();
    }
}
