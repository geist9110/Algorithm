package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Problem_1238 implements ProblemInterface {

    private static final int MAX_VALUE = 1_000_000;

    private static class Edge {

        int arrive, distance;

        public Edge(int arrive, int distance) {
            this.arrive = arrive;
            this.distance = distance;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int X = Integer.parseInt(st.nextToken());

        ArrayList<ArrayList<Edge>> graph = new ArrayList<>();
        ArrayList<ArrayList<Edge>> reverseGraph = new ArrayList<>();

        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
            reverseGraph.add(new ArrayList<>());
        }

        for (int i = 1; i <= M; i++) {
            st = new StringTokenizer(br.readLine());
            int depart = Integer.parseInt(st.nextToken());
            int arrive = Integer.parseInt(st.nextToken());
            int distance = Integer.parseInt(st.nextToken());
            graph.get(depart).add(new Edge(arrive, distance));
            reverseGraph.get(arrive).add(new Edge(depart, distance));
        }

        int[] fromXToEachDistances = dijkstra(X, graph);
        int[] fromEachToXDistances = dijkstra(X, reverseGraph);

        int result = 0;
        for (int i = 1; i <= N; i++) {
            result = Math.max(result, fromEachToXDistances[i] + fromXToEachDistances[i]);
        }

        System.out.println(result);
    }

    private static int[] dijkstra(int start, ArrayList<ArrayList<Edge>> graph) {
        PriorityQueue<Edge> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        int[] distanceArray = new int[graph.size() + 1];
        Arrays.fill(distanceArray, MAX_VALUE);
        distanceArray[start] = 0;
        queue.add(new Edge(start, 0));

        while (!queue.isEmpty()) {
            Edge edge = queue.poll();
            if (distanceArray[edge.arrive] < edge.distance) {
                continue;
            }

            for (Edge next : graph.get(edge.arrive)) {
                int distance = edge.distance + next.distance;

                if (distanceArray[next.arrive] > distance) {
                    distanceArray[next.arrive] = distance;
                    queue.add(new Edge(next.arrive, distance));
                }
            }
        }

        return distanceArray;
    }
}
