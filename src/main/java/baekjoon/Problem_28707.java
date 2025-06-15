package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_28707 implements ProblemInterface {

    private static class Modifier {

        int l;
        int r;
        int w;

        public Modifier(int l, int r, int c) {
            this.l = l;
            this.r = r;
            this.w = c;
        }
    }

    private static class Node {

        int[] index;
        int weight;

        public Node(int[] index, int weight) {
            this.index = index;
            this.weight = weight;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] A = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            A[i] = Integer.parseInt(st.nextToken());
        }

        int M = Integer.parseInt(br.readLine());
        ArrayList<Modifier> modifier = new ArrayList<>(M);
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            modifier.add(
                new Modifier(
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken()) - 1,
                    Integer.parseInt(st.nextToken())
                )
            );
        }

        Map<Integer, Integer> results = new HashMap<>();
        results.put(arrayToInt(A), 0);

        PriorityQueue<Node> priorityQueue = new PriorityQueue<>(
            Comparator.comparingInt(o -> o.weight)
        );
        priorityQueue.add(new Node(A, 0));

        while (!priorityQueue.isEmpty()) {
            Node node = priorityQueue.poll();

            for (Modifier m : modifier) {
                Node nextNode = new Node(swap(node.index, m), node.weight + m.w);
                int num = arrayToInt(nextNode.index);

                if (results.containsKey(num) && results.get(num) <= nextNode.weight) {
                    continue;
                }

                results.put(num, nextNode.weight);
                priorityQueue.add(nextNode);
            }
        }

        Arrays.sort(A);
        System.out.print(results.getOrDefault(arrayToInt(A), -1));
    }

    private static int arrayToInt(int[] array) {
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            result *= 10;
            result += array[i];
        }
        return result;
    }

    private static int[] swap(int[] n, Modifier m) {
        int[] result = Arrays.copyOf(n, n.length);
        int temp = result[m.l];
        result[m.l] = result[m.r];
        result[m.r] = temp;
        return result;
    }
}
