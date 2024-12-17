package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1916 implements ProblemInterface {

    private static class Node {

        int vertex, weight;

        public Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M = Integer.parseInt(br.readLine());

        ArrayList<LinkedList<Node>> graph = new ArrayList<>(N + 1);
        for (int i = 0; i < N + 1; i++) {
            graph.add(new LinkedList<>());
        }

        for (int i = 0; i < M; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int depart = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            graph.get(depart).add(new Node(arrive, weight));
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        int depart = Integer.parseInt(st.nextToken());
        int arrive = Integer.parseInt(st.nextToken());

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(o1 -> o1.weight));
        int[] distance = new int[N + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[depart] = 0;

        queue.add(new Node(depart, 0));

        while (!queue.isEmpty()) {
            Node node = queue.poll();

            if (distance[node.vertex] < node.weight) {
                continue;
            }

            for (Node next : graph.get(node.vertex)) {
                int nextDistance = distance[node.vertex] + next.weight;

                if (nextDistance < distance[next.vertex]) {
                    distance[next.vertex] = nextDistance;
                    queue.add(new Node(next.vertex, nextDistance));
                }
            }
        }

        System.out.print(distance[arrive]);
    }
}
