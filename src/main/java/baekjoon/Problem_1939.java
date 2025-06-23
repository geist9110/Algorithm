package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1939 implements ProblemInterface {

    private static class Node {

        int arrive;
        int weightLimit;

        public Node(int arrive, int weightLimit) {
            this.arrive = arrive;
            this.weightLimit = weightLimit;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int weightLimit = Integer.parseInt(st.nextToken());
            graph.get(a).add(new Node(b, weightLimit));
            graph.get(b).add(new Node(a, weightLimit));
        }

        st = new StringTokenizer(br.readLine());
        int depart = Integer.parseInt(st.nextToken());
        int arrive = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>(
            (o1, o2) -> Integer.compare(o2.weightLimit, o1.weightLimit)
        );

        int[] weightLimit = new int[N + 1];
        boolean[] visited = new boolean[N + 1];
        queue.add(new Node(depart, Integer.MAX_VALUE));
        weightLimit[depart] = Integer.MAX_VALUE;
        while (!queue.isEmpty()) {
            Node node = queue.poll();
            if (visited[node.arrive]) {
                continue;
            }

            if (node.arrive == arrive) {
                break;
            }

            visited[node.arrive] = true;

            for (Node nextNode : graph.get(node.arrive)) {
                int minWeight = Math.min(weightLimit[node.arrive], nextNode.weightLimit);

                if (minWeight <= weightLimit[nextNode.arrive]) {
                    continue;
                }

                weightLimit[nextNode.arrive] = Math.max(weightLimit[nextNode.arrive], minWeight);
                queue.add(new Node(nextNode.arrive, weightLimit[nextNode.arrive]));
            }
        }

        System.out.print(weightLimit[arrive]);
    }
}
