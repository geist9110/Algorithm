package baekjoon;

import baekjoon.config.ProblemInterface;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.StringTokenizer;

public class Problem_18126 implements ProblemInterface {

    private static List<List<Edge>> edges;
    private static long maxDistance;
    private static boolean[] visited;

    private static class Edge {

        int to;
        int weight;

        public Edge(int to, int weight) {
            this.to = to;
            this.weight = weight;
        }
    }

    public void solution(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        edges = new ArrayList<>();
        visited = new boolean[N + 1];
        maxDistance = 0;

        for (int i = 0; i <= N; i++) {
            edges.add(new LinkedList<>());
        }

        for (int i = 1; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            edges.get(start).add(new Edge(end, weight));
            edges.get(end).add(new Edge(start, weight));
        }

        visited[1] = true;
        dfs(1, 0);
        System.out.print(maxDistance);
    }

    private static void dfs(int current, long distance) {
        maxDistance = Math.max(maxDistance, distance);
        for (Edge edge : edges.get(current)) {
            if (visited[edge.to]) {
                continue;
            }

            visited[edge.to] = true;
            dfs(edge.to, distance + edge.weight);
        }
    }
}
